package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.SearchPage;

public class SearchTest extends BaseTest{
    @Test(priority = 3, description = "Search for a keyword")
    @Description("Search for a specific keyword")
    public void searchAndCheckKeyword() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        BasePage.navigateTo(BasePage.URL);
        BasePage.submitConsentOptin();
        LoginPage.logIn();
        SearchPage.searchForKeyword("shirt");
        Assert.assertTrue(SearchPage.checkKeyword("shirt"));
        Thread.sleep(3000);
    }

}
