package Bai22_23_VietHamChung_WebUI.testcases;

import Bai22_23_VietHamChung_WebUI.pages.CustomerPage;
import Bai22_23_VietHamChung_WebUI.pages.DashboardPage;
import Bai22_23_VietHamChung_WebUI.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    private String CUSTOMER_NAME = "Viettel ct1";

    @Test
    public void addNewCustomer() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyRedirectCustomerPageSuccess();
        customerPage.clickButtonAddNew();
        customerPage.inputDataCustomer(CUSTOMER_NAME);


    }

    @Test
    public void testLogin() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

    }
}
