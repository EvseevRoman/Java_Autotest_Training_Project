package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static User.UserFactory.standardUser;
import static org.testng.Assert.assertEquals;

@Epic("Функциональность на странице каталога продуктов")
@Feature("Добавление товара в корзину")
public class ProductsTest extends BaseTest {
    private String add_product = "Sauce Labs Bike Light";

    @Story("Функциональность кнопки 'Add to cart'")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Евсеев Роман")
    @TmsLink("Java_Autotest_Training_Project")
    @Test(description = "Проверка добавленного товара в корзине", enabled = true, groups = "Позитивная проверка", priority = 1, invocationCount = 1)
    public void addingProductCart() {
        System.out.println("STREAM " + Thread.currentThread().threadId());
        loginPage.open();
        loginPage.login(standardUser());
        productsPage.addToCart(add_product);
        productsPage.goToCart();
        assertEquals(cartPage.getProductName().getText(), add_product);
    }
}
