import helper.Helper;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test (priority = 10)
    @Description("Visits the login page")
    public void visitsTheLoginPage(){

        navPage.getLanguageButton().click();
        navPage.getEnButton().click();
        navPage.getLogInButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Not on login page.");
    }

    @Test (priority = 20)
    @Description("Checks input types")
    public void checksInputTypes(){
        navPage.getLogInButton().click();
        Assert.assertEquals(loginPage.getEmailField().getAttribute("type"),
                "email",
                "Not attribute found");
        Assert.assertEquals(loginPage.getPasswordField().getAttribute("type"),
                "password",
                "Not attribute found");
    }
    @Test (priority = 30)
    @Description("Displays errors when user does not exist")
    public void displayErrorsWhenUserDoesNotExist() throws InterruptedException {
//        Credentials: email: non-existing-user@gmal.com
//                     password: password123

        navPage.getLogInButton().click();
        loginPage.getEmailField().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordField().sendKeys("password123");
        loginPage.getLogInButton().click();

        Assert.assertTrue(new Helper().
                elementExist(driver, By.xpath("//div[@class ='v-snack__content']")),
                "Error page is not displayed");
        Thread.sleep(5000);
        Assert.assertEquals(messagePopUpPage.waitUntilPopUpIsVisible().getText(),
                "User does not exists",
                "Error message is wrong" );

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Not on login page.");
    }
    @Test(priority = 40)
    @Description("Displays errors when password is wrong")
    public void displaysErrorsWhenPasswordIsWrong() throws InterruptedException {
//        Credentials: email: admin@admin.com
//                     password: password123
        navPage.getLogInButton().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().sendKeys("password123");
        loginPage.getLogInButton().click();

        Assert.assertTrue(new Helper().
                        elementExist(driver, By.
                        xpath("//div[contains(@class, 'v-snack__wrapper')]")),
                        "Error page is not displayed");
        Thread.sleep(5000);

        Assert.assertEquals(messagePopUpPage.waitUntilPopUpIsVisible().getText(),
                "Wrong password",
                "Error message is wrong");

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Not on login page.");
    }

    @Test(priority = 50)
    @Description("Login")
    public void login() throws InterruptedException {
//        Credentials: email: admin@admin.com
//                     password: 12345
        navPage.getLogInButton().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().sendKeys("12345");
        loginPage.getLogInButton().click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "home",
                "Not on login page.");
    }
    @Test(priority = 60)
    @Description("Logout")
    public void logout(){
        Assert.assertTrue(
				new Helper().elementExist(driver, By.className("v-btn__content")),
			    "Logout button is not displayed.");
        navPage.getLogOutButton().click();

    }


}
