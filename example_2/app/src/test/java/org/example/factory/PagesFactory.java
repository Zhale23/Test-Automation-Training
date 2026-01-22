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

    public AmazonHomePage homePage() {
        return new AmazonHomePage(driver);
    }

    public AmazonProductDetailPage detailPage() {
        return new AmazonProductDetailPage(driver);
    }

    public AmazonSearchResults searchPage() {
        return new AmazonSearchResults(driver);
    }
}
