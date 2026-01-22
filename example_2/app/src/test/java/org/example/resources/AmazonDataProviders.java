package org.example.resources;

import org.testng.annotations.DataProvider;

public class AmazonDataProviders {
    @DataProvider(name = "searchItems")
    public Object[][] searchItems() {
        return new Object[][]{
                {"iPhone"},
                {"Laptops"},
                {"Headphones"}
        };
    }
}
