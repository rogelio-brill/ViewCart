package Frontend.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ViewCart {

    WebDriver driver;

    public ViewCart(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for Item Name
    By itemName = By.cssSelector(".ux-textspans.ux-textspans--BOLD");

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
    By itemOtherPictures = By.className("v-pic-item");

    // Locator for item quantity text box
    By itemQuantity = By.id("qtyTextBox");

    // Locator for item seller information
    By itemSellerInfo = By.cssSelector(".vim.x-about-this-seller");

    // Locator for buy now button
    By buyNowButton = By.id("binBtn_btn");

    // Locator for protection plan pop up
    By protectionPlan = By.id("vi_oly_ADDON_0");

    // Locator for protection plan decline
    By protectionPlanDecline = By.xpath("//*[text()='No thanks']");

    // Locator for Continue as guest button
    By guestButton = By.id("sbin-gxo-btn");

    // Locator for Add to cart button
    By addToCartButton = By.id("atcRedesignId_btn");

    // Locator for view cart button
    By viewCartButton = By.cssSelector(".btn.btn-scnd.vi-VR-btnWdth-XL");

    // Locator for add to wishlist button
    By wishlistButton = By.id("vi-atl-lnk-99");

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


    // ---------------------------------------------------------------
    // View Item Functionalities
    public WebElement itemName() {
        return driver.findElement(itemName);
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

    public List<WebElement> otherPictures() {
        return driver.findElements(itemOtherPictures);
    }

    public void enterItemQuantity(String amount) {
        driver.findElement(itemQuantity).clear();
        driver.findElement(itemQuantity).sendKeys(amount);
    }

    public String getQuantity() { return driver.findElement(itemQuantity).getAttribute("value"); }

    public WebElement sellerInfo() {
        return driver.findElement(itemSellerInfo);
    }

    public void clickBuyNow() {
        driver.findElement(buyNowButton).click();
    }

    public void clickGuest() {
        driver.findElement(guestButton).click();
    }

    public void clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton)).click();
    }

    public void clickViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton)).click();
    }

    public void clickWishlist() {
        driver.findElement(wishlistButton).click();
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

}
