package com.anhtester.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public  WebDriver driver;
//@BeforeMethod //Chay doc lap tung test case .Chay truoc moi @Test
//Chay lien tuc tung test case thi dung @BeforeClass
    //public  void createBrowser() {

        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
   // }
@BeforeMethod
@Parameters({"Browser"})
    public  void createBrowser(@Optional("chrome") String browserName) { //Neu muon chon browser thi phai them optional ( dung chayj xml)
    //public  void createBrowser( String browserName) {

        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        }
        if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        }
        if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
@AfterMethod
    public  void closeBrowser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
    public void sleep(double second){
    try {
        Thread.sleep((long) (1000 * second));
    } catch (InterruptedException e){
        throw new RuntimeException(e);
    }
    }
}
