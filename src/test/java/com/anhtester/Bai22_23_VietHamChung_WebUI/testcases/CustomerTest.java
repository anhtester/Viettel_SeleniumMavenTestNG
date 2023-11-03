package com.anhtester.Bai22_23_VietHamChung_WebUI.testcases;

import com.anhtester.Bai22_23_VietHamChung_WebUI.pages.CustomerPage;
import com.anhtester.Bai22_23_VietHamChung_WebUI.pages.DashboardPage;
import com.anhtester.Bai22_23_VietHamChung_WebUI.pages.LoginPage;
import com.anhtester.Bai22_23_VietHamChung_WebUI.pages.ProfilePage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    ProfilePage profilePage;

    private String CUSTOMER_NAME = "Viettel A5";

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customerPage = dashboardPage.clickMenuCustomers();

        customerPage.verifyRedirectCustomerPageSuccess();
        customerPage.clickButtonAddNew();
        customerPage.inputDataCustomer(CUSTOMER_NAME);
        dashboardPage.clickMenuCustomers();

        profilePage = customerPage.searchCustomer(CUSTOMER_NAME);
        profilePage.verifyCustomerDetail(CUSTOMER_NAME);

    }
}
