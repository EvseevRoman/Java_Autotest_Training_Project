package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item_description']//child::button[text()='Add to cart']";
    private static final String GO_TO_CART = "//*[@class='shopping_cart_link']";
    private static final String BTN = "//*[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка url страницы")
    public String getUrl() {
        wait.until(ExpectedConditions.urlContains(PRODUCTS_URL));
        return driver.getCurrentUrl();
    }
    @Step("Добавление товара в корзину")
    public void addToCart(final String product) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(product));
        driver.findElement(addToCart).click();
    }
    @Step("Добавление товара в корзину по индексу")
    public void addToCart(final int index) {
        By addToCart = By.xpath(BTN);
        driver.findElements(addToCart).get(index).click();
    }
    @Step("Переходим в корзину по клику на иконку")
    public void goToCart() {
        driver.findElement(By.xpath(GO_TO_CART)).click();
    }
}
