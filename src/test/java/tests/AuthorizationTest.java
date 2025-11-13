package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AuthorizationTest extends BaseTest {
    @Test(description = "Проверка корректной авторизации", enabled = true, groups = "Позитивная проверка", priority = 1, invocationCount = 1)
    public void pozitiveLogin() {
        loginPage.open();
        loginPage.login();
        productsPage.getUrl();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(description = "Проверка текста сообщения об ошибке при авторизации с пустым полем Имя", enabled = true, groups = "Негативная проверка", priority = 2, invocationCount = 1)
    public void emptyNameLogin() {
        loginPage.open();
        loginPage.fieldPassword("secret_sauce");
        loginPage.pressBtnLogin();
        String msgError = loginPage.msgError();
        assertEquals(msgError, "Epic sadface: Username is required");
    }

    @Test(description = "Проверка текста сообщения об ошибке при авторизации с пустым полем Пароль", enabled = true, groups = "Негативная проверка", priority = 3, invocationCount = 1)
    public void emptyPasswordLogin() {
        loginPage.open();
        loginPage.fieldName("standard_user");
        loginPage.pressBtnLogin();
        String msgError = loginPage.msgError();
        assertEquals(msgError, "Epic sadface: Password is required");
    }

    @Test(description = "Проверка текста сообщения об ошибке при авторизации с некорректным паролем", enabled = true, groups = "Негативная проверка", priority = 4, invocationCount = 1)
    public void invalidPasswordLogin() {
        loginPage.open();
        loginPage.fieldName("standard_user");
        loginPage.fieldPassword("secret_sauce123456");
        loginPage.pressBtnLogin();
        String msgError = loginPage.msgError();
        assertEquals(msgError, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(description = "Проверка текста сообщения об ошибке при авторизации с заблокированным пользователем", enabled = true, groups = "Негативная проверка", priority = 5, invocationCount = 1)
    public void lockedUserLogin() {
        loginPage.open();
        loginPage.fieldName("locked_out_user");
        loginPage.fieldPassword("secret_sauce");
        loginPage.pressBtnLogin();
        String msgError = loginPage.msgError();
        assertEquals(msgError, "Epic sadface: Sorry, this user has been locked out.");
    }
}
