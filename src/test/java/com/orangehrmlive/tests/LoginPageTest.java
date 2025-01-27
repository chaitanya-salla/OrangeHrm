package com.orangehrmlive.tests;

import com.orangehrmlive.base.BaseTest;
import com.orangehrmlive.pages.HomePage;
import com.orangehrmlive.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public final class LoginPageTest extends BaseTest {

    private LoginPageTest() {}

    @Test
    public void loginLogoutTest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage  = loginPage.setUsername("Admin").setPassword("admin123").clickLoginButton();
        homePage.clickUserDropdown()
                .clickLogoutButton();
        Assertions.assertThat(loginPage.getPageTitle())
                .isEqualTo("OrangeHRM");
    }
}
