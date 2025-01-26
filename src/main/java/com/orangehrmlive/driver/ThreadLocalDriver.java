package com.orangehrmlive.driver;

import org.openqa.selenium.WebDriver;

public final class ThreadLocalDriver {

    private ThreadLocalDriver() {}

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() { return driverThreadLocal.get(); }

    public static void setDriver(WebDriver driver) { driverThreadLocal.set(driver); }

    public static void removeDriver() { driverThreadLocal.remove(); }

}
