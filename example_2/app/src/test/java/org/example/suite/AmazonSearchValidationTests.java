
package org.example.suite;

import org.testng.annotations.*;

import org.example.hooks.AmazonTestHooks;

public class AmazonSearchValidationTests extends AmazonTestHooks {

    // @Test
    // public void shouldDiplayMoreThanSevenIphoneResultsWhenSearching() {

    //     amazon.homePage().searchItem("iPhone");
    //     amazon.searchPage().assertSearchResultsCountExceedsMinimum(7);
    // }

    // @Test
    // public void shouldDiplayMoreThanSevenLaptopsResultsWhenSearching() {
    //     amazon.homePage().searchItem("Laptops");
    //     amazon.searchPage().assertSearchResultsCountExceedsMinimum(0);
    // }

    @Test(dataProvider = "searchItems", dataProviderClass = org.example.resources.AmazonDataProviders.class)
    public void shouldDiplayMoreThanSevenItemsResultsWhenSearching(String item) {
        amazon.homePage().searchItem(item);
    }
}
