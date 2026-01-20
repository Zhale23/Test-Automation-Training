package org.example.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage extends BasePage {

    private static final By SEARCH_TEXT_BOX = By.id("twotabsearchtextbox");
    private static final By SEARCH_RESULTS_CONTAINER = By.className("sg-col-inner");
    private static final By SEARCH_RESULTS_ITEM_LINK = By.cssSelector("a.a-link-normal.s-line-clamp-4");

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    public void searchItem(String itemToSearch) {
        typeLikeHuman(SEARCH_TEXT_BOX, itemToSearch);
    }

    public void assertSearchResultsCountExceedsMinimum(int expectedMinimumCount) {
        List<WebElement> elements = getListOfElements(SEARCH_RESULTS_CONTAINER);
        int count = 0;

        for (WebElement element : elements) {
            String text = element.getText();

            if (text.contains("iPhone")) {
                count++;
                // logger.info(text);
            }

        }

        assertTrue(count >= expectedMinimumCount, "Expected more than 7 iPhones results, but found only" + count);

    }

    public void clickFirstSearchResult(WebDriver driver) {
        List<WebElement> links = driver.findElements(SEARCH_RESULTS_ITEM_LINK);
        if (links.size() > 0) {
            links.get(0).click();
        }
    }

}
