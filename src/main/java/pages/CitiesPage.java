package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CitiesPage extends BasePage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnNewItem')]"));
    }
    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }
    public WebElement getEditBox() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(@class, 'btnSave')]")));
    }
    public WebElement getDeleteBox() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(@class, 'v-btn')]")));
    }
    public WebElement getSaveButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
    }

    public List<WebElement> waitForNumberOfRowsToBe(int expectedNumOfRows) {
        return wait.until(ExpectedConditions
                .numberOfElementsToBe(By.xpath("//thead[@class='v-data-table-header']/tr"), expectedNumOfRows));
    }
    public WebElement getCell(int row, int cell) {
         return driver.findElement(By.
                    xpath("//div[contains(@class,'container--fluid')]" +
                            "/div/div[1]/div[2]/table/tbody/tr["+row+"]/td["+cell+"]"));
    }
    public WebElement getEditButton(int row){
        return driver.
                findElement(By.
                xpath("//table/tbody/tr["+row+"]/td/div/button[@id='edit']"));
    }
    public WebElement getDeleteInRowButton(int row) {
        return driver.
                findElement(By.
                        xpath("//table/tbody/tr["+row+"]/td/div/button[@id='delete']"));
    }
    public WebElement getPopUpDeleteButton(){
        return driver.
                findElement(By.
                        xpath("//div[contains(@class,'v-dialog--active')]/div/div[2]/button[2]/span"));
    }








}
