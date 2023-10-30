package com.anhtester.Bai20_21_ThucHanh_POM.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProfilePage extends CustomerPage{

    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    public void verifyCustomerDetail(String companyName){
        Assert.assertEquals(driver.findElement(inputCompany).getAttribute("value"), companyName , "Message");

    }

}
