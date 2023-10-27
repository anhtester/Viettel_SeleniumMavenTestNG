package com.anhtester.Bai19_NavigationPage.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By dropdownProfile = By.xpath("//li[@class='icon header-user-profile']");
    private By optionLogout = By.xpath("(//a[.='Logout'])[1]");
    private By optionProfile = By.xpath("(//a[normalize-space()='My Profile'])[2]");

    public CustomerPage clickMenuCustomers(){
        WebUI.clickElement(menuCustomers);
        System.out.println("Click on menu Customers");

        return new CustomerPage(driver);
    }

    public void clickMenuProjects(){
        WebUI.clickElement(menuProjects);
        System.out.println("Click on menu Projects");
    }

    public void logOut(){
        WebUI.clickElement(dropdownProfile);
        System.out.println("Click on dropdown Profile");
        WebUI.sleep(1);
        WebUI.clickElement(optionLogout);
        System.out.println("Click on option Logout");
        WebUI.sleep(2);
    }

}
