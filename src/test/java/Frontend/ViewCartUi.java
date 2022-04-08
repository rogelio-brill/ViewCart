package Frontend;

import Frontend.Helper.*;
import Frontend.PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;

public class ViewCartUi extends BaseDriver {

    public WebDriver driver;
    private Home home;
    private ViewCart viewCart;
    private Utils utils;

    @BeforeMethod
    @Parameters({"site"})
    public void init(@Optional String site) throws IOException {
        driver = BaseDriver.getDriver(site);
        home = new Home(driver);
        viewCart = new ViewCart(driver);
        utils = new Utils(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void test_ViewCartPage() {
        home.clickItemFromList();

        boolean itemNameDisplayed = viewCart.itemName().isDisplayed();

        Assert.assertTrue(itemNameDisplayed);
    }

    @Test
    public void test_VerifyItemDetails() {
        home.clickItemFromList();

        boolean itemName = viewCart.itemName().isDisplayed();
        boolean itemCondition = viewCart.itemCondition().isDisplayed();
        boolean itemPrice = viewCart.itemPrice().isDisplayed();
        boolean itemDescription = viewCart.itemDescription().isDisplayed();
        boolean itemShipping = viewCart.itemShipping().isDisplayed();

        Assert.assertTrue(itemName);
        Assert.assertTrue(itemCondition);
        Assert.assertTrue(itemPrice);
        Assert.assertTrue(itemDescription);
        Assert.assertTrue(itemShipping);
    }

    @Test
    public void test_VerifyItemPictures() {
        home.clickItemFromList();
        boolean mainPic = viewCart.mainPicture().isDisplayed();
        List<WebElement> otherPics = viewCart.otherPictures();

        Assert.assertTrue(mainPic);
        Assert.assertTrue(otherPics.size() >= 1);
    }

    @Test
    public void test_VerifySellerInfo() {
        home.clickItemFromList();
        boolean sellerInfo = viewCart.sellerInfo().isDisplayed();

        Assert.assertTrue(sellerInfo);
    }

    @Test
    public void test_ShopWithConfidenceSection() {
        home.clickItemFromList();
        boolean confidenceSection = viewCart.confidenceSection().isDisplayed();

        Assert.assertTrue(confidenceSection);
    }

    @Test
    public void test_EditQuantity() { // implement data provider
        home.clickItemFromList();
        viewCart.enterItemQuantity("4");
        String itemQuantity = viewCart.getQuantity();

        Assert.assertEquals(itemQuantity, "4");
    }

    @Test
    public void test_VerifyNumbersSoldAndWatchers() {
        home.clickItemFromList();
        List<WebElement> numberSoldAndWatchers = viewCart.soldSection();

        Assert.assertEquals(numberSoldAndWatchers.size(), 3);
    }

    @Test
    public void test_BuyItNow() { // Close protection plan frame
        Checkout checkout = new Checkout(driver);

        home.clickItemFromList();
        viewCart.clickBuyNow();
        viewCart.clickGuest();
        boolean buyNowWorks = checkout.checkoutSingleItem().isDisplayed();

        Assert.assertTrue(buyNowWorks);
    }

    @Test
    public void test_AddToCart() { // Cannot find element sometimes because of different id's
        AddToCart addToCart = new AddToCart(driver);

        home.clickItemFromList();
        viewCart.clickAddToCart();
        viewCart.clickViewCart();
        List<WebElement> cartItems = addToCart.cartItemList();

        Assert.assertTrue(cartItems.size() >= 1);
    }

    @Test
    public void test_AddToWatchlist() {
        home.clickItemFromList();

        viewCart.clickWatchlist();
        boolean watchlistWorks = utils.verifySignInRedirect().isDisplayed();

        Assert.assertTrue(watchlistWorks);
    }

    @Test
    public void test_VerifySimilarItems() {
        home.clickItemFromList();
        List<WebElement> similarItems = viewCart.similarItemsList();

        Assert.assertTrue(similarItems.size() >= 1);
    }

    @Test
    public void test_VerifySellerItems() {
        home.clickItemFromList();
        List<WebElement> sellerItems = viewCart.sellerItemsList();

        Assert.assertTrue(sellerItems.size() >= 1);
    }

    @Test
    public void test_VerifyFooterLinks() {
        home.clickItemFromList();
        List<WebElement> footerLinks = viewCart.footerLinksList();

        Assert.assertEquals(footerLinks.size(), 9);
    }

    @Test
    public void test_EbayLogo() {
        home.clickItemFromList();
        viewCart.itemName().isDisplayed();
        utils.clickEbayLogo();

        String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
        String actualTitle = utils.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void test_SearchItem() {
        home.clickItemFromList();
        utils.searchItem("iphone");
        utils.clickSearch();
        boolean searchWorks = utils.searchResultsSection().isDisplayed();

        Assert.assertTrue(searchWorks);
    }

    @Test
    public void test_EnterQuantityOverLimit() {
        home.clickItemFromList();
        viewCart.enterItemQuantity("2000");
        boolean quantityErrMsg = viewCart.quantityErrorMsg().isDisplayed();
        String qtyErrMsg = viewCart.quantityErrorMsg().getText();

        Assert.assertTrue(quantityErrMsg);
        Assert.assertEquals(qtyErrMsg, "Purchases are limited to 5 per buyer");
    }

    @Test
    public void test_AddToCartWithoutSelectOption() {
        home.clickItemFromList();
        viewCart.selectDefault();
        viewCart.clickAddToCart();
        boolean selectErrMsg = viewCart.selectErrorMsg().isDisplayed();

        Assert.assertTrue(selectErrMsg);
    }

    @Test
    public void test_BuyNowWithoutSelectOption() {
        home.clickItemFromList();
        viewCart.selectDefault();
        viewCart.clickBuyNow();
        boolean selectErrMsg = viewCart.selectErrorMsg().isDisplayed();

        Assert.assertTrue(selectErrMsg);
    }

    @Test
    public void test_WatchlistWithoutSelectOption() {
        home.clickItemFromList();
        viewCart.selectDefault();
        viewCart.clickWatchlist();
        boolean selectErrMsg = viewCart.selectErrorMsg().isDisplayed();

        Assert.assertTrue(selectErrMsg);
    }

    @Test
    public void test_EnterShippingQuantity() {
        home.clickItemFromList();
        viewCart.enterShippingQuantity("3");
        String shippingQuantity = viewCart.getShippingQuantity();

        Assert.assertEquals(shippingQuantity, "3");
    }

    @Test
    public void test_EnterShippingQuantityOverLimit() {
        home.clickItemFromList();
        viewCart.enterShippingQuantity("2000");
        boolean shpQtyErrMsg = viewCart.shippingQtyErrorMsg().isDisplayed();

        Assert.assertTrue(shpQtyErrMsg);
    }

}
