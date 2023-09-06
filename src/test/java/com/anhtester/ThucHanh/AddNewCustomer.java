package com.anhtester.ThucHanh;

import com.anhtester.common.BaseTest;
import com.anhtester.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewCustomer extends BaseTest {
    String COMPANY_NAME = "Viettel VTX 01";

    public void loginToCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Menu Dashboard not displayed.");
    }

    public void openCustomerPage() {
        loginToCRM();
        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomerPage)).isDisplayed(), "Header Customer page not displayed.");
    }

    @Test
    public void testAddNewCustomer() {
        openCustomerPage();

        driver.findElement(By.xpath(LocatorCRM.buttonAddNewCustomer)).click();
        driver.findElement(By.xpath(LocatorCRM.inputCompany)).sendKeys(COMPANY_NAME);
        driver.findElement(By.xpath(LocatorCRM.inputVatNumber)).sendKeys("10");
        driver.findElement(By.xpath(LocatorCRM.inputPhone)).sendKeys("123456789");
        driver.findElement(By.xpath(LocatorCRM.inputWebsite)).sendKeys("https://viettel.com.vn");
        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroups)).sendKeys("VIP");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroups)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
        driver.findElement(By.xpath(LocatorCRM.inputAddress)).sendKeys("Ha Noi");
        driver.findElement(By.xpath(LocatorCRM.inputCity)).sendKeys("Ha Noi");
        driver.findElement(By.xpath(LocatorCRM.inputState)).sendKeys("Hoan Kiem");
        driver.findElement(By.xpath(LocatorCRM.inputZipCode)).sendKeys("1000");
        driver.findElement(By.xpath(LocatorCRM.dropdownCountry)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys("Vietnam");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys(Keys.ENTER);
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.buttonSaveCustomer)).click();
        sleep(3);
        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(COMPANY_NAME);
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
