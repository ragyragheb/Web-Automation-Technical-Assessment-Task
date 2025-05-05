package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SearchPage;
import pages.LoginPage;



public class LoginTest extends BaseTest {
    @Test(priority = 1, description = "Valid login with valid credentials")
    @Description("Verify user can log in with valid credentials")
    public void testValidLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        BasePage.navigateTo(BasePage.URL);
        BasePage.submitConsentOptin();
        LoginPage.logIn();
        Thread.sleep(3000);
        Assert.assertTrue(LoginPage.isAtDashboard());
    }


}
