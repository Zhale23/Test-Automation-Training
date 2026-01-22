package org.example.hooks;

// import java.time.Duration;

import org.example.config.AmazonTestConfig;
import org.example.factory.PagesFactory;
import org.example.pages.AmazonHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
// import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestHooks {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;
    public static AmazonHomePage homePage;
    public static PagesFactory amazon;

    @BeforeTest
    public void setup() {

        if (AmazonTestConfig.Environment.GLOBAL_BROWSER.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (AmazonTestConfig.Environment.GLOBAL_BROWSER.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(AmazonTestConfig.Environment.PRODUCTION_URL);

        amazon = new PagesFactory(driver);
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
