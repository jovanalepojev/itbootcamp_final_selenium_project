import helper.Helper;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {


    @Test(priority = 10)
    @Description("Visits the signup page")
    public void visitsTheSignupPage(){
        navPage.getSingUpButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "signup",
                "Not on login page.");
    }

    @Test(priority = 20)
    @Description("Checks input types")
    public void checksInputTypes(){
        navPage.getSingUpButton().click();
        Assert.assertEquals(signupPage.getEmailField().getAttribute("type"),
                "email",
                "Not attribute found");
        Assert.assertEquals(signupPage.getPasswordField().getAttribute("type"),
                "password",
                "Not attribute found");
        Assert.assertEquals(signupPage.getConfirmPasswordField().getAttribute("type"),
                "password",
                "Not attribute found");
    }
    @Test(priority = 30)
    @Description("Displays errors when user already exists")
    public void displaysErrorsWhenUserAlreadyExists() throws InterruptedException {
//       Credentials: name: Another User
//                    email: admin@admin.com
//                    password: 12345
//                    confirm password: 12345

        navPage.getSingUpButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "signup",
                "Not on login page.");
        signupPage.getNameField().sendKeys("Another User");
        signupPage.getEmailField().sendKeys("admin@admin.com");
        signupPage.getPasswordField().sendKeys("12345");
        signupPage.getConfirmPasswordField().sendKeys("12345");
        signupPage.getSignMeButton().click();

        Assert.assertTrue(new Helper().
                        elementExist(driver, By.
                        xpath("//div[@class ='v-snack__content']")),
                "Error page is not displayed");

        Thread.sleep(5000);

        Assert.assertEquals(driver.
                        findElement(By.xpath("//div[@class ='v-snack__content']/ul/li")).
                        getText(),
                "E-mail already exists",
                "Error message is wrong");

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "signup",
                "Not on login page.");
    }
    @Test(priority = 40)
    @Description("Signup")
    public void singup() throws InterruptedException {
//       Credentials: name: Jovana Lepojev
//                    email: lepojev.j@itbootcamp.rs
//                    password: 12345
//                    confirm password: 12345

        navPage.getSingUpButton().click();
        signupPage.getNameField().sendKeys("Jovana Lepojev");
        signupPage.getEmailField().sendKeys("lepojev.j@itbootcamp.rs");
        signupPage.getPasswordField().sendKeys("12345");
        signupPage.getConfirmPasswordField().sendKeys("12345");
        signupPage.getSignMeButton().click();
        Thread.sleep(5000);
        Assert.assertEquals(messagePopUpPage.verifyFooter().
                        getText(),
                "IMPORTANT: Verify your account",
                "Message is wrong");
        messagePopUpPage.closeVerifyButton().click();
        navPage.getHomeLink().click();
        navPage.getLogOutButton().click();





    }



}
