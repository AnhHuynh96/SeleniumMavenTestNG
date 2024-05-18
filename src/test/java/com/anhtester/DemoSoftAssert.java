package com.anhtester;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.Thread.sleep;
import static org.testng.asserts.SoftAssert.*;

public class DemoSoftAssert extends BaseTest{
    //Khai bao doi tuong SoftAssert
    //SoftAssert softAssert = new SoftAssert();
    //@AfterClass
    //public void setSoftAssertAllCases(){
       // softAssert.assertAll();//Tong hop lai tat ca cac truong hop Fail

        @Test
        public void testLoginCRM() throws InterruptedException {


            driver.get("https://crm.anhtester.com/admin/authentication");
            //Khai bao doi tuong SoftAssert
            SoftAssert softAssert = new SoftAssert();
            //Assert header voi text cua no
            String header = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
            System.out.println(header);
            softAssert.assertEquals(header, "Login123", "Gia tri header sai");

            //Assert button login
            boolean checkLoginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled();
            softAssert.assertTrue(checkLoginButton, "nut Login duoc bat");

            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
            String menuName = driver.findElement(By.xpath("//span[normalize-space()='Customers']")).getText();
            softAssert.assertTrue(menuName.contains("Customer123"), "Gia tri Menu Name khong chua gia tri mong muon " + menuName);
            softAssert.assertAll();//Tong hop lai tat ca cac truong hop Fail

            sleep(1000);

        }
    }




