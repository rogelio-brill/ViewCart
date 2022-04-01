package Frontend.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

    WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for Ebay logo
    By ebayLogo = By.id("gh-la");

    // Locator for Ebay search box
    By searchBox = By.id("gh-ac");

    // Locator for Ebay search button
    By searchButton = By.id("gh-btn");

    // Locator for redirect sign in button
    By enterId = By.id("userid");

    // Locator for search item results
    By searchResults = By.className("srp-controls__count-heading");

    // Universal Functionalities
    public String getTitle() {
        return driver.getTitle();
    }

    public void clickEbayLogo() {
        driver.findElement(ebayLogo).click();
    }

    public void searchItem(String item) {
        driver.findElement(searchBox).sendKeys(item);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public WebElement searchResultsSection() {
        return driver.findElement(searchResults);
    }

    public WebElement verifySignInRedirect() {
            return driver.findElement(enterId);
    }

}
