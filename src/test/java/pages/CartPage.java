package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private static final By PRODUCTS_NAME = By.xpath("//div[@class='inventory_item_name']");
    private static final String REMOVING_ITEM = "//*[contains(text(),'%s')]/ancestor::div[@class='cart_item_label']//child::button[text()='Remove']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Сравниваем название добавленного товара в корзину с названием товара в корзине")
    public WebElement getProductName() {
        return driver.findElement(PRODUCTS_NAME);
    }

    @Step("Проверяем, что товар удалился из корзины")
    public ArrayList<String> getProductsNames() {
        List<WebElement> allProducts = driver.findElements(PRODUCTS_NAME);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProducts) {
            names.add(product.getText());
        }

        return names;
    }

    @Step("Делаем клик по кнопке 'Удалить' товара")
    public void removingItemCart(final String product) {
        By removingItemCart = By.xpath(REMOVING_ITEM.formatted(product));
        driver.findElement(removingItemCart).click();
    }
}
