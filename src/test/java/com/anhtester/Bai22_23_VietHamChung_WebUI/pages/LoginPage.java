package com.anhtester.Bai22_23_VietHamChung_WebUI.pages;

import com.anhtester.keywords.WebUI;
import com.anhtester.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private String url = "https://crm.anhtester.com/admin/authentication";

    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Hàm xây dựng để truyền driver từ bên ngoài vào (có thể từ BaseTest,...)
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new WebUI(driver); //Bắt buộc
    }

    //Khai báo tất cả các object (element) trên page này
    //Thuộc kiểu đối tượng By (thuộc của Selenium)
    By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By errorMessage = By.xpath("//div[@class='text-center alert alert-danger']");

    //Xây dựng các hàm xử lý trên chính page này
    private void setInputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
//        driver.findElement(inputEmail).sendKeys(email);
//        System.out.println("Set email value: " + email);
        WebUI.setText(inputEmail, email);
    }

    private void setInputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
//        driver.findElement(inputPassword).sendKeys(password);
//        System.out.println("Set email value: " + password);
        WebUI.setText(inputPassword, password);
    }

    private void clickButtonLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
//        driver.findElement(buttonLogin).click();
//        System.out.println("Click on Login button: " + buttonLogin);
        WebUI.waitForElementVisible(buttonLogin);
        WebUI.clickElement(buttonLogin);
    }

    public DashboardPage loginCRM(String email, String password) {
        //driver.get(url);
        WebUI.openURL(url);
        //System.out.println("Navigate to URL: " + url);
        WebUI.waitForPageLoaded();
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();
        WebUI.waitForPageLoaded();
        return new DashboardPage(driver);
    }

    public void verifyLoginSuccess() {
        System.out.println("Verify login success");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Menu Dashboard not displayed.");
    }

    public void verifyLoginFail() {
        System.out.println("Verify login fail");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error Message not displayed.");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "Content of Error Message not match.");
    }

    public void verifyRedirectLoginPage() {
        System.out.println("Verify redirect to Login page");
        Assert.assertTrue(driver.findElement(headerLoginPage).isDisplayed(), "Header of Login page not displayed.");
        Assert.assertEquals(driver.findElement(headerLoginPage).getText(), "Login", "Content of header for Login page not match.");
    }

}
