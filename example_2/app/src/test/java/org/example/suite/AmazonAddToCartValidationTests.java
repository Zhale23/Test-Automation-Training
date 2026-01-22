package org.example.suite;

import org.example.hooks.AmazonTestHooks;
import org.testng.annotations.Test;

public class AmazonAddToCartValidationTests extends AmazonTestHooks {

    @Test
    public void shouldAddFirstIphoneToCartWhenSearching() {

        amazon.homePage().searchItem("iPhone");
        amazon.searchPage().clickFirstSearchResult(driver);
        amazon.detailPage().assertDetailPageIsDisplayed();
        amazon.detailPage().AddToCart();
    }
}
