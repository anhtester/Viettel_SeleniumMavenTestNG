package com.anhtester.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoImplicitWait {
    WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Element tồn tại - xuất hiện trong DOM
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); //Công dụng khi chuyển trang
    }

    @AfterMethod
    public void closeDriver(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.quit();
    }

    @Test(priority = 1)
    public void testLoginCRM_Success(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email123']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Test(priority = 2)
    public void testLoginCRM_WithEmailInvalid(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin123@example.com");
        driver.findElement(By.xpath("//input[@id='password123']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Assert.assertEquals(driver.getTitle(), "Perfex CRM | Anh Tester Demo - Login");
    }

    @Test(priority = 3)
    public void testLoginCRM_WithPasswordInvalid(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
}
