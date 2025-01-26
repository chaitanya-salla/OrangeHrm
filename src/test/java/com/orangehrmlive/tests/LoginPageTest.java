package com.orangehrmlive.tests;

import com.orangehrmlive.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.orangehrmlive.driver.ThreadLocalDriver.getDriver;

public final class LoginPageTest extends BaseTest {

    private LoginPageTest() {}

    @Test
    public void testLoginPage() {
        getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
    }
}
