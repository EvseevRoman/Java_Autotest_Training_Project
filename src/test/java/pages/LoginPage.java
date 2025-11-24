package pages;

import User.User;
import io.qameta.allure.Step;
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

    @Step("Открытие url страницы")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Авторизация под кредами: логин = {user.user}, пароль = *****")
    public void login(User user) {
        fieldName(user.getUser());
        fieldPassword(user.getPassword());
        pressBtnLogin();
    }

    @Step("Ввод логина пользователя")
    public void fieldName(String name) {
        driver.findElement(FIELD_NAME).sendKeys(name);
    }

    @Step("Ввод пароля пользователя")
    public void fieldPassword(String password) {
        driver.findElement(FIELD_PASSWORD).sendKeys(password);
    }

    @Step("Сделать клик по кнопке 'Login'")
    public void pressBtnLogin() {
        driver.findElement(BTN_LOGIN).click();
    }

    @Step("Сравниваем сообщение об ошибке с ожидаемым результатом")
    public String msgError() {
        WebElement msgError = driver.findElement(MSG_ERROR);
        return msgError.getText();
    }
}
