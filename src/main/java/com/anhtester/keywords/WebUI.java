package com.anhtester.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {

    //Khai báo
    private static WebDriverWait wait;
    private static WebDriver driver;

    private static int TIMEOUT = 10;
    private static double STEP_TIME = 0;
    private static int PAGE_LOAD_TIMEOUT = 20;

    //Hàm xây dựng để truyền driver từ bên ngoài vào class này
    public WebUI(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logConsole(Object message) {
        System.out.println(message);
    }

    public static WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    public static Boolean checkElementExist(By by) {
        sleep(2);
        List<WebElement> listElement = driver.findElements(by);

        if (listElement.size() > 0) {
            System.out.println("checkElementExist: " + true + " --- " + by);
            return true;
        } else {
            System.out.println("checkElementExist: " + false + " --- " + by);
            return false;
        }
    }

    public static void openURL(String url) {
        driver.get(url);
        sleep(STEP_TIME);
        logConsole("Open URL: " + url);
    }

    public static void clickElement(String by) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(by)));
        waitForElementVisible(By.xpath(by));
        sleep(STEP_TIME);
        driver.findElement(By.xpath(by)).click();
        logConsole("Click element: " + by);
    }

    public static void setText(String by, String value) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(by)));
        waitForElementVisible(By.xpath(by));
        sleep(STEP_TIME);
        driver.findElement(By.xpath(by)).sendKeys(value);
        logConsole("Set text: " + value + " on element " + by);
    }

    public static void clickElement(By by) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        waitForElementVisible(by);
        sleep(STEP_TIME);
        driver.findElement(by).click();
        logConsole("Click element: " + by);
    }

    public static void clickElement(By by, int timeout) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        waitForElementVisible(by, timeout);
        sleep(STEP_TIME);
        driver.findElement(by).click();
        logConsole("Click element: " + by);
    }

    public static void setText(By by, String value) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        waitForElementVisible(by);
        sleep(STEP_TIME);
        driver.findElement(by).sendKeys(value);
        logConsole("Set text: " + value + " on element " + by);
    }

    public static String getElementText(By by) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        waitForElementVisible(by);
        sleep(STEP_TIME);
        String text = driver.findElement(by).getText();
        logConsole("Get text: " + text);
        return text; //Trả về một giá trị kiểu String
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            logConsole("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementVisible(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
            logConsole("Timeout waiting for the element Visible. " + by.toString());
        }
    }
}
