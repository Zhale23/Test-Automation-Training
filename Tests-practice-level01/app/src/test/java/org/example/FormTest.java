package org.example;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormTest {
    private WebDriver driver;
        private Actions action;
        private WebDriverWait wait;
    
    @BeforeTest
    public void setup(){
        String URLinicial= "https://the-internet.herokuapp.com";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URLinicial);
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    @Test
    public void shouldDisplayLoginForm(){
        WebElement LoginLink = wait
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Form Authentication")));

        action.click(LoginLink).perform();
        // wait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/login"));  
        assertTrue(driver.getCurrentUrl().contains("/login"), "La URL no correponde al login");
    }

    @AfterTest 
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
