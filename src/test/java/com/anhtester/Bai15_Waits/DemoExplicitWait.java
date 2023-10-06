package com.anhtester.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWait {
    WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

    @Test(priority = 1)
    public void testLoginCRM_Success(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions);

        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email123']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
}
