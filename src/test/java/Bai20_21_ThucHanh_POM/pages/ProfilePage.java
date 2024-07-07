package Bai20_21_ThucHanh_POM.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProfilePage extends CustomerPage{
    private WebDriver driver;
    public ProfilePage (WebDriver driver){
        super(driver);
        this.driver = driver;
        new WebUI(driver);

    }
    public void verifyCustomerDetail(String companyName){
        Assert.assertEquals(driver.findElement(inputCompanyName).getAttribute("value"),"Viettel A2","Message");
    }

    }

