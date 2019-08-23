package com.zs.day11.pack2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ZhuJieTetng1 {
    @Test
    public void f1() {
        System.out.println("test1");
    }
    @Test
    public void f2() {
        System.out.println("test2");
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

   
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("NewTest.beforeSuite()");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("NewTest.afterSuite()");
    }

}
