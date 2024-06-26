package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static junit.framework.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class TestErrorLogin {
    private static final String LOGIN = "locked_out_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";

    @BeforeEach
    public void setUp(){
        Selenide.open("https://www.saucedemo.com/");
    }

     @Test
    public void testErrorLogin(){
        LoginPage loginPage = new LoginPage()
                .fillUsername(LOGIN)
                .fillPassword(PASSWORD)
                .clickLogin()
                .andFailureLogin();
        assertThat(loginPage.getErrorText()).as("Неправильная ошибка").contains(ERROR_MESSAGE);
    }


    @AfterEach
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }
}
