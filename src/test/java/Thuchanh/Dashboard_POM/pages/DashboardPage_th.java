package Thuchanh.Dashboard_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage_th {
    //private WebDriver driver;
    private WebDriverWait wait;

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By menuTasks = By.xpath("//span[normalize-space()='Tasks']");
    private By functionDashboardOption = By.xpath("//span[normalize-space()='//div[normalize-space()='Dashboard Options']");
    private By headerUserProfile = By.xpath("//li[@class='icon header-user-profile open']//child::ul//li[@class='header-logout']/a[normalize-space()='Logout']");

    public void clickMenuDashboard() {
    }

    //public dashboardPage(WebDriver driver){
       // this.driver = driver;
     //   wait =new WebDriverWait(driver, Duration.ofSeconds(5));
   // }
   // private void verifyDashboard(){
     //   wait.until(ExpectedConditions.visibilityOfElementLocated(menuDashboard));
       // Assert.assertTrue(driver.findElement(menuDashboard).isDisplayed(),"Khong vao duoc trang Dashboard success");
        //ssert.assertEquals(driver.findElement(menuDashboard).getText(),"Dashboard","Khong phai menuDashboard");
        
  //  }

    //public void ClickMenuDashboard() {
   // }

   // public void clickMenuDashboard() {
    //}
}
