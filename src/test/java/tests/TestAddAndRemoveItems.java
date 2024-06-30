package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.ShowcasePage;

public class TestAddAndRemoveItems {
    private static final String LOGIN = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @BeforeEach
    public void setUp(){
        Selenide.open("https://www.saucedemo.com/");
    }

    @Test
    public void testAddAndRemoveItems() {
        ShowcasePage showcasePage = new LoginPage()
                .fillUsername(LOGIN)
                .fillPassword(PASSWORD)
                .clickLogin()
                .andSuccessLogin();
        ShowcasePage.addToCart();
        ShowcasePage.removeFromCart();
    }

    @AfterEach
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
