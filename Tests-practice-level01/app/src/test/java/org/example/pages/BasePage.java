package org.example.pages;

import org.example.config.JsTestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriverWait wait;
    private Actions action;

    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, JsTestConfig.Environment.GLOBAL_WAIT_TIMEOUT);
        action = new Actions(driver);
    }

    public void typeLikeHuman(By element, String text) {
        WebElement searchTextBox = wait
                .until(ExpectedConditions.elementToBeClickable(element));

        action
                .moveToElement(searchTextBox)
                .click()
                .pause(JsTestConfig.Environment.GLOBAL_ACTION_KEY_SEQUENCE_DELAY)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys(text)
                .pause(JsTestConfig.Environment.GLOBAL_ACTION_KEY_SEQUENCE_DELAY)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    public WebElement getElement(By element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public WebElement clickElement(By element) {
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        clickableElement.click();
        return clickableElement;
    }
}
