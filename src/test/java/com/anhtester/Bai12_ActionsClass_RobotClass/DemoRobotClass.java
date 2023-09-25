package com.anhtester.Bai12_ActionsClass_RobotClass;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DemoRobotClass extends BaseTest {

    @Test
    public void inputText() {

        driver.get("https://anhtester.com/");

        sleep(2);
        WebElement inputCourseElement = driver.findElement(By.name("key"));

        inputCourseElement.click();

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        // Nhập từ khóa selenium
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_M);
        //Nhấc phím lên
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_U);
        robot.keyRelease(KeyEvent.VK_M);

        sleep(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        sleep(2);
    }

    @Test
    public void mousePress() {

        driver.get("https://anhtester.com/");
        sleep(1);

        int X = driver.findElement(By.xpath("//a[@id='btn-login']")).getLocation().getX();
        int Y = driver.findElement(By.xpath("//a[@id='btn-login']")).getLocation().getY();
        System.out.println(X);
        System.out.println(Y);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //Di chuyển trỏ chuột đến vị trí x,y
        robot.mouseMove(1580, 250);
        //Dalay giống sleep
        robot.delay(2000);
        //Click chuột trái
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        //Thả chuột trái ra
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        createScreenCapture("Image02");

        sleep(2);
    }

    @Test
    public void testCreateScreenCapture() {
        driver.get("https://anhtester.com/");
        sleep(1);
        createScreenCapture("Image01");
    }

}
