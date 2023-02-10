import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest {
    @Test(priority = 10)
    @Description("Set locale to ES")
    public void setLocaleToES(){
        navPage.getLanguageButton().click();
        navPage.getEsButton().click();
        Assert.assertTrue(driver.getPageSource().contains("Página de aterrizaje"),
                "Header doesen't contain this message.");
    }
    @Test(priority = 20)
    @Description("Set locale to EN")
    public void setLocaleToEN() {
        navPage.getLanguageButton().click();
        navPage.getEnButton().click();
        Assert.assertTrue(driver.getPageSource().contains("Landing"),
                "Header doesen't contain this message.");
    }
    @Test(priority = 30)
    @Description("Set locale to CN")
    public void setLocaleToCN() {
        navPage.getLanguageButton().click();
        navPage.getCnButton().click();
        Assert.assertTrue(driver.getPageSource().contains("首页"),
                "Header doesen't contain this message.");
    }
    @Test(priority = 40)
    @Description("Set locale to FR")
    public void setLocaleToFR() {
        navPage.getLanguageButton().click();
        navPage.getFrButton().click();
        Assert.assertTrue(driver.getPageSource().contains("Page d'atterrissage"),
                "Header doesen't contain this message.");
    }

}
