package Bai19_NavigationPage.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CustomerPage {
    private WebDriver driver;
    public CustomerPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebDriverWait wait;

    private By buttonAddNew = By.xpath("//a[normalize-space()='New Customer']");
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By inputSearch = By.xpath("//div[@id='DataTables_Table_0_filter']//input[@type='search']");



    public void clickButtonAddNew(){
        //driver.findElement(buttonAddNew).click();
        WebUI.clickElement(buttonAddNew);
    }
    public void verifyRedirectCustomerPageSuccess(){
        Assert.assertTrue(driver.findElement(headerCustomerPage).isDisplayed(),"Khong tim thay Customer header page");
        Assert.assertEquals(driver.findElement(headerCustomerPage).getText(),"Customers Summary 123","Gia tri header khong dung");

    }

    public void searchCustomer(String customerName){
        driver.findElement(inputSearch).sendKeys(customerName);
    }


}
