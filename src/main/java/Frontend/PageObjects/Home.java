package Frontend.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

    public WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    // Item Locator
    By listItem = By.className("carousel__list");

    public void clickItemFromList() {
        driver.findElement(listItem).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
