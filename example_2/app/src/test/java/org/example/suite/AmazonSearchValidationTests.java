
package org.example.suite;

import org.testng.annotations.*;

import org.example.hooks.AmazonTestHooks;

public class AmazonSearchValidationTests extends AmazonTestHooks {

    @Test
    public void shouldDiplayMoreThanSevenIphoneResultsWhenSearching() {

        factory.amazon().searchItem("iPhone");
        factory.amazon().assertSearchResultsCountExceedsMinimum(7);
    }

    @Test
    public void shouldDiplayMoreThanSevenLaptopsResultsWhenSearching() {
        factory.amazon().searchItem("Laptops");
        factory.amazon().assertSearchResultsCountExceedsMinimum(0);
    }
}
