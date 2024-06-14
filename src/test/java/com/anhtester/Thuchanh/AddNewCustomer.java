package Thuchanh;

import com.anhtester.common.BaseTest;
import locators.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewCustomer extends BaseTest {
    @Test
    public void testAddNewCustomer() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Header khong ton tai");
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Khong den duoc trang Dashboard"); sleep(1);
        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).isDisplayed(), "Khong den duoc trang Dashboard");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText(), "Customers Summary", "Ten header Customer Page không đúng");
        driver.findElement(By.xpath(LocatorCRM.buttonAddNewCustomer)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputCompanyName)).sendKeys("Selenium Java 02/06/23"); sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputVatNumber)).sendKeys("10"); sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputPhone)).sendKeys("123456"); sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputWebsite)).sendKeys("https://anhtester.com");
        sleep(1);
        //Dropdown Group dong
        driver.findElement(By.xpath("//label[normalize-space()='Groups']/following-sibling::div//button[@title='Nothing selected']")).click();
        driver.findElement(By.xpath("//button[@data-id='groups_in[]']/following-sibling::div//input[@aria-label='Search']")).sendKeys("VIP");
        sleep(1);
        driver.findElement(By.xpath("//button[@data-id='groups_in[]']/following-sibling::div//input[@aria-label='Search']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//button[@data-id='groups_in[]']")).click();
        //dropdown
        driver.findElement(By.xpath("//button[@data-id='default_currency']")).click();
        driver.findElement(By.xpath("//button[@data-id='default_currency']/following-sibling::div//input[@aria-label='Search']")).sendKeys("USD");
        sleep(1);
        driver.findElement(By.xpath("//button[@data-id='default_currency']/following-sibling::div//input[@aria-label='Search']")).sendKeys(Keys.ENTER);
        sleep(1);
        //dropdown tinh
        Select select = new Select(driver.findElement(By.xpath("//select[@id='default_language']")));
        select.selectByValue("polish");
        System.out.println(select.getFirstSelectedOption().getText());
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputAddress)).sendKeys("55 Smith Street");
        driver.findElement(By.xpath(LocatorCRM.inputCity)).sendKeys("Stacker");
        driver.findElement(By.xpath(LocatorCRM.inputState)).sendKeys("Bern");
        driver.findElement(By.xpath(LocatorCRM.inputZipCode)).sendKeys("12345");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.buttonCountry)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys("Switzerland");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys(Keys.ENTER);
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.buttonSave)).click();

    }
//@Test
   // public void testSearchResult(){

//}
    }


