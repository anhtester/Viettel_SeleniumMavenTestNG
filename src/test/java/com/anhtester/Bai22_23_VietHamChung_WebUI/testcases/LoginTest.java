package com.anhtester.Bai22_23_VietHamChung_WebUI.testcases;

import com.anhtester.Bai22_23_VietHamChung_WebUI.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Khai báo đối tượng class LoginPage toàn cục
    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        System.out.println("=====testLoginCRM_Success=====");
        //Khởi tại đối tượng class LoginPage để truyền giá trị driver từ BaseTest
        //Để class LoginPage nhận được giá trị driver thì mới thực thi các hàm trong class page được
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCRM_EmailInvalid(){
        System.out.println("=====testLoginCRM_EmailInvalid=====");
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCRM_PasswordInvalid(){
        System.out.println("=====testLoginCRM_PasswordInvalid=====");
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123");
        loginPage.verifyLoginFail();
    }

}
