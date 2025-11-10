package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AuthorizationTest extends BaseTest {
    @Test
    public void pozitiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        loginPage.getUrl("https://www.saucedemo.com/inventory.html");
        assertEquals(browser.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void emptyNameFieldLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        String msgError = loginPage.msgEmptyFieldName();
        assertEquals(msgError, "Epic sadface: Username is required");
    }
}