package com.anhtester.Bai13_Alert_PopupWindow_IFrame;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleIFrame extends BaseTest {
    @Test
    public void testHandleIFrame_Chatbox(){

        driver.navigate().to("https://anhtester.com/contact");
        sleep(10);
        //In ra số lượng thẻ iframe
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());

        //----Switch to content of Messenger--------
        driver.switchTo().frame(0); //Vị thẻ iframe trí đầu tiên
        System.out.println(driver.findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------

        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame(); //Nội dung ngoài cùng (nội dung không thuộc iframe)

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1);
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        sleep(2);

    }
}
