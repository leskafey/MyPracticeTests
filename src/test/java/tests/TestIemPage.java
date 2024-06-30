package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.ShowcasePage;

import static org.assertj.core.api.Assertions.assertThat;

public class TestIemPage {
    private static final String LOGIN = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String DESCRIPTION = "From American Apparel";
    private static final String PRICE = "15.99";

    @BeforeEach
    public void setUp(){
        Selenide.open("https://www.saucedemo.com/");
    }

    @Test
    public void testItemPage() {
        ShowcasePage showcasePage = new LoginPage()
                .fillUsername(LOGIN)
                .fillPassword(PASSWORD)
                .clickLogin()
                .andSuccessLogin();
        ShowcasePage.openItemPage();
        assertThat(showcasePage.checkDescription()).as("Неверное описание").contains(DESCRIPTION);
        assertThat(showcasePage.checkPrice()).as("Неверная цена").contains(PRICE);
    }

    @AfterEach
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
