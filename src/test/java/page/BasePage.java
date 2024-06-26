package page;

abstract public class BasePage {

    public BasePage(){
        verifyPage();
    }

    abstract void verifyPage();
}
