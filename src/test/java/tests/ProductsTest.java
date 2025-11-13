package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    private String product = "Sauce Labs Bike Light";

    @Test(description = "Проверка добавления товара в корзину", enabled = true, groups = "Позитивная проверка", priority = 1, invocationCount = 1)
    public void addingProductCart() {
        loginPage.open();
        loginPage.login();
        productsPage.addToCart(product);
//        driver.findElement(By.xpath("//*[text()=
//        'Sauce Labs Bike Light']//ancestor::div[@class='inventory_item_description']//child::button[text()='Add to cart']")).click();
        goToCart();
        cartPage.getProductName();
        assertEquals(cartPage.getProductName().getText(), product);
    }
}
