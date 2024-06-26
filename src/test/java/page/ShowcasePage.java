package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShowcasePage extends BasePage {
    private static final By TITLE = By.xpath(".//*[@class='title']");
    private static final By IMAGE = By.xpath(".//*[@alt='Sauce Labs Backpack']");

    @Step("Проверка загрузки ветрины")
    @Override
    void verifyPage() {
        $(TITLE).shouldBe(visible);
    }

    @Step("Получение ссылки на картинку")
    public String imageLink() {
        return $$(IMAGE).get().shouldBe(visible).getAttribute("src");
    }
}
