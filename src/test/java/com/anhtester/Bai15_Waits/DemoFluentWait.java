package com.anhtester.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoFluentWait {
    WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

    @Test(priority = 1)
    public void testLoginCRM_Success() throws InterruptedException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1)); //Thời gian quét cho mỗi vòng lặp
        //10s quét 10 lần (cứ 1s quét 1 lần)

        driver.get("https://hrm.anhtester.com/");
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin_example");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Projects']")));
        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card user-profile-list']//div[@class='card-header-right']//a[@href='#add_form']")));
        driver.findElement(By.xpath("//div[@class='card user-profile-list']//div[@class='card-header-right']//a[@href='#add_form']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='title']")));
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Selenium Explicit Wait");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='budget_hours']")));
        driver.findElement(By.xpath("//input[@name='budget_hours']")).sendKeys("10s");

        Thread.sleep(1000);
    }
}
