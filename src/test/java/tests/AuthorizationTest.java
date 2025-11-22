package tests;

import User.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static User.UserFactory.*;
import static org.testng.Assert.assertEquals;

public class AuthorizationTest extends BaseTest {
    @Test(description = "Проверка корректной авторизации", enabled = true, groups = "Позитивная проверка", priority = 1, invocationCount = 1)
    public void pozitiveLogin() {
        System.out.println("STREAM " + Thread.currentThread().threadId());
        loginPage.open();
        loginPage.login(standardUser());
        assertEquals(productsPage.getUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @DataProvider
    public Object[][] dataLogin() {
        return new Object[][] {
                {emptyUser(), "Epic sadface: Username is required"},
                {emptyPassword(), "Epic sadface: Password is required"},
                {incorrectPassword(), "Epic sadface: Username and password do not match any user in this service"},
                {lockedUser(), "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(dataProvider = "dataLogin", description = "Проверка авторизации с некорректными данными")
    public void incorrectLogin(User user, String messageError) {
        System.out.println("STREAM " + Thread.currentThread().threadId());
        loginPage.open();
        loginPage.login(user);
        assertEquals(loginPage.msgError(), messageError);
    }
}
