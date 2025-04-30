package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Valid login with correct credentials")
    @Description("Verify user can log in with valid credentials")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("validuser@example.com");
        loginPage.enterPassword("ValidPass123");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isAtDashboard(), "User should be redirected to dashboard after login.");
    }

    @Test(priority = 2, description = "Invalid login with wrong password")
    @Description("Verify error message is shown for incorrect password")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("validuser@example.com");
        loginPage.enterPassword("WrongPass");
        loginPage.clickLogin();

        Assert.assertEquals(loginPage.getLoginError(), "Invalid credentials", "Expected invalid login message.");
    }
}
