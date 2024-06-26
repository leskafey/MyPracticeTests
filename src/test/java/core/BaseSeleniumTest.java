package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public abstract class BaseSeleniumTest {
    protected WebDriver driver;

    public BaseSeleniumTest(){
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(this.driver);
    }

    @AfterEach
    public void tearDown(){
        this.driver.close();
        this.driver.quit();
    }
}
