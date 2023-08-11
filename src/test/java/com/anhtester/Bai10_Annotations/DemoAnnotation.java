package com.anhtester.Bai10_Annotations;

import org.testng.annotations.*;

public class DemoAnnotation {
     
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeGroups(groups = { "test1" })
    public void beforeGroupOne() {
        System.out.println("Before Group testOne");
    }

    @AfterGroups(groups = { "test1" })
    public void afterGroupOne() {
        System.out.println("After Group testOne");
    }

    @BeforeGroups(groups = { "test2" })
    public void beforeGroupTwo() {
        System.out.println("Before Group testTwo");
    }

    @AfterGroups(groups = { "test2" })
    public void afterGroupTwo() {
        System.out.println("After Group testTwo");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @Test(groups = { "test1", "test2" }, priority = 2)
    public void testOneMethod() {
        System.out.println("Test method 1");
    }

    @Test(groups = { "test2" }, priority = 1)
    public void testTwoMethod() {
        System.out.println("Test method 2");
    }

}