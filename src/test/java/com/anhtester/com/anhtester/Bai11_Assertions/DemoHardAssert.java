package com.anhtester.Bai11_Assertions;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class DemoHardAssert extends BaseTest {
    @Test
    public void testLoginCRM() throws InterruptedException {


        driver.get("https://crm.anhtester.com/admin/authentication");
        //Assert header voi text cua no
        String header = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        System.out.println(header);
        Assert.assertEquals(header, "Login", "Gia tri header sai");

        //Assert button login
        boolean checkLoginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled();
        Assert.assertTrue(checkLoginButton, "nut Login duoc bat");

        //driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(1000);
    }
        @Test
        public void menuCustomer(){
            driver.get("https://crm.anhtester.com/admin/authentication");
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

            String menuName = driver.findElement(By.xpath("//span[normalize-space()='Customers']")).getText();
            Assert.assertTrue(menuName.contains("Customer123"), "Gia tri Menu Name khong chua gia tri mong muon " + menuName);

        }
    }


