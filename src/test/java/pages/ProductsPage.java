package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART = "//div[contains(text(), '%s')]/../../..//button[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        wait.until(ExpectedConditions.urlContains(PRODUCTS_URL));
        return driver.getCurrentUrl();
    }

    public void addToCart(final String product) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(product));
        driver.findElement(addToCart).click();
    }
}
