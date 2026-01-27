package org.example.factory;

import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class PagesFactory {

    public WebDriver driver;

    public PagesFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage homePage() {
        return new HomePage(driver);
    }

}
