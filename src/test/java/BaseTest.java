import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com/";

    protected NavPage navPage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        navPage = new NavPage(driver,wait);
        loginPage = new LoginPage(driver,wait);
        signupPage = new SignupPage(driver, wait);
        citiesPage = new CitiesPage(driver,wait);
        messagePopUpPage = new MessagePopUpPage(driver,wait);
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }

    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }

}
