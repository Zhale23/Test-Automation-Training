package org.example.hooks;

import org.example.config.JsTestConfig;
import org.example.factory.PagesFactory;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsTestHooks {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;
    public static HomePage homePage;
    public static PagesFactory factory;

    @BeforeTest
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(JsTestConfig.Environment.PRODUCTION_URL);

        factory = new PagesFactory(driver);
    }

    @AfterTest
    public void teardown() throws InterruptedException {
        if (driver != null) {
            System.out.println("Esperando 5 segundos antes de cerrar el navegador...");
            Thread.sleep(5000);
            driver.quit();
        }
    }

}
