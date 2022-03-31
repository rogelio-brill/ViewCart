package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Checkout {

    WebDriver driver;

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for item in checkout
    By checkoutSingleItem = By.className("seller-buckets");

    public WebElement checkoutSingleItem() {
        return driver.findElement(checkoutSingleItem);
    }
}
