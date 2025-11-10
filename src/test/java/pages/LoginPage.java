package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver browser;
    private static final By USER_NAME = By.id("user-name");
    private static final By PASSWORD = By.cssSelector("#password");
    private static final By BTN_LOGIN = By.name("login-button");

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public void open() {
        browser.get("https://www.saucedemo.com/");
    }

    public void login(String name, String password) {
        browser.findElement(USER_NAME).sendKeys(name);
        browser.findElement(PASSWORD).sendKeys(password);
        browser.findElement(BTN_LOGIN).click();
    }

    public String getUrl(String url) {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains(url));
        return  browser.getCurrentUrl();
    }

    public String msgEmptyFieldName() {
        WebElement msgError = browser.findElement(By.xpath("//h3[@data-test='error']"));
        return msgError.getText();
    }
}
