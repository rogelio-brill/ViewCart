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
    By listItem3 = By.id("s0-0-32-4-0-0[6]-4-match-media-0-ebay-carousel-list");
    By listItem4 = By.id("s0-0-32-4-0-0[7]-4-match-media-0-ebay-carousel-list");
    By listItem5 = By.id("s0-0-32-4-0-0[5]-4-match-media-0-ebay-carousel-list");

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

    private boolean list2IsPresent() {
        try {
            driver.findElement(listItem2);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    private boolean list3IsPresent() {
        try {
            driver.findElement(listItem3);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    private boolean list5IsPresent() {
        try {
            driver.findElement(listItem5);
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
        } else if(list2IsPresent()){
            homeItemSection = driver.findElement(listItem2);
        }else if(list3IsPresent()){
            homeItemSection = driver.findElement(listItem3);
        } else if(list5IsPresent()){
            homeItemSection = driver.findElement(listItem5);
        }else {
            homeItemSection = driver.findElement(listItem4);
        }

        List<WebElement> homeItems =  homeItemSection.findElements(By.tagName("li"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(homeItems.get(0))).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
