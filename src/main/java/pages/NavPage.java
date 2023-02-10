package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeLink(){
        return driver.findElement(By.linkText("HOME"));
    }
    public WebElement getAboutLink(){
        return driver.findElement(By.linkText("ABOUT"));
    }
    public WebElement getMyProfileLink(){
        return driver.findElement(By.linkText("MY PROFILE"));
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnAdmin')]"));
    }

    public WebElement getCitiesLink(){
        return driver.findElement(By.xpath("//a[@href='/admin/cities']"));
    }
    public WebElement getUsersLink(){
        return driver.findElement(By.xpath("//a[@href='/admin/users']"));
    }
    public WebElement getSingUpButton(){
        return driver.findElement(By.xpath("//a[@href='/signup']"));
    }
    public WebElement getLogInButton(){
        return driver.findElement(By.xpath("//a[@href='/login']"));
    }
    public WebElement getLogOutButton(){
        return driver.findElement(By.
                xpath("//button[contains(@class, 'btnLogout ')]"));
    }
    public WebElement getLanguageButton(){
        return driver.findElement(By.
                xpath("//button[contains(@class, 'btnLocaleActivation')]"));
    }

    public WebElement getEnButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'btnEN')]"));
    }
    public WebElement getEsButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'btnES')]"));
    }
    public WebElement getFrButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'btnFR')]"));
    }
    public WebElement getCnButton(){
        return driver.findElement(By.xpath("//div[contains(@class, 'btnCN')]"));
    }

}
