package com.anhtester.Bai11_Assertions;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoHardAssert extends BaseTest {
    @Test
    public void testOpenProject() {
        driver.get("https://crm.anhtester.com/admin/authentication");

        String headerLoginPage = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        Assert.assertEquals(headerLoginPage, "Login", "Header Login page not match.");

        String url = driver.getCurrentUrl();
        System.out.println("Current URL: " + url);
        //Assert.assertEquals(url, "https://crm.anhtester.com/admin/authenticationn");

        boolean checkURL = url.contains("/admin/authentication123");
        Assert.assertTrue(url.contains("/admin/authentication123"), "URL không chứa giá trị mong muốn");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        boolean checkMenuDashboard = driver.findElement(By.xpath("//span[normalize-space()='Dashboard']")).isDisplayed();
        Assert.assertTrue(checkMenuDashboard, "");

        //Mở menu Project
        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();
    }


}
