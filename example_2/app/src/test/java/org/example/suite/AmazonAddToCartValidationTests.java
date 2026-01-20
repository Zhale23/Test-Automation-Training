package org.example.suite;

import org.example.hooks.AmazonTestHooks;
import org.testng.annotations.Test;

public class AmazonAddToCartValidationTests extends AmazonTestHooks {

    @Test
    public void shouldAddFirstIphoneToCartWhenSearching() {

        factory.amazon().searchItem("iPhone");
        factory.search().clickFirstSearchResult(driver);
        factory.detail().assertDetailPageIsDisplayed();
        factory.detail().clickAddToCartButton();
        factory.detail().confirmAddToCartAppleCare();
        factory.detail().assertItemAddedToCart();
    }
    
}
