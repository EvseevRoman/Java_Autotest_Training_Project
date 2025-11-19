package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class CartTest extends BaseTest {
    private String product = "Sauce Labs Backpack";

    @Test(description = "Удаление товара из корзины")
    public void checkingItemsCart() {
        System.out.println("STREAM " + Thread.currentThread().threadId());
        loginPage.open();
        loginPage.login();
        productsPage.addToCart(0);
        productsPage.addToCart(1);
        productsPage.goToCart();
        cartPage.removingItemCart(product);
        assertFalse(cartPage.getProductsNames().contains(product));
    }

}
