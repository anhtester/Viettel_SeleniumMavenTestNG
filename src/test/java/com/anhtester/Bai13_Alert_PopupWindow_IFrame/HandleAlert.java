package com.anhtester.Bai13_Alert_PopupWindow_IFrame;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest {
    @Test
    public void demoHandleAlertAccept() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        sleep(2);

        //Mở Alert Message, click vào nút "Click me!" thứ nhất
        driver.findElement(By.xpath("(//button[text()='Click me!'])[1]")).click();
        sleep(1);

        //Khởi tạo class Alert thứ nhất
        Alert alert1 = driver.switchTo().alert();
        //Nhấn vào nút OK/Submit
        //alert1.accept();
        driver.switchTo().alert().accept();

        sleep(1);
    }

    @Test
    public void demoHandleAlertDismiss() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        sleep(2);

        //Mở Alert Dismiss, click vào nút "Click me!" thứ 2
        driver.findElement(By.xpath("(//button[text()='Click me!'])[2]")).click();
        sleep(1);

        //Khởi tạo class Alert
        Alert alert2 = driver.switchTo().alert();

        //Get text on alert
        Assert.assertEquals(alert2.getText(),"Press a button!");

        //Nhấn nút Cancel
        alert2.dismiss();

        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='confirm-demo']")).isDisplayed(),
                "Chưa nhấn được nút Cancel");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText(), "You pressed Cancel!");

        sleep(1);
    }

    @Test
    public void demoHandleAlertInputText() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        sleep(2);

        //Mở Alert Input text, click nút thứ 3
        driver.findElement(By.xpath("//button[normalize-space()='Click for Prompt Box']")).click();
        sleep(1);

        //Khởi tạo class Alert
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Anh Tester");
        alert3.accept();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText(),
                "You have entered 'Anh Tester Demo Alert' !",
                "Chưa điền được text");

        sleep(1);
    }
}
