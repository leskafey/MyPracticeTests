package page;

import org.openqa.selenium.By;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private static final By HEADER = By.xpath(".//*[@class='login_logo']");
    private static final By USERNAME_INPUT = By.xpath(".//*[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath(".//*[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath(".//*[@id='login-button']");
    private static final By ERROR = By.xpath(".//*[@id='login_button_container']/div/form/div[3]/h3");

    @Step("Проверка загрузки страницы логина")
    @Override
    void verifyPage(){
        $(HEADER).shouldBe(visible);
        $(USERNAME_INPUT).shouldBe(visible);
        $(PASSWORD_INPUT).shouldBe(visible);
        $(LOGIN_BUTTON).shouldBe(visible);
    }

    @Step("Ввод в поле логина")
    public LoginPage fillUsername(String name) {
        $(USERNAME_INPUT).shouldBe(visible).setValue(name);
        return this;
    }

    @Step("Ввод в поле пароля")
    public LoginPage fillPassword(String password) {
        $(PASSWORD_INPUT).shouldBe(visible).setValue(password);
        return this;
    }

    @Step("Нажатие кнопки \"Авторизоваться\" с успешной авторизацией")
    public LoginPagePromise clickLogin() {
        $(LOGIN_BUTTON).shouldBe(visible).click();
        return new LoginPagePromise();
    }

    @Step("Получение текста ошибки")
    public String getErrorText() {
        return $(ERROR).shouldBe(visible).text();
    }
}
