package org.example.pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public static final By THIRD_LIST_ITEM = By.xpath("//div[@class='example']//ul/li[3]");
    public static final String TEXT_TO_TYPE_IN_ALERT = "Hello World";
    public static final By TEXT_TIPED_SHOW_ITEM = By.id("result");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickThirdElement() {
        getElement(THIRD_LIST_ITEM).click();
    }

    public void JsAlertTypeAndConfirm() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(TEXT_TO_TYPE_IN_ALERT);
        alert.accept();
    }

    public void JsAlertTextTypedConfirm() {
        assertTrue(getElement(TEXT_TIPED_SHOW_ITEM).getText().contains(TEXT_TO_TYPE_IN_ALERT),
                "The text typed in the alert is not shown in the page");
    }
}
