package com.anhtester.ThucHanh;

import com.anhtester.common.BaseTest;
import com.anhtester.common.BaseTestDependency;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ThucHanhAnnotationsDependency extends BaseTestDependency {

    @Test(priority = 1)
    public void testLoginCRM1(){
        System.out.println("Login CRM 1");
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Test(priority = 2)
    public void testLoginCRM2(){
        System.out.println("Login CRM 2");
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
    }

}
