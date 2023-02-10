import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AuthRoutesTests extends BaseTest {

    @Test(priority = 10)
    @Description("Forbids visits to home url if not authenticated")
    public void forbidsVisitsToHomeUrlIfNotAuthenticatedHome(){
        driver.get(baseUrl+"home");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Not on home page.");
    }
    @Test(priority = 20)
    @Description("Forbids visits to profile url if not authenticated")
    public void forbidsVisitsToProfileUrlIfNotAuthenticatedProfile(){
        driver.get(baseUrl+"profile");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Not on profile page.");
    }
    @Test(priority = 30)
    @Description("Forbids visits to admin cities url if not authenticated")
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated(){
        driver.get(baseUrl+"admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Not on admin cities page");
    }
    @Test(priority = 40)
    @Description("Forbids visits to admin users url if not authenticated")
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){
        driver.get(baseUrl+"admin/users");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Not on admin cities page");
    }

}
