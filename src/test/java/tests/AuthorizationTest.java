package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AuthorizationTest extends BaseTest {
    public String name = "standard_user";
    public String password = "secret_sauce";
    public String product = "Sauce Labs Bike Light";

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

    @Test
    public void addingProductCard() {
        WebDriver browser = new FirefoxDriver() {
        };

        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.id("user-name")).sendKeys(name);
        browser.findElement(By.cssSelector("#password")).sendKeys(password);
        browser.findElement(By.name("login-button")).click();
        browser.findElement(By.xpath("//div[contains(text(), \"" + product + "\")]/../../..//button")).click();
        browser.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
        String name_product = browser.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        assertEquals(name_product, product);
    }
}