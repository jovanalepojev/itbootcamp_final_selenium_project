import helper.Helper;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import javax.swing.plaf.TreeUI;

public class AdminCitiesTests extends BaseTest {

    @Test(priority = 10)
    @Description("Visits the admin cities page and list cities")
    public void visitsTheAdminCitiesPageAndListCities() throws InterruptedException {
//       Credentials:admin email: admin@admin.com
//                   admin password: 12345

        navPage.getLogInButton().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().sendKeys("12345");
        loginPage.getLogInButton().click();
        Thread.sleep(2000);
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "admin/cities",
                "Not on login page.");
    }
    @Test(priority = 20)
    @Description("Checks input types for create/edit new city")
    public void checksInputTypesForCreateEditNewCity() throws InterruptedException {
//        navPage.getLogInButton().click();

//        loginPage.getEmailField().sendKeys("admin@admin.com");
//        loginPage.getPasswordField().sendKeys("12345");
//        loginPage.getLogInButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Thread.sleep(2000);
        citiesPage.getNewItemButton().click();
        messagePopUpPage.waitEditDialog();
        Assert.assertEquals(messagePopUpPage.getVerifyMessage().getAttribute("type"),
                "text",
                "Error message is wrong");
    }
    @Test(priority = 30)
    @Description("Create new city")
    public void createNewCity() throws InterruptedException {
//       Credentials: City:Lepojev Jovana's city

//        navPage.getLogInButton().click();
//        loginPage.getEmailField().sendKeys("admin@admin.com");
//        loginPage.getPasswordField().sendKeys("12345");
//        loginPage.getLogInButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        messagePopUpPage.waitEditDialog();
        messagePopUpPage.getInputField().sendKeys("Lepojev Jovana's city");
        messagePopUpPage.getSaveButton().click();
        messagePopUpPage.getSavePopUp();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Saved successfully"),
                "Error message is wrong");
    }
    @Test(priority = 40)
    @Description("Edit city")
    public void editCity() throws InterruptedException {
//       Credentials: old city name: Lepojev Jovana's city
//                    new city name: Lepojev's city

//        navPage.getLogInButton().click();
//        loginPage.getEmailField().sendKeys("admin@admin.com");
//        loginPage.getPasswordField().sendKeys("12345");
//        loginPage.getLogInButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Lepojev Jovana's city");
        Thread.sleep(2000);
        citiesPage.waitForNumberOfRowsToBe(1);
        citiesPage.getEditButton(1).click();
        Thread.sleep(3000);
        messagePopUpPage.clearInputField();
        Thread.sleep(3000);
        messagePopUpPage.getNewCityField().sendKeys("Lepojev's city");
        Thread.sleep(3000);
        citiesPage.getSaveButton().click();

    }

    @Test(priority = 50)
    @Description("Search city")
    public void searchCity() throws InterruptedException {
//       Credentials: city name: Lepojev's city

//        navPage.getLogInButton().click();
//        loginPage.getEmailField().sendKeys("admin@admin.com");
//        loginPage.getPasswordField().sendKeys("12345");
//        loginPage.getLogInButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Lepojev's city");
        citiesPage.waitForNumberOfRowsToBe(1);
        Thread.sleep(2000);
        Assert.assertEquals(citiesPage.getCell(1,2).getText(),
                "Lepojev's city",
                "Error message is wrong");
    }
    @Test(priority = 60)
    @Description(" Delete city")
    public void deleteCity() throws InterruptedException {
//       Credentials: city name: Lepojev's city

        navPage.getLogInButton().click();
        loginPage.getEmailField().sendKeys("admin@admin.com");
        loginPage.getPasswordField().sendKeys("12345");
        loginPage.getLogInButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Lepojev's city");
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertEquals(citiesPage.getCell(1,2).getText(),
                "Lepojev Jovana's city",
                "Error message is wrong");
        citiesPage.getDeleteInRowButton(1).click();
        messagePopUpPage.waitDeletePopUp();
        Thread.sleep(2000);
        citiesPage.getPopUpDeleteButton().click();
        Thread.sleep(2000);
        messagePopUpPage.waitPopUpMessage();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Deleted successfully"),
                "Error message is wrong");
    }
}
