package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.BucketPage;
import page.ItemWrapper;
import page.LoginPage;
import page.ShowcasePage;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAddItems {
    private static final String LOGIN = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @BeforeEach
    public void setUp(){
        Selenide.open("https://www.saucedemo.com/");
    }

    @Test
    public void testAddItem() {
        ItemWrapper item = new LoginPage()
                .fillUsername(LOGIN)
                .fillPassword(PASSWORD)
                .clickLogin()
                .andSuccessLogin()
                .getItemByName("Sauce Labs Bike Light");
        String itemName = item.getName();
        String itemPrice = item.getPrice();
        item.addToCart();
        BucketPage bucketPage = ShowcasePage.openBucketPage();
        assertThat(bucketPage.getName()).as("Неверное имя").contains(itemName);
        assertThat(bucketPage.getPrice()).as("Неверная цена").contains(itemPrice);
    }

    //написать тест для ужаления товара из корзины

    @AfterEach
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
