package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By accountButton = By.cssSelector(".skip-account");
    private static final By homePageLogInButton = By.cssSelector("div.links:nth-child(1) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)");
    private static final By emailField = By.id("email");
    private static final By passwordField = By.id("pass");
    private static final By dashboardUsername = By.className("hello");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public static void logIn() {
        waitForElementClickable(accountButton).click();
        waitForElementClickable(homePageLogInButton).click();
        waitForElementClickable(emailField).sendKeys("ragyreskandar@yahoo.com");
        waitForElementClickable(passwordField).sendKeys(",fP~6g\"rjCu3n+;" + Keys.ENTER);
    }

    public static boolean isAtDashboard() {
        return waitForElementVisible(dashboardUsername).getText().contains("Hello, Ragy Ragheb Eskander!");
    }

}
