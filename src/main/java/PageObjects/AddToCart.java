package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToCart {
    WebDriver driver;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for items in cart
    By cartList = By.className("cart-bucket__vendor-list");

    public List<WebElement> cartItemList() {
        return driver.findElements(cartList);
    }

}
