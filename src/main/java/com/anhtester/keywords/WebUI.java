package com.anhtester.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebUI {

    //Khai báo
    private static WebDriverWait wait;
    private static WebDriver driver;

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Hàm xây dựng để truyền driver từ bên ngoài vào class này
    public WebUI(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Giống click()
    public static void clickElement(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    //Click element với thời gian chờ tuỳ biến
    public static void clickElement(String xpath, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void clickElement(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
    }

    //Giống sendKeys()
    public static void setText(String xpath, String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public static void setText(By by, String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(value);
    }
}
