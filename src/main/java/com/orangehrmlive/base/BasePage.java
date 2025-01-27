package com.orangehrmlive.base;

import com.orangehrmlive.constants.Constants;
import com.orangehrmlive.enums.WaitType;
import org.openqa.selenium.By;

import com.orangehrmlive.driver.ThreadLocalDriver;
import org.openqa.selenium.WebElement;

import static com.orangehrmlive.driver.ThreadLocalDriver.getDriver;
import static com.orangehrmlive.factories.ExplictWaitFactory.waitForElement;

public class BasePage {

    protected BasePage() {}


    protected void click(By by) {
        click(by, WaitType.CLICKABLE, Constants.getExplicitWait());
    }

    protected void click(By by, WaitType waitType) {
        click(by, waitType, Constants.getExplicitWait());
    }

    protected void click(By by, WaitType waitType, int timeout) {
        WebElement element = waitForElement(by, waitType, timeout);
        element.click();
    }

    protected void sendKeys(By by, CharSequence... keysToSend) {
        WebElement element = waitForElement(by, WaitType.CLICKABLE, Constants.getExplicitWait());
        element.sendKeys(keysToSend);
    }

    protected void setText(By by, CharSequence... keysToSend) {
        WebElement element = waitForElement(by, WaitType.CLICKABLE, Constants.getExplicitWait());
        element.clear();
        element.sendKeys(keysToSend);
    }

    protected String getText(By by) {
        WebElement element = waitForElement(by, WaitType.CLICKABLE, Constants.getExplicitWait());
        return element.getText();
    }

    protected String getCurrentPageTitle() {
        return getDriver().getTitle();
    }


}
