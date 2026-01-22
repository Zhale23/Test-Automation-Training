package org.example.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSearchResults extends BasePage {
    private static final By SEARCH_RESULTS_ITEM_LINK = By.cssSelector("a.a-link-normal.s-line-clamp-4");
    private static final By BRAND_SECTION = By
            .xpath("//div[@id='brandsRefinements' or contains(@aria-labelledby, 'Brand')]");
    private static final By BRAND_LIST_ITEMS = By.cssSelector("li.a-spacing-micro");
    private static final By CHECKBOX_ICON = By.cssSelector("i.a-icon.a-icon-checkbox");

    public AmazonSearchResults(WebDriver driver) {
        super(driver);
    }

    public void clickFirstSearchResult(WebDriver driver) {
        List<WebElement> links = driver.findElements(SEARCH_RESULTS_ITEM_LINK);
        if (links.size() > 0) {
            links.get(0).click();
        }
    }

    public void applyFirstFilter() {
        WebElement brandSection = getElement(BRAND_SECTION);
        System.out.println("Sección de marcas encontrada");

        List<WebElement> brandListItems = brandSection.findElements(BRAND_LIST_ITEMS);

        if (brandListItems.size() > 0) {
            WebElement firstBrandItem = brandListItems.get(0);
            String brandName = firstBrandItem.getText();

            System.out.println("Aplicando filtro de marca: " + brandName);

            WebElement clickableElement = firstBrandItem.findElement(CHECKBOX_ICON);
            clickableElement.click();

            System.out.println("Filtro aplicado exitosamente.");
        } else {
            System.out.println("No se encontraron filtros de marca.");
        }

        assertTrue(brandListItems.size() > 0, "No se encontraron filtros de marca para aplicar.");
    }

    public void assertSearchResultsCountExceedsMinimum(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertSearchResultsCountExceedsMinimum'");
    }

}
