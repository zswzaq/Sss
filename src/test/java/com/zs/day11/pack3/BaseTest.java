package com.zs.day11.pack3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("NewTest.beforeSuite()");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("NewTest.afterSuite()");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("NewTest.beforeTest()");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("NewTest.afterTest()");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("NewTest.afterMethod()");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("NewTest.beforeClass()");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("NewTest.afterClass()");
    }

}
