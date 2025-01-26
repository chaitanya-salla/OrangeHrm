package com.orangehrmlive.driver;

import com.orangehrmlive.utils.ReadPropertyFile;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

import static com.orangehrmlive.driver.ThreadLocalDriver.*;

public final class Driver {

    private Driver() {}

    public static void initDriver() {
        if(Objects.isNull(getDriver())) {
            setDriver(new ChromeDriver());
            getDriver().manage().deleteAllCookies();
            getDriver().get(ReadPropertyFile.getProperty("url"));
        }
    }

    public static void quitDriver() {
        if(Objects.nonNull(getDriver())) {
            getDriver().quit();
            removeDriver();
        }
    }
}
