package Bai20_21_ThucHanh_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.anhtester.constants.ConfigData.URL;

public class LoginPage {
    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Khai báo các element dạng đối tượng By (phương thức tìm kiếm)
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[@id='alerts']");

    //Khai báo hàm xây dựng, để truyền driver từ bên ngoài vào chính class này sử dụng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //driver = _driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    // cac ham trung gian
    private void setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        driver.findElement(buttonLogin).click();
    }

    public void verifyLoginSuccess(){
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail(){
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "Content of error message NOT match.");
    }

    //Các hàm xử lý cho chính trang này
//    public void loginCRM(String email, String password) {
//       driver.get(URL); //Gọi từ class ConfigData dạng biến static
//       System.out.println("Navigate to URL" + URL);
//       //Goi cac ham trung gian xuong LoginCRM
//       setEmail(email);
//       setPassword(password);
//       clickLoginButton();
//    }
    public DashboardPage loginCRM(String email, String password) {
        driver.get(URL); //Gọi từ class ConfigData dạng biến static
        //Goi cac ham trung gian xuong LoginCRM
        setEmail(email);
        setPassword(password);
        clickLoginButton();
        return new DashboardPage(driver);
    }
    public void verifyRedirectLoginPage(){
        System.out.println("Verify redirect to Login Page");
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Chua den duoc trang Login");
        Assert.assertTrue(driver.findElement(headerPage).isDisplayed(), "Header of page NOT displays");
        Assert.assertEquals(driver.findElement(headerPage).getText(), "Login123", "Content of header for Login page NOT match.");
    }
}
