package Frontend.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ViewCart {

    WebDriver driver;

    public ViewCart(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for Item Name
    By sItemName = By.className("//*[@id=\"LeftSummaryPanel\"]/div[1]/div[1]/div/h1/span");
    By itemName = By.cssSelector(".ux-textspans.ux-textspans--BOLD");
    //By itemName = By.cssSelector(".vim.x-item-title");

    // Locator for Item Description
    By itemDescription = By.id("viTabs_0_is");

    // Locator for Item Shipping
    By itemShippingBtn = By.id("viTabs_1");
    By itemShipping = By.id("vi-ship-maincntr");

    // Locator for Item Condition
    By itemCondition = By.cssSelector(".vim.d-item-condition");

    // Locator for Item Price
    By itemPrice = By.className("lbl-value-set");

    //Locator for Item Main Price
    By itemMainPrice = By.className("mainPrice");

    //Locator for Item Discount Price
    By itemDiscountPrice = By.className("discountPrice");

    //Locator for Item Buy Box Price
    By itemBuyBoxPrice = By.className("vi-ppc-buybox-msg");

    // Locator for main item Picture
    By itemMainPicture = By.id("icImg");

    // Locator for other item Picture
    By itemOtherPictures = By.id("vertical-align-items-viewport");
    By itemOtherPictures2 = By.cssSelector(".lst.icon");

    // Locator for item quantity text box
    By itemQuantity = By.id("qtyTextBox");
    //Locator for quantity error message
    By quantityErrMsg = By.id("qtyErrMsg");

    // Locator for item seller information
    By itemSellerInfo = By.cssSelector(".vim.x-about-this-seller");

    // Locator for buy now button
    By buyNowButton = By.id("binBtn_btn");

    // Locator for protection plan pop up
    By protectionPlan = By.id("vi_oly_ADDON_0");

    // Locator for protection plan decline
    By protectionPlanDecline = By.xpath("//*[text()='No thanks']");

    // Locator for guest option
    By guestOption = By.id("streamline-bin-layer");

    // Locator for Continue as guest button
    By guestButton = By.id("sbin-gxo-btn");

    // Locator for Add to cart button
    By addToCartButton = By.id("isCartBtn_btn");
    By addToCartButton2 = By.id("atcRedesignId_btn");

    // Locator for Add to cart options
    By addToCartOptions = By.id("atcRedesignId_overlay-atc-container");

    // Locator for view cart button
    By viewCartButton = By.cssSelector(".btn.btn-scnd.vi-VR-btnWdth-XL");

    // Locator for add to wishlist button
    By watchlistButton = By.id("vi-atl-lnk-99");

    // Locator for buy with confidence section
    By confidenceSection = By.cssSelector(".vim.x-shop-with-confidence");

    // Locator for item Sold section
    By itemSoldSection = By.cssSelector(".w2b.w2bsls");

    // Locator for item Sold Subsection
    By itemSoldSubSection = By.className("w2b-sgl");

    // Locator for similar items list
    By similarItems = By.id("1011950-c0-19[0[0[0]]]-24-list");

    // Locator for sponsored items from seller
    By sellerItems = By.id("1011960-c0-19[0[0[0]]]-24-list");

    // Locator for Footer Links
    By footerLinks = By.id("gf-l");

    // Locator for Select Options
    By selectOptions = By.id("msku-sel-1");

    //Locator for Select options error message
    By selectErrMsg = By.id("msku-sel-1-errMsg");

    // Locator for shipping quantity
    By shippingQuantity = By.id("shQuantity");

    // Locator for shipping quantity error msg
    By shippingQtyErrMsg = By.id("shQuantity-errTxt");


    // ---------------------------------------------------------------
    // View Item Functionalities
    public WebElement itemName() {
        return driver.findElement(itemName);
    }
    public WebElement searchedItemName() {
        return driver.findElement(sItemName);
    }


    public WebElement itemDescription() {
        return driver.findElement(itemDescription);
    }

    public WebElement itemShipping() {
        driver.findElement(itemShippingBtn).click();
        return driver.findElement(itemShipping);
    }

    public WebElement itemCondition() {
        return driver.findElement(itemCondition);
    }

    public WebElement itemPrice() {
        return driver.findElement(itemPrice);
    }

    public WebElement mainPrice() {
        return driver.findElement(itemMainPrice);
    }

    public WebElement discountPrice() {
        return driver.findElement(itemDiscountPrice);
    }

    public WebElement buyBoxPrice() {
        return driver.findElement(itemBuyBoxPrice);
    }

    public WebElement mainPicture() {
        return driver.findElement(itemMainPicture);
    }

    public boolean otherPicturesArePresent() {
        try {
            driver.findElement(itemOtherPictures);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean otherPicturesArePresent2() {
        try {
            driver.findElement(itemOtherPictures2);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public List<WebElement> otherPictures() {

        WebElement otherPicturesSection;
        if(otherPicturesArePresent()) {
            otherPicturesSection = driver.findElement(itemOtherPictures);
        }else {
            otherPicturesSection = driver.findElement(itemOtherPictures2);
        }

        return otherPicturesSection.findElements(By.tagName("li"));
    }

    public void enterItemQuantity(String amount) {
        driver.findElement(itemQuantity).clear();
        driver.findElement(itemQuantity).sendKeys(amount);
    }

    public WebElement quantityErrorMsg() {
        return driver.findElement(quantityErrMsg);
    }

    public String getQuantity() { return driver.findElement(itemQuantity).getAttribute("value"); }

    public WebElement sellerInfo() {
        return driver.findElement(itemSellerInfo);
    }

    public void clickBuyNow() {
        driver.findElement(buyNowButton).click();
    }

    public boolean guestOptionIsPresent() {
        try {
            driver.findElement(guestOption);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void clickGuest() {
        driver.findElement(guestButton).click();
    }

    public boolean addToCartIsPresent() {
        try {
            driver.findElement(addToCartButton);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void clickAddToCart() {
       if(addToCartIsPresent()) {
           driver.findElement(addToCartButton).click();
       }else {
           driver.findElement(addToCartButton2).click();
       }
    }

    public boolean addToCartOptionsIsPresent() {
        try {
            driver.findElement(addToCartOptions);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void clickViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton)).click();
    }

    public void clickWatchlist() {
        driver.findElement(watchlistButton).click();
    }

    public WebElement confidenceSection() {
        return driver.findElement(confidenceSection);
    }

    public List<WebElement> soldSection() {
        return driver.findElements(itemSoldSubSection);
    }

    public List<WebElement> similarItemsList() {
        WebElement similarItemsSection = driver.findElement(similarItems);

        return similarItemsSection.findElements(By.tagName("li"));
    }

    public List<WebElement> sellerItemsList() {
        WebElement sellerItemsSection = driver.findElement(sellerItems);

        return sellerItemsSection.findElements(By.tagName("li"));
    }

    public List<WebElement> footerLinksList() {
        WebElement footerLinksSection = driver.findElement(footerLinks);

        return footerLinksSection.findElements(By.tagName("li"));
    }

    public boolean isSelectPresent() {
        try {
            driver.findElement(selectOptions);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void selectDefault() {
        Select options = new Select(driver.findElement(selectOptions));
        options.selectByIndex(0);
    }

    public void selectOption(int index) {
        Select options = new Select(driver.findElement(selectOptions));
        options.selectByIndex(index);
    }

    public WebElement selectErrorMsg() {
        return driver.findElement(selectErrMsg);
    }

    public void enterShippingQuantity(String amount) {
        driver.findElement(itemShippingBtn).click();
        driver.findElement(shippingQuantity).clear();
        driver.findElement(shippingQuantity).sendKeys(amount);
    }

    public String getShippingQuantity() {
        return driver.findElement(shippingQuantity).getAttribute("value");
    }

    public WebElement shippingQtyErrorMsg() {
        return driver.findElement(shippingQtyErrMsg);
    }

    public boolean isProtectionPresent() {
        try {
            driver.findElement(protectionPlan);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void declineProtectionPlan() {
        driver.findElement(protectionPlanDecline).click();
    }

}
