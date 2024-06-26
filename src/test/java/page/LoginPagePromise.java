package page;

public class LoginPagePromise {
    public ShowcasePage andSuccessLogin() {
        return new ShowcasePage();
    }

    public LoginPage andFailureLogin() {
        return new LoginPage();
    }
}
