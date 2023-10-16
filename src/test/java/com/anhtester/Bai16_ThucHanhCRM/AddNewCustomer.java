package com.anhtester.Bai16_ThucHanhCRM;

import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import com.anhtester.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddNewCustomer extends BaseTest {

    String COMPANY_NAME = "Viettel Aerospace 04";

    public void loginToCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");

        //Đã tích hợp cơ chế wait vào
        WebUI.setText(LocatorCRM.inputEmail, "admin@example.com");
        WebUI.setText(LocatorCRM.inputPassword, "123456");
        WebUI.clickElement(LocatorCRM.buttonLogin);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Menu Dashboard not displayed.");
    }

    public void openCustomerPage() {
        loginToCRM();
        WebUI.clickElement(LocatorCRM.menuCustomers);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomerPage)).isDisplayed(), "Header Customer page not displayed.");
    }

    @Test
    public void testAddNewCustomer() {
        openCustomerPage();

        WebUI.clickElement(LocatorCRM.buttonAddNewCustomer);
        WebUI.setText(LocatorCRM.inputCompany, COMPANY_NAME);
        WebUI.setText(LocatorCRM.inputVatNumber, "10");
        WebUI.setText(LocatorCRM.inputPhone, "123456789");
        WebUI.setText(LocatorCRM.inputWebsite, "https://viettel.com.vn");
        WebUI.clickElement(LocatorCRM.dropdownGroups);
        WebUI.setText(LocatorCRM.inputSearchGroups, "VIP");

        driver.findElement(By.xpath(LocatorCRM.inputSearchGroups)).sendKeys(Keys.ENTER);

        WebUI.clickElement(LocatorCRM.dropdownGroups);
        WebUI.setText(LocatorCRM.inputAddress, "Ha Noi");
        WebUI.setText(LocatorCRM.inputCity, "Ha Noi");
        WebUI.setText(LocatorCRM.inputState, "Hoan Kiem");
        WebUI.setText(LocatorCRM.inputZipCode, "1234");
        WebUI.clickElement(LocatorCRM.dropdownCountry);

        WebUI.setText(LocatorCRM.inputSearchCountry, "Vietnam");
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys(Keys.ENTER);
        WebUI.clickElement(LocatorCRM.buttonSaveCustomer);
        WebUI.clickElement(LocatorCRM.menuCustomers);
        WebUI.setText(LocatorCRM.inputSearchCustomers, COMPANY_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).getText(), COMPANY_NAME);
    }

    @Test
    public void testAddContactForCustomer() {
        //Login > Open Customer page
        openCustomerPage();
        //Search customer for add new contact
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(COMPANY_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).getText(), COMPANY_NAME);
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).click();
        driver.findElement(By.xpath(LocatorCRM.menuContacts)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerContactPage)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerContactPage)).getText(), "Contacts");
        driver.findElement(By.xpath(LocatorCRM.buttonAddNewContact)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerAddNewContactDialog)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerAddNewContactDialog)).getText(), "Add new contact");
        //Upload file at Profile Contact
        driver.findElement(By.xpath(LocatorCRM.inputProfileImage)).sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\datatest\\profile_contact.png");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.buttonGeneratePassword)).click();
        driver.findElement(By.xpath(LocatorCRM.buttonShowPassword)).click();
        sleep(1);
        String passValue = driver.findElement(By.xpath(LocatorCRM.inputPasswordContact)).getAttribute("value");
        System.out.println(passValue);
    }
}
