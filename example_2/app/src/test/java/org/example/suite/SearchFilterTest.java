package org.example.suite;

import org.example.hooks.AmazonTestHooks;
import org.testng.annotations.Test;

public class SearchFilterTest extends AmazonTestHooks {

    @Test
    public void testApplyFirstFilter() {
        factory.amazon().searchItem("Headphones");
        factory.search().applyFirstFilter();
    }
}
