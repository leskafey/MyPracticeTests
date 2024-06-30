package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.ItemPage;
import page.ItemWrapper;
import page.LoginPage;
import page.ShowcasePage;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLinkImg {
    private static final String LOGIN = "problem_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String LINK = "/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg";

    @BeforeEach
    public void setUp() {
        Selenide.open("https://www.saucedemo.com/");
    }

    @Test
    public void testLinkImg() {
        ItemWrapper item = new LoginPage()
                .fillUsername(LOGIN)
                .fillPassword(PASSWORD)
                .clickLogin()
                .andSuccessLogin()
                .getItemByName("Sauce Labs Bike Light");
        String itemLink = item.getImageLink();
        assertThat(itemLink).as("Неправильная ссылка").contains(LINK);
    }



    @AfterEach
    private void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
