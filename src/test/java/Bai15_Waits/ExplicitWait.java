package Bai15_Waits;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait extends BaseTest {
    @Test
    public void testExplicitWait01(){
        //driver = new ChromeDriver();
        //System.out.println("Created Driver");
        //driver.manage().window().maximize();
        driver.get("https://hrm.anhtester.com/");

        //Set timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("iusername")).sendKeys("admin_example");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Click menu du an
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Projects')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

        driver.findElement(By.xpath("//a[@class='collapsed btn waves-effect waves-light btn-primary btn-sm m-0']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']")));
        driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("Anh Tester");

        sleep(2);
        driver.quit();


    }
}
