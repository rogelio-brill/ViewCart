package Frontend.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

    public WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    // Item Locator
    By listItem = By.id("s0-0-32-4-0-0[3]-4-match-media-0-ebay-carousel-list");

    public void clickItemFromList() {
        driver.findElement(listItem).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
