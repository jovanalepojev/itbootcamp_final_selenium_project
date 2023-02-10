package pages;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage {
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement waitUntilPopUpIsVisible(){
        return wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/ul/li")));
    }
    public WebElement getCloseButton(){
        return driver.findElement(By.xpath("//span[@class='v-btn__content']"));
    }
    public WebElement verifyFooter(){
        return driver.
                findElement(By.
                        xpath("//div[contains(@class, 'v-card__title')]"));
    }
    public WebElement verifyHeader(){
        return driver.
                findElement(By.
                        xpath("//header[contains(@class,'v-sheet theme--light')]"));
    }
    public WebElement closeVerifyButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnClose')]"));
    }

    public WebElement waitEditDialog(){
        return wait.
                until(ExpectedConditions.
                        visibilityOfElementLocated(By.xpath("//input[@id='name']")));
    }
    public WebElement getVerifyMessage(){
        return driver.findElement(By.xpath("//input[@id='name']"));
    }
    public WebElement getInputField(){
        return driver.findElement(By.xpath("//input[@name='name']"));
    }
    public WebElement getSaveButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
    }
    public WebElement getSavePopUp(){
        return driver.findElement(By.xpath("//div[@class='v-snack__content']"));
    }
    public WebElement getMessageSaveVerification(){
        return driver.
                findElement(By.xpath("//div[@class='v-snack__content']"));
    }

    public WebElement getNewCityField(){
        return driver.
                findElement(By.
                        xpath("//div[@class='v-text-field__slot']/input[@id='name']"));
    }
    public WebElement waitDeletePopUp(){
        return wait.
                until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[contains(@class,'py-3')]")));
    }

    public WebElement waitPopUpMessage() {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[contains(@class, 'v-snack__wrapper')]" +
                                "/div[@role='status']")));

    }
    public WebElement verifyPopUpMessage(){
        return driver.
                findElement(By.
                        xpath("//div[contains(@class, 'v-snack__wrapper')]/div[@role='status']"));
    }

}
