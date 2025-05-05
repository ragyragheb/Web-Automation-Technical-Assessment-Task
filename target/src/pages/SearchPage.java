package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;

public class SearchPage extends BasePage {
    private static final By searchField = By.id("search");
    private static final By searchItem = By.cssSelector(".page-title > h1:nth-child(1)");
    private static final Logger log = Logger.getLogger(SearchPage.class.getName());
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public static void searchForKeyword(String keyword) {
        waitForElementVisible(searchField).sendKeys(keyword + Keys.ENTER);
    }

    public static boolean checkKeyword(String keyword) {
        String searchItemText = waitForElementVisible(searchItem).getText();
        return searchItemText.toLowerCase().contains(keyword);
    }
}
