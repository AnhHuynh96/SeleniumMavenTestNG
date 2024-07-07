package Bai20_21_ThucHanh_POM.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }
    private WebDriverWait wait;

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By dropdownProfile = By.xpath("//li[contains(@class,'icon header-user-profile')]");
    private By optionLogout = By.xpath("(//a[.='Logout'])[1]");
    private By optionMyProfile = By.xpath("(//a[normalize-space()='My Profile'])[2]");

    public CustomerPage clickMenuCustomers(){

        WebUI.clickElement(menuCustomers);
        System.out.println("CLick on menu Customers");
        return new CustomerPage(driver);
        }
    public void clickMenuProjects(){
        WebUI.clickElement(menuProjects);
        System.out.println("CLick on menu Projects");
    }
    public LoginPage logOut(){
        WebUI.clickElement(dropdownProfile);
        System.out.println("CLick on menu Profile");
        //WebUI.sleep(2);
        WebUI.clickElement(optionLogout);
        System.out.println("CLick on option Logout");
        return new LoginPage(driver);
    }


}
