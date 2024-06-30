package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShowcasePage extends BasePage {
    private static final By TITLE = By.xpath(".//*[@class='title']");
    private static final By ITEM = By.xpath(".//*[@data-test='inventory-item']");
    private static final By SORT = By.xpath(".//*[@class='product_sort_container']");
    private static final By BTN_BUCKET = By.xpath(".//*[@class='shopping_cart_link']");
    @Step("Проверка загрузки ветрины")
    @Override
    void verifyPage() {
        $(TITLE).shouldBe(visible);
    }

    @Step("Открытия страницы товара")
    public ItemPage openItemPage() {
        $(ITEM).shouldBe(visible).click();
        return new ItemPage();
    }

    @Step("Получения списка товара")
    public List<ItemWrapper> getItems() {
        return $$(ITEM).asFixedIterable().stream().map(item -> new ItemWrapper(item)).collect(Collectors.toList());
    }

    public ItemWrapper getItemByName(String name) {
        return getItems().stream()
                .filter(item -> item.getName().contains(name))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Не найден элемент с названием: " + name));
    }

    @Step("Открытие корзины")
    public static BucketPage openBucketPage() {
        $(BTN_BUCKET).shouldBe(visible).click();
        return new BucketPage();
    }
}
