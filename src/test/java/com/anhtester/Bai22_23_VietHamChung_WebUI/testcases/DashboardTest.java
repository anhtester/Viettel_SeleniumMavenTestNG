package com.anhtester.Bai22_23_VietHamChung_WebUI.testcases;

import com.anhtester.Bai22_23_VietHamChung_WebUI.pages.CustomerPage;
import com.anhtester.Bai22_23_VietHamChung_WebUI.pages.DashboardPage;
import com.anhtester.Bai22_23_VietHamChung_WebUI.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage() {
        //loginPage = new LoginPage(driver);
        //loginPage.loginCRM("admin@example.com", "123456");
        //loginPage.verifyLoginSuccess();

        //dashboardPage = new DashboardPage(driver);
        //dashboardPage.clickMenuCustomers();

        //customerPage = new CustomerPage(driver);
        //customerPage.verifyRedirectCustomerPageSuccess();

        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyRedirectCustomerPageSuccess();

    }

    @Test
    public void testLogout() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        //dashboardPage = new DashboardPage(driver);
        loginPage = dashboardPage.logOut();
        loginPage.verifyRedirectLoginPage();

    }

}
