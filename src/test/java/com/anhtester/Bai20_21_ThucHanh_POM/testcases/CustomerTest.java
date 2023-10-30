package com.anhtester.Bai20_21_ThucHanh_POM.testcases;

import com.anhtester.Bai20_21_ThucHanh_POM.pages.CustomerPage;
import com.anhtester.Bai20_21_ThucHanh_POM.pages.DashboardPage;
import com.anhtester.Bai20_21_ThucHanh_POM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    private String CUSTOMER_NAME = "Viettel A1";

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customerPage = dashboardPage.clickMenuCustomers();

        customerPage.verifyRedirectCustomerPageSuccess();
        customerPage.clickButtonAddNew();
        customerPage.inputDataCustomer(CUSTOMER_NAME);

    }
}
