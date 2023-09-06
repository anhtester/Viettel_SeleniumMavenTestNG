package com.anhtester.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public void sleep(double second){
        try {
            Thread.sleep((long) (1000*second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void createBrowser(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //Khởi tạo Browser
        driver = new ChromeDriver();
        //2 hàm chờ đợi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Học kỹ bài số 15
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //2 hàm để maximize/minimize cửa sổ trình duyệt
        driver.manage().window().maximize();
    }

    public void createBrowser(String browserName){
        //Khởi tạo Browser
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        if(browserName.trim().toLowerCase().equals("chrome")){
            driver = new ChromeDriver();
        }
        if(browserName.trim().toLowerCase().equals("edge")){
            driver = new EdgeDriver();
        }
        if(browserName.trim().toLowerCase().equals("firefox")){
            driver = new FirefoxDriver();
        }

        //2 hàm chờ đợi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Học kỹ bài số 15
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //2 hàm để maximize/minimize cửa sổ trình duyệt
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Đóng Browser
        driver.quit();
    }

}