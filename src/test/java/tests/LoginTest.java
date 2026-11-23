package tests;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    void initPage() {
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Test
    void successfulLogin() {
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(loginPage.isOnProductsPage());
    }

    @Test
    void loginWithLockedOutUser() {
        loginPage.login("locked_out_user", "secret_sauce");
        assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    void loginWithInvalidPassword() {
        loginPage.login("standard_user", "incorrect_password");
        assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Username and password do not match any user in this service"));
    }
}