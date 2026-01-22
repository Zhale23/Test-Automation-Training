package org.example.suite;

import org.example.hooks.AmazonTestHooks;
import org.testng.annotations.Test;

public class SearchFilterTest extends AmazonTestHooks {

    @Test
    public void testApplyFirstFilter() {
        amazon.homePage().searchItem("Headphones");
        amazon.searchPage().applyFirstFilter();
    }
}
