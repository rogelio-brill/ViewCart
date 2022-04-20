package Frontend.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Home {

    public WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    // Item Locator
    By listItem = By.id("s0-0-32-4-0-0[5]-4-match-media-0-ebay-carousel-container");
    By listItem2 = By.id("s0-0-32-4-0-0[4]-4-match-media-0-ebay-carousel-list");

    // Slide List locator
    By slideList = By.id("s0-0-32-4-0-0[0]-2-match-media-0-ebay-carousel-list");

    private boolean listIsPresent() {
        try {
            driver.findElement(listItem);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean slideListIsPresent() {
        try {
            driver.findElement(slideList);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void clickItemFromList() {

        WebElement homeItemSection;

        if (listIsPresent()) {
            homeItemSection = driver.findElement(listItem);
        } else {
            homeItemSection = driver.findElement(listItem2);
        }

        List<WebElement> homeItems =  homeItemSection.findElements(By.tagName("li"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homeItems.get(0))).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
