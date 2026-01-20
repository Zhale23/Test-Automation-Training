package org.example.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonProductDetailPage extends BasePage {

    public static final By ADD_TO_CART_BUTTON = By.id("add-to-cart-button");
    public static final By PRODUCT_TITLE = By.id("productTitle");
    public static final By CONFIRMATION_MESSAGE = By.id("sw-atc-confirmation");
    public static final By ADD_TO_CART_APPLE_CARE_SECTION = By.id("attach-warranty-pane");
    public static final By CLOSE_BUTTON_APPLE_CARE_SECTION = By.id("attach-warranty-close-icon");

    public AmazonProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void assertDetailPageIsDisplayed() {
        WebElement detailPageElement = getElement(PRODUCT_TITLE);
        WebElement addToCartButton = getElement(ADD_TO_CART_BUTTON);
        assertTrue(detailPageElement.isDisplayed() && addToCartButton.isDisplayed(), "Detail page is not displayed.");
    }

    public void clickAddToCartButton() {
        WebElement addToCartButton = getElement(ADD_TO_CART_BUTTON);
        addToCartButton.click();
    }

    public void assertItemAddedToCart() {
        WebElement confirmationMessage = getElement(CONFIRMATION_MESSAGE);
        assertTrue(confirmationMessage.isDisplayed(), "Item was not added to cart successfully.");
    }

    public void confirmAddToCartAppleCare(){
        WebElement confrimationAppleCareSection = getElement(ADD_TO_CART_APPLE_CARE_SECTION);
        if (confrimationAppleCareSection.isDisplayed()) {
            clickElement(CLOSE_BUTTON_APPLE_CARE_SECTION);
        }
        assertTrue(confrimationAppleCareSection.isDisplayed(), "Apple Care section is not displayed after adding to cart.");
    }
}
