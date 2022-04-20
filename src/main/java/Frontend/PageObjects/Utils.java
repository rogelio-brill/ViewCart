package Frontend.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    // Locator for first searched item
    By searchedItem = By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a");

    // Locator for verify yourself button
    By verifyYourself = By.id("checkbox");

    // Locator for captcha
    By captcha = By.id("s0-70-captcha-ui");

    // Locator for cookies pop up
    By cookiesDiv = By.id("gdpr-banner");

    // Locator for cookies accept button
    By cookiesAcceptBtn = By.id("gdpr-banner-accept");

    // Universal Functionalities
    public String getTitle() {
        return driver.getTitle();
    }

    public void clickEbayLogo() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ebayLogo)).click();
    }

    public void searchItem(String item) {
        driver.findElement(searchBox).sendKeys(item);
    }

    public void clickSearch() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
    }

    public WebElement searchResultsSection() {
        return driver.findElement(searchResults);
    }

    public WebElement verifySignInRedirect() {
            return driver.findElement(enterId);
    }

    public void clickSearchedItem() {
        driver.findElement(searchedItem).click();
    }

    public void clickVerifyYourself() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(captcha));
        driver.switchTo().frame(0);
        driver.findElement(verifyYourself).click();
    }

    public boolean cookiesDivIsPresent() {
        try {
            driver.findElement(cookiesDiv);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void acceptCookies() {
        if(cookiesDivIsPresent()) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookiesAcceptBtn)).click();
        }
    }

}
