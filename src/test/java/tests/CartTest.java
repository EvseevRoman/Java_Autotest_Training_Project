package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static User.UserFactory.standardUser;
import static org.testng.Assert.assertFalse;

@Epic("Функциональность на странице 'Корзина'")
@Feature("Удаление товара из корзины")
public class CartTest extends BaseTest {
    private String delProduct = "Sauce Labs Backpack";

    @Test(description = "Удаление товара из корзины")
    @Story("Функциональность кнопки 'Remove'")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Евсеев Роман")
    @TmsLink("Java_Autotest_Training_Project")
    public void checkingItemsCart() {
        System.out.println("STREAM " + Thread.currentThread().threadId());
        loginPage.open();
        loginPage.login(standardUser());
        productsPage.addToCart(0);
        productsPage.addToCart(1);
        productsPage.goToCart();
        cartPage.removingItemCart(delProduct);
        assertFalse(cartPage.getProductsNames().contains(delProduct));
    }
}
