package handle_components;

import com.anhtester.common.BaseTest;
import com.anhtester.helpers.SystemHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class HandleUploadFile extends BaseTest {
    @Test
    public void testUploadFileWithSendKeys() throws InterruptedException {
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        sleep(2);

        By inputFileUpload = By.xpath("//input[@name='upfile']");

        driver.findElement(inputFileUpload).sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Selenium_Logo_01.png");
        System.out.println("D:\\Selenium_Logo_01.png");
        sleep(4);
    }
    @Test
    public void testUploadFileWithRobotClass() throws InterruptedException {
        driver.get("https://files.fm/");

        Thread.sleep(2000);

        By textOnPage = By.xpath("//div[@id='file_select_dragndrop_text']");
        By divFileUpload = By.xpath("//div[@id='uploadifive-file_upload']");
        By inputFileUpload = By.xpath("//div[@id='file_select_button']//input[@id='file_upload']");

        String filePath = SystemHelper.getCurrentDir() +  "src\\test\\resources\\testdata\\Selenium_Logo_01.png";

        //Click để mở form upload
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(divFileUpload));
        driver.findElement(divFileUpload).click();
        Thread.sleep(3);

        // Khởi tạo Robot class
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        Thread.sleep(1000);

        // Nhấn Control+V để dán
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // Xác nhận Control V trên
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        Thread.sleep(1000);

        // Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        By fileName = By.xpath("//span[@class='filename']");
        Assert.assertTrue(driver.findElement(fileName).isDisplayed(), "File can not upload");
        Thread.sleep(4000);
    }
}
