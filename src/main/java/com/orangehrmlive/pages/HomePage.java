package com.orangehrmlive.pages;

import com.orangehrmlive.enums.WaitType;
import org.openqa.selenium.By;

public class HomePage extends LoginPage {

    private final By userDropdown = By.xpath("//span[contains(@class,'oxd-userdropdown-tab')]");
    private final By logoutBtn = By.xpath("//a[text()='Logout']");


    public HomePage clickUserDropdown() {
        click(userDropdown, WaitType.CLICKABLE);
        return this;
    }

    public LoginPage clickLogoutButton() {
        click(logoutBtn, WaitType.VISIBILITY);
        return new LoginPage();
    }



}
