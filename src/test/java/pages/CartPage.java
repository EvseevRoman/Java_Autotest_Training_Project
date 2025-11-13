package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private static final By PRODUCTS_NAME = By.xpath("//div[@class='inventory_item_name']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProductName() {
        return driver.findElement(PRODUCTS_NAME);
    }
}
