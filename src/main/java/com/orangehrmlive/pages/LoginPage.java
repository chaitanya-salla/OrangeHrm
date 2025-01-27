package com.orangehrmlive.pages;


import com.orangehrmlive.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {


    private final By textFieldUsername = By.name("username");
    private final By textFieldPassword = By.xpath("//input[@type='password']");
    private final By buttonLogin = By.xpath("//button[@type='submit']");

    public LoginPage setUsername(String username) {
        sendKeys(textFieldUsername, username);
        return this;
    }

    public LoginPage setPassword(String password) {
        sendKeys(textFieldPassword, password);
        return this;
    }

    public HomePage clickLoginButton() {
        click(buttonLogin);
        return new HomePage();
    }

    public String getPageTitle() { return getCurrentPageTitle(); }




}
