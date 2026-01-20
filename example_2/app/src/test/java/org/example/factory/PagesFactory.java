package org.example.factory;

import org.example.pages.AmazonHomePage;
import org.example.pages.AmazonProductDetailPage;
import org.example.pages.AmazonSearchResults;
import org.openqa.selenium.WebDriver;

public class PagesFactory {

    public WebDriver driver;
    
    public PagesFactory(WebDriver driver){
        this.driver = driver;
    }

    public AmazonHomePage amazon() {
        return new AmazonHomePage(driver);
    }

    public AmazonProductDetailPage detail() {
        return new AmazonProductDetailPage(driver);
    }

    public AmazonSearchResults search() {
        return new AmazonSearchResults(driver);
    }
}
