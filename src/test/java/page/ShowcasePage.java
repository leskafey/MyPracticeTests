package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShowcasePage extends BasePage {
    private static final By TITLE = By.xpath(".//*[@class='title']");
    private static final By IMAGE = By.xpath(".//*[@alt='Sauce Labs Backpack']");
    private static final By ADD_TO_CART_BUTTON = By.xpath(".//*[@class='btn btn_primary btn_small btn_inventory ']");
    private static final By REMOVE_FROM_CART_BUTTON = By.xpath(".//*[@data-test='remove-sauce-labs-backpack']");
    private static final By REMOVE_FROM_CART_BUTTON_TWO = By.xpath(".//*[@id='remove-sauce-labs-backpack']");
    private static final By ITEM_T_SHIRT = By.xpath(".//*[@id='item_1_title_link']/div");
    private static final By PRICE_T_SHIRT = By.xpath(".//*[@id='inventory_item_container']");
    private static final By DESCRIPTION_T_SHIRT = By.xpath(".//*[@class='inventory_details_desc large_size']");

    @Step("Проверка загрузки ветрины")
    @Override
    void verifyPage() {
        $(TITLE).shouldBe(visible);
        $(ADD_TO_CART_BUTTON).shouldBe(visible);
    }

    @Step("Получение ссылки на картинку")
    public String imageLink() {
        return $(IMAGE).shouldBe(visible).getAttribute("src");
    }

    @Step("Добавление в корзину")
    public static void addToCart() {
        $(ADD_TO_CART_BUTTON).shouldBe(visible).click();
        $(REMOVE_FROM_CART_BUTTON).shouldBe(appear);
    }

    @Step("Удаление из корзины")
    public static void removeFromCart() {
        $(REMOVE_FROM_CART_BUTTON_TWO).shouldBe(visible).click();
        $(ADD_TO_CART_BUTTON).shouldBe(appear);
    }

    @Step("Открытия страницы товара")
    public static void openItemPage() {
        $(ITEM_T_SHIRT).shouldBe(visible).click();
    }

    @Step("Проверка описания товара и его цены")
    public String checkDescription() {
        return $(DESCRIPTION_T_SHIRT).shouldBe(visible).getText();
    }

    @Step("Проверка цены товара")
    public String checkPrice() {
        return $(PRICE_T_SHIRT).shouldBe(visible).getText();
    }
}
