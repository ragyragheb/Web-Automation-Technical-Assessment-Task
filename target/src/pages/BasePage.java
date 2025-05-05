package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public static final String URL = "https://ecommerce.tealiumdemo.com/";
    private static final By consentOptInRadioButton = By.id("privacy_pref_optin");
    private static final By consentSubmitButton = By.id("consent_prompt_submit");
    private static final int DEFAULT_TIMEOUT = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

        // Initialize elements annotated with @FindBy, @FindBys, etc.
        PageFactory.initElements(driver, this);
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    protected static WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected static WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void submitConsentOptin() {
        waitForElementClickable(consentOptInRadioButton).click();
        waitForElementClickable(consentSubmitButton).click();
    }

    protected void enterText(By locator, String text) {
        WebElement element = waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForElementVisible(locator).getText();
    }

}