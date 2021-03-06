package Frontend;

import Frontend.Helper.*;
import Frontend.PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ViewCartUi extends BaseDriver {

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = {"unit"})
    public void test_ViewItemPage(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();

        boolean itemNameDisplayed = viewCart.itemName().isDisplayed();

        Assert.assertTrue(itemNameDisplayed);
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = { "unit", "smoke" })
    public void test_VerifyItemDetails(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

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

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = { "unit", "smoke"})
    public void test_VerifyItemPictures(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();
        boolean mainPic = viewCart.mainPicture().isDisplayed();
        Assert.assertTrue(mainPic);

        if(viewCart.otherPicturesArePresent() || viewCart.otherPicturesArePresent2()) {
            List<WebElement> otherPics = viewCart.otherPictures();
            Assert.assertTrue(otherPics.size() >= 1);
        }
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = { "unit", "smoke" })
    public void test_VerifySellerInfo(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();
        boolean sellerInfo = viewCart.sellerInfo().isDisplayed();

        Assert.assertTrue(sellerInfo);
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = { "unit", "smoke" })
    public void test_ShopWithConfidenceSection(@Optional String site) throws IOException{
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();
        boolean confidenceSection = viewCart.confidenceSection().isDisplayed();

        Assert.assertTrue(confidenceSection);
    }

    @Test(dataProvider = "quantity-data", dataProviderClass = TestData.class, groups = { "unit", "smoke" })
    public void test_EditQuantity(@Optional String site, String quantity) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        if(viewCart.isSelect2Present()) {
            viewCart.selectOption2(1);
        }
        if(viewCart.isSelectPresent()) {
            viewCart.selectOption(1);
        }

        viewCart.enterItemQuantity(quantity);
        String itemQuantity = viewCart.getQuantity();

        Assert.assertEquals(itemQuantity, quantity);
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = { "unit", "smoke" })
    public void test_VerifyNumbersSoldAndWatchers(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();
        List<WebElement> numberSoldAndWatchers = viewCart.soldSection();

        Assert.assertTrue(numberSoldAndWatchers.size() >= 2);
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = { "integration", "smoke" })
    public void test_BuyItNow(@Optional String site) throws IOException { // Close protection plan frame
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);
        Checkout checkout = new Checkout(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        if(viewCart.isSelect2Present()) {
            viewCart.selectOption2(1);
        }
        if(viewCart.isSelectPresent()) {
            viewCart.selectOption(1);
        }

        viewCart.clickBuyNow();
        if(viewCart.isProtectionPresent()) {
            viewCart.declineProtectionPlan();
        }

        if(viewCart.guestOptionIsPresent()) {
            viewCart.clickGuest();

            if(utils.getTitle().equals("Security Measure")) {
                Assert.assertEquals(utils.getTitle(), "Security Measure");
            } else {
                boolean buyNowWorks = checkout.checkoutSingleItem().isDisplayed();
                Assert.assertTrue(buyNowWorks);
            }
        }else {
            boolean watchlistWorks = utils.verifySignInRedirect().isDisplayed();
            Assert.assertTrue(watchlistWorks);
        }
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = { "integration", "smoke" })
    public void test_AddToCart(@Optional String site) throws IOException { // Cannot find element sometimes because of different id's
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        AddToCart addToCart = new AddToCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        if(viewCart.isSelect2Present()) {
            viewCart.selectOption2(1);
        }
        if(viewCart.isSelectPresent()) {
            viewCart.selectOption(1);
        }

        viewCart.clickAddToCart();
        if(viewCart.isProtectionPresent()) {
            viewCart.declineProtectionPlan();
        }else if(viewCart.addToCartOptionsIsPresent()){
            viewCart.clickViewCart();
        }
        List<WebElement> cartItems = addToCart.cartItemList();

        Assert.assertTrue(cartItems.size() >= 1);
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = { "integration", "smoke" })
    public void test_AddToWatchlist(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        if(viewCart.isSelect2Present()) {
            viewCart.selectOption2(1);
        }
        if(viewCart.isSelectPresent()) {
            viewCart.selectOption(1);
        }

        viewCart.clickWatchlist();
        if(utils.getTitle().equals("Security Measure")) {
            Assert.assertEquals(utils.getTitle(), "Security Measure");
        } else {
            boolean watchlistWorks = utils.verifySignInRedirect().isDisplayed();
            Assert.assertTrue(watchlistWorks);
        }
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = { "unit", "smoke" })
    public void test_VerifySimilarItems(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();
        List<WebElement> similarItems = viewCart.similarItemsList();

        Assert.assertTrue(similarItems.size() >= 1);
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = { "unit", "smoke" })
    public void test_VerifySellerItems(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();
        List<WebElement> sellerItems = viewCart.sellerItemsList();

        Assert.assertTrue(sellerItems.size() >= 1);
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = { "unit", "smoke" })
    public void test_VerifyFooterLinks(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();
        List<WebElement> footerLinks = viewCart.footerLinksList();

        Assert.assertTrue(footerLinks.size() >= 9);
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = { "component", "smoke" })
    public void test_EbayLogo(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();
        viewCart.itemName().isDisplayed();
        utils.clickEbayLogo();

        boolean verifiedHome = home.slideListIsPresent();

        Assert.assertTrue(verifiedHome);
    }

    @Test(dataProvider = "search-item-data", dataProviderClass = TestData.class, groups = { "component", "smoke" })
    public void test_SearchItem(@Optional String site, String item) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();
        utils.searchItem(item);
        utils.clickSearch();
        boolean searchWorks = utils.searchResultsSection().isDisplayed();

        Assert.assertTrue(searchWorks);
    }

    @Test(dataProvider = "over-quantity-data", dataProviderClass = TestData.class, groups = {"negative"})
    public void test_EnterQuantityOverLimit(@Optional String site, String quantity) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        if(viewCart.isSelect2Present()) {
            viewCart.selectOption2(1);
        }
        if(viewCart.isSelectPresent()) {
            viewCart.selectOption(1);
        }

        viewCart.enterItemQuantity(quantity);
        boolean quantityErrMsg = viewCart.quantityErrorMsg().isDisplayed();

        Assert.assertTrue(quantityErrMsg);
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = {"negative"})
    public void test_AddToCartWithoutSelectOption(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        if(viewCart.isSelectPresent()) {
            viewCart.selectDefault();

            viewCart.clickAddToCart();
            boolean selectErrMsg = viewCart.selectErrorMsg().isDisplayed();

            Assert.assertTrue(selectErrMsg);
        }
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = {"negative"})
    public void test_BuyNowWithoutSelectOption(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        if(viewCart.isSelectPresent()) {
            viewCart.selectDefault();

            viewCart.clickBuyNow();
            boolean selectErrMsg = viewCart.selectErrorMsg().isDisplayed();

            Assert.assertTrue(selectErrMsg);
        }
    }

    @Test(dataProvider = "localization-data", dataProviderClass = TestData.class, groups = {"negative"})
    public void test_WatchlistWithoutSelectOption(@Optional String site) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        if(viewCart.isSelectPresent()) {
            viewCart.selectDefault();

            viewCart.clickWatchlist();
            boolean selectErrMsg = viewCart.selectErrorMsg().isDisplayed();

            Assert.assertTrue(selectErrMsg);
        }
    }

    @Test(dataProvider = "quantity-data", dataProviderClass = TestData.class, groups = { "unit", "smoke" })
    public void test_EnterShippingQuantity(@Optional String site, String quantity) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        viewCart.enterShippingQuantity(quantity);
        String shippingQuantity = viewCart.getShippingQuantity();

        Assert.assertEquals(shippingQuantity, quantity);
    }

    @Test(dataProvider = "over-quantity-data", dataProviderClass = TestData.class, groups = {"negative"})
    public void test_EnterShippingQuantityOverLimit(@Optional String site, String quantity) throws IOException {
        WebDriver driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();

        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);
        Utils utils = new Utils(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        home.clickItemFromList();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utils.acceptCookies();

        viewCart.enterShippingQuantity(quantity);
        boolean shpQtyErrMsg = viewCart.shippingQtyErrorMsg().isDisplayed();

        Assert.assertTrue(shpQtyErrMsg);
    }

}
