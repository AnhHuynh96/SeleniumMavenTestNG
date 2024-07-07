package Bai22_23_VietHamChung_WebUI.testcases;

import Bai22_23_VietHamChung_WebUI.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
   // Khai bao doi tuong class Login Page toan cuc
    LoginPage loginPage;

    @Test
    public void testLoginSuccess() {
        //Khoi tao doi tuong class LoginPage de truyen gia tri driver tu BaseTest
        //De class LoginPage nhan duoc gia tri driver thi moi thuc thi cac ham trong class Page duoc
        loginPage = new LoginPage(driver);

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("admin@example.com", "123456");
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginWithEmailInvalid() {
        loginPage = new LoginPage(driver);

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("admin123@example.com", "123456");
        waitForPageLoaded();
        loginPage.verifyLoginFail();
    }
}

