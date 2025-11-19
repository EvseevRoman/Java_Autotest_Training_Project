package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    private String product = "Sauce Labs Bike Light";

    @Test(description = "Проверка добавленного товара в корзине", enabled = true, groups = "Позитивная проверка", priority = 1, invocationCount = 1)
    public void addingProductCart() {
        loginPage.open();
        loginPage.login();
        productsPage.addToCart(product);
        productsPage.goToCart();
        assertEquals(cartPage.getProductName().getText(), product);
    }
}
