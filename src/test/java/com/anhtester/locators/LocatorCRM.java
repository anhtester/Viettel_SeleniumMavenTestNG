package com.anhtester.locators;

public class LocatorCRM {
    //Trang Login CRM
    public static String headerLoginPage = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public static String checkboxRemember = "//input[@id='remember']";

    //Trang Dashboard
    public static String menuDashboard = "//ul[@id='side-menu']//span[normalize-space()='Dashboard']";
    public static String menuCustomers = "//ul[@id='side-menu']//span[normalize-space()='Customers']";
    public static String menuProjects = "//ul[@id='side-menu']//span[normalize-space()='Projects']";
    public static String menuTasks = "//ul[@id='side-menu']//span[normalize-space()='Tasks']";

    //Trang Customers List
    public static String buttonAddNewCustomer = "//a[normalize-space()='New Customer']";
    public static String buttonImportCustomer = "//a[normalize-space()='Import Customers']";
    public static String buttonContacts = "//a[contains(@href, 'clients/all_contacts')]";
    public static String headerCustomerPage = "//h4[normalize-space()='Customers Summary']";
    public static String inputSearchCustomers = "//div[@id='DataTables_Table_0_filter']//input";
    public static String firstItemCustomerOnTable = "//td[@class='sorting_1']/a";

    //Add New Customer
    public static String inputCompany = "//input[@id='company']";
    public static String inputVatNumber = "//input[@id='vat']";
    public static String inputPhone = "//input[@id='phonenumber']";
    public static String inputWebsite = "//input[@id='website']";
    public static String dropdownGroups = "//button[@data-id='groups_in[]']";
    public static String inputSearchGroups = "//div[@app-field-wrapper='groups_in[]']//input[@type='search']";
    public static String dropdownCurrency = "//button[@data-id='default_currency']";
    public static String inputSearchCurrency = "//div[@app-field-wrapper='default_currency']//input";
    public static String inputAddress = "//textarea[@id='address']";
    public static String inputCity = "//input[@id='city']";
    public static String inputState = "//input[@id='state']";
    public static String inputZipCode = "//input[@id='zip']";
    public static String dropdownCountry = "//button[@data-id='country']";
    public static String inputSearchCountry = "//div[@app-field-wrapper='country']//input[@aria-label='Search']";
    public static String buttonSaveAndCreateContact = "//button[normalize-space()='Save and create contact']";
    public static String buttonSaveCustomer = "//div[@id='profile-save-section']//button[normalize-space()='Save']";

    //Customer Contact
    public static String menuContacts = "//a[normalize-space()='Contacts']";
    public static String headerContactPage = "//h4[normalize-space()='Contacts']";
    public static String buttonAddNewContact = "//a[normalize-space()='New Contact']";
    public static String inputSearchContacts = "//div[@id='DataTables_Table_0_filter']//input";
    public static String headerAddNewContactDialog = "//h4[normalize-space()='Add new contact']";
    public static String inputProfileImage = "//input[@id='profile_image']";
    public static String inputFirstName = "//input[@id='firstname']";
    public static String inputLastName = "//input[@id='lastname']";
    public static String inputPosition = "//input[@id='title']";
    public static String inputEmailContact = "//input[@id='email']";
    public static String inputPhoneContact = "//input[@id='phonenumber']";
    public static String buttonGeneratePassword = "//a[@class='generate_password']";
    public static String buttonShowPassword = "//a[@class='show_password']";
    public static String inputPasswordContact = "//input[@name='password']";
    public static String checkboxDoNotSendEmail = "//input[@id='donotsendwelcomeemail']";
    public static String buttonSaveContact = "//form[@id='contact-form']//button[normalize-space()='Save']";

    //Trang Project (6-10)
    public static String inputProjectName = "//label[@for='name']/following-sibling::input";
}
