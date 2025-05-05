package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    // Method to initialize WebDriver
    public static WebDriver initDriver() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Return a new ChromeDriver instance
        return new ChromeDriver();
    }
}
