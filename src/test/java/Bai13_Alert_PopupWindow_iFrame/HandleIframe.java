package Bai13_Alert_PopupWindow_iFrame;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleIframe extends BaseTest {
    @Test
    public void testIFrame01() throws InterruptedException {

        driver.navigate().to("https://anhtester.com/contact");
        Thread.sleep(10000);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        //----Switch to content of Messenger--------
        driver.switchTo().frame(0); //Thẻ iframe thứ nhất
        System.out.println(driver.findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------

        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame(); //Chuyển về nội dung chính không thuộc iframe nào

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1); //Thẻ iframe thứ hai
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        Thread.sleep(2000);
    }
    @Test
    public void testIFrameONVNExpress(){
        driver.get("https://vnexpress.net/");
        sleep(30);
        driver.switchTo().frame("google_ads_iframe_/27973503/Vnexpress/Desktop/Large1/Home_0");
        sleep(5);
        //String div = String.valueOf(driver.findElement(By.xpath("//div[contains(@id,'genecy_ifr_')]")).getSize());
       // System.out.println(div);
        driver.findElement(By.xpath("//div[contains(@id,'genecy_ifr_')]")).click();
        sleep(2);
    }
}
