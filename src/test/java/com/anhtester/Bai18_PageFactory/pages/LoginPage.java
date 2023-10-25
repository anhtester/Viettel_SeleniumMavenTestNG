package com.anhtester.Bai18_PageFactory.pages;

import com.anhtester.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    private String url = "https://crm.anhtester.com/admin/authentication";

    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Hàm xây dựng để truyền driver từ bên ngoài vào (có thể từ BaseTest,...)
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //Khai báo tất cả các object (element) trên page này
    //Thuộc kiểu đối tượng By (thuộc của Selenium)
    //By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    //By inputEmail = By.xpath("//input[@id='email']");
//    By inputPassword = By.xpath("//input[@id='password']");
//    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
//    By errorMessage = By.xpath("//div[@class='text-center alert alert-danger']");

    @FindBy(xpath = "//h1[normalize-space()='Login']")
    WebElement headerLoginPage;

//    @FindBy(xpath = "//input[@id='email']")
//    WebElement inputEmail;

    @FindAll(
            {@FindBy(xpath = "//input[@id='email']"), @FindBy(id = "email123")}
    )
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement buttonLogin;

    @FindBy(xpath = "//div[@class='text-center alert alert-danger']")
    WebElement errorMessage;

    @FindBy(how = How.XPATH, using = "//ul[@id='side-menu']//span[normalize-space()='Dashboard']")
    WebElement menuDashboard;

    @FindBys(@FindBy(xpath = "//ul[@id='side-menu']/li/a"))
    List<WebElement> listMenu;

    public void getListMenu() {
        for (int i = 0; i < listMenu.size(); i++) {
            System.out.println(listMenu.get(i).getText());
        }
    }

    //Xây dựng các hàm xử lý trên chính page này
    private void setInputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
        //driver.findElement(inputEmail).sendKeys(email);
        inputEmail.sendKeys(email);
        System.out.println("Set email value: " + email);
    }

    private void setInputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        //driver.findElement(inputPassword).sendKeys(password);
        inputPassword.sendKeys(password);
        System.out.println("Set email value: " + password);
    }

    private void clickButtonLogin() {
        wait.until(ExpectedConditions.visibilityOf(buttonLogin));
        //driver.findElement(buttonLogin).click();
        buttonLogin.click();
        System.out.println("Click on Login button: " + buttonLogin);
    }

    public void loginCRM(String email, String password) {
        driver.get(url);
        System.out.println("Navigate to URL: " + url);
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();
    }

    public void verifyLoginSuccess() {
        System.out.println("Verfiy login success");
        Assert.assertTrue(menuDashboard.isDisplayed(), "Menu Dashboard not displayed.");
    }

    public void verifyLoginFail() {
        System.out.println("Verfiy login fail");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error Message not displayed.");
        Assert.assertEquals(errorMessage.getText(), "Invalid email or password", "Content of Error Message not match.");
    }

}
