package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final By FIELD_NAME = By.id("user-name");
    private static final By FIELD_PASSWORD = By.cssSelector("#password");
    private static final By BTN_LOGIN = By.name("login-button");
    private static final By MSG_ERROR = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login() {
        fieldName("standard_user");
        fieldPassword("secret_sauce");
        pressBtnLogin();
    }

    public void fieldName(String name) {
        driver.findElement(FIELD_NAME).sendKeys(name);
    }

    public void fieldPassword(String password) {
        driver.findElement(FIELD_PASSWORD).sendKeys(password);
    }

    public void pressBtnLogin() {
        driver.findElement(BTN_LOGIN).click();
    }


    public String msgError() {
        WebElement msgError = driver.findElement(MSG_ERROR);
        return msgError.getText();
    }
}
