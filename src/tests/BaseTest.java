package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import io.qameta.allure.Step;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Step("Setting up browser before test")
    public void setUp() {
        driver = DriverFactory.initDriver();
    }

    @AfterMethod
    @Step("Quitting browser after test")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
