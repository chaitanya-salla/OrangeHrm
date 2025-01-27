package com.orangehrmlive.factories;

import com.orangehrmlive.driver.ThreadLocalDriver;
import com.orangehrmlive.enums.WaitType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplictWaitFactory {

    private ExplictWaitFactory() {}

    public static WebElement waitForElement(By by, WaitType waitType, int timeout) {
        WebElement webElement = null;
        switch (waitType) {
            case PRESENCE:
                webElement = waitForElementPresence(by, timeout);
                break;
            case CLICKABLE:
                webElement = waitForElementToBeClickable(by, timeout);
                break;
            case VISIBILITY:
                webElement = waitForElementToBeVisible(by, timeout);
                break;
            case NONE:
                webElement = ThreadLocalDriver.getDriver().findElement(by);
                break;
            default:
        }
        return webElement;
    }

    private static WebElement waitForElementToBeClickable(By by, int timeout) {
        return new WebDriverWait(ThreadLocalDriver.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(by));
    }

    private static WebElement waitForElementToBeVisible(By by, int timeout) {
        return new WebDriverWait(ThreadLocalDriver.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page. This does not necessarily mean that the element is visible.
     *
     * @return WebElement
     */
    private static WebElement waitForElementPresence(By by, int timeout) {
        return new WebDriverWait(ThreadLocalDriver.getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
