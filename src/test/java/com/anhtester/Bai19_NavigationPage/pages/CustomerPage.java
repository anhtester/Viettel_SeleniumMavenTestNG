package com.anhtester.Bai19_NavigationPage.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage {
    private WebDriver driver;

    public CustomerPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By buttonAddNew = By.xpath("//a[normalize-space()='New Customer']");
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By inputSearch = By.xpath("//div[@id='DataTables_Table_0_filter']//input[@type='search']");

    public void clickButtonAddNew(){
        WebUI.clickElement(buttonAddNew);
    }

    public void verifyRedirectCustomerPageSuccess(){
        Assert.assertTrue(driver.findElement(headerCustomerPage).isDisplayed(), "Không tìm thấy Customer header page");
        Assert.assertEquals(driver.findElement(headerCustomerPage).getText(), "Customers Summary 123", "Giá trị header page không đúng");
    }
}
