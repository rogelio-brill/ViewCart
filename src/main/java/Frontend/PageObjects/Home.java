package Frontend.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home {

    public WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    // Item Locator
    By listItem = By.id("s0-0-32-4-0-0[5]-4-match-media-0-ebay-carousel-container");

    public void clickItemFromList() {

        WebElement homeItemSection = driver.findElement(listItem);

        List<WebElement> homeItems =  homeItemSection.findElements(By.tagName("li"));

        homeItems.get(0).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
