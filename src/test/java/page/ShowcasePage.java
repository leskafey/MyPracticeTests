package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShowcasePage extends BasePage {
    private static final By TITLE = By.xpath(".//*[@class='title']");
    private static final By IMAGE = By.xpath(".//*[@alt='Sauce Labs Backpack']");
    private static final By ADD_BUTTON = By.xpath(".//*[@class='btn btn_primary btn_small btn_inventory ']");
    private static final By ERROR = By.xpath(".//*[@id='login_button_container']/div/form/div[3]/h3");
    private static final By ADD_BUTTON = By.xpath(".//*[@class='btn btn_primary btn_small btn_inventory ']");
    private static final By SHOPPING_CART = By.xpath(".//*[@class='shopping_cart_link']");
    private static final By ITEM_IN_CART = By.xpath(".//*[@class='cart_item_label']");
    private static final By REMOVE_BUTTON = By.xpath(".//*[@class='btn btn_secondary btn_small cart_button']");
    private static final By CART_BADGE = By.xpath(".//*[@class='shopping_cart_badge']");

    @Step("Проверка загрузки ветрины")
    @Override
    void verifyPage() {
        $(TITLE).shouldBe(visible);
        $(ADD_BUTTON).shouldBe(visible);
    }

    @Step("Получение ссылки на картинку")
    public String imageLink() {
        return $$(IMAGE).get().shouldBe(visible).getAttribute("src");
    }

    @Step("Добавление в корзину")
    public String addToCart() {
        $(ADD_BUTTON).shouldBe(visible).click();
        return this;
    }

    @Step("Проверка ")
}
