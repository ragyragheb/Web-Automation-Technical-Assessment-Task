package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage serves as the foundation for all page objects in the framework.
 * It contains common methods and functionality that will be inherited by all page classes.
 */
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Default timeout in seconds
    private static final int DEFAULT_TIMEOUT = 10;

    /**
     * Constructor for BasePage
     * @param driver WebDriver instance to be used for actions
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

        // Initialize elements annotated with @FindBy, @FindBys, etc.
        PageFactory.initElements(driver, this);
    }

    /**
     * Waits for an element to be visible
     * @param locator By locator for the element
     * @return WebElement that is now visible
     */
    protected WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for an element to be clickable
     * @param locator By locator for the element
     * @return WebElement that is now clickable
     */
    protected WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Safely clicks an element after ensuring it's clickable
     * @param locator By locator for the element
     */
    protected void click(By locator) {
        waitForElementClickable(locator).click();
    }

    /**
     * Safely types text in an input field after ensuring it's visible
     * @param locator By locator for the element
     * @param text Text to type into the element
     */
    protected void type(By locator, String text) {
        WebElement element = waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Gets text from an element after ensuring it's visible
     * @param locator By locator for the element
     * @return The text contained in the element
     */
    protected String getText(By locator) {
        return waitForElementVisible(locator).getText();
    }

    /**
     * Checks if an element is displayed on the page
     * @param locator By locator for the element
     * @return true if element is displayed, false otherwise
     */
    protected boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Navigates to a specified URL
     * @param url URL to navigate to
     */
    protected void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Gets the current page title
     * @return The title of the current page
     */
    protected String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Gets the current page URL
     * @return The URL of the current page
     */
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Creates a custom wait with a specified timeout
     * @param timeoutInSeconds Timeout in seconds
     * @return A new WebDriverWait with the specified timeout
     */
    protected WebDriverWait getWait(int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }
}