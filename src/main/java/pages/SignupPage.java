package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameField(){
        return driver.findElement(By.id("name"));
    }
    public WebElement getEmailField(){
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordField(){
        return driver.findElement(By.id("password"));
    }
    public WebElement getConfirmPasswordField(){
        return driver.findElement(By.id("confirmPassword"));
    }
    public WebElement getSignMeButton(){
        return driver.findElement(By.xpath("//*[@type ='submit']"));
    }
}
