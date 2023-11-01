package com.anhtester.Bai20_21_ThucHanh_POM.testcases;

import com.anhtester.Bai20_21_ThucHanh_POM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.testng.annotations.Test;

import java.util.ArrayList;

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
