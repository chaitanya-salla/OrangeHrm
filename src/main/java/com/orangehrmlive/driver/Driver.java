package com.orangehrmlive.driver;

import com.orangehrmlive.enums.ConfigProperties;
import com.orangehrmlive.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

import static com.orangehrmlive.driver.ThreadLocalDriver.*;

public final class Driver {

    private Driver() {}

    public static void initDriver() {
        if(Objects.isNull(getDriver())) {
            setDriver(new ChromeDriver());
            getDriver().manage().deleteAllCookies();
            getDriver().get(PropertyUtils.getProperty(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if(Objects.nonNull(getDriver())) {
            getDriver().quit();
            removeDriver();
        }
    }
}
