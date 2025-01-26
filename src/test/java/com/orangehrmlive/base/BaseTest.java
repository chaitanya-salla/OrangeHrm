package com.orangehrmlive.base;

import com.orangehrmlive.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest() {}

    @BeforeMethod (alwaysRun = true)
    protected void setUp() {
        Driver.initDriver();
    }


    @AfterMethod (alwaysRun = true)
    protected void tearDown() {
        Driver.quitDriver();
    }
}
