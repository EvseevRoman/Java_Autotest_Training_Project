package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest {
    public String product = "Sauce Labs Bike Light";
    WebDriver browser = new ChromeDriver() {
    };

    @Test
    public void addingProductCard() {
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        browser.findElement(By.name("login-button")).click();
        browser.findElement(By.xpath("//div[contains(text(), \"" + product + "\")]/../../..//button")).click();
        browser.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
        String name_product = browser.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        assertEquals(name_product, product);
    }
}
