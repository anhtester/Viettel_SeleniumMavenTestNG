package com.anhtester.Bai14_JavascriptExecutor;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavascriptExecutor extends BaseTest {
    @Test
    public void testJavascriptExecutor01() {
        driver.get("https://cms.anhtester.com/");
        sleep(2);
        //Tắt dialog
//        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        sleep(2);
//        driver.findElement(By.xpath("//a[normalize-space()='Blogs']")).click();

        WebElement menuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));

        //Dùng JavascriptExecutor để click vào một Element ang bị che
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", menuBlogs);
    }

    @Test
    public void testJavascriptExecutor02() {
        driver.get("https://cms.anhtester.com/");
        sleep(2);

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        sleep(2);
//        driver.findElement(By.xpath("(//i[@class='las la-shopping-cart'])[1]")).click();

        WebElement buttonAddToCart = driver.findElement(By.xpath("(//i[@class='las la-shopping-cart'])[1]"));
//
//        //Dùng JavascriptExecutor để click vào một Element đang bị che
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttonAddToCart);
        sleep(2);
    }

    @Test
    public void testJavascriptExecutor03() {
        driver.get("https://cms.anhtester.com/");
        sleep(2);

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        sleep(2);
//        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Cosy TRUONG_vnbYvGTT");
//        sleep(4);

        WebElement inputSearch = driver.findElement(By.xpath("//input[@id='search']"));

        //Dùng JavascriptExecutor để set text vào input
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', 'Cosy TRUONG_vnbYvGTT');", inputSearch);
        sleep(4);
    }

    @Test
    public void testJavascriptExecutor04() {
        driver.get("https://cms.anhtester.com/");
        sleep(2);

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();

        WebElement labelAllCategory = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));

        //Dùng JavascriptExecutor để scroll đến một Element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", labelAllCategory);

        //true - cuộn lên TOP
        //false - cuộn xuống BOTTOM

        sleep(2);
    }

    @Test
    public void testJavascriptExecutor05() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        sleep(2);

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement buttonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

        //Dùng JavascriptExecutor để Highlight màu viền của Element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", inputEmail);
        sleep(1);
        inputEmail.sendKeys("admin@example.com");
        js.executeScript("arguments[0].style.border='3px solid green'", inputPassword);
        sleep(1);
        inputPassword.sendKeys("123456");
        sleep(1);
        js.executeScript("arguments[0].style.border='3px solid orange'", buttonLogin);

        sleep(2);
    }
}
