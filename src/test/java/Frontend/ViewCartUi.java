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

    @BeforeMethod
    @Parameters({"site"})
    public void init(@Optional String site) throws IOException {
        driver = BaseDriver.getDriver(site);
        driver.manage().window().maximize();
    }

    @Test
    public void test_ViewCartPage() {
        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);

        home.clickItemFromList();
        boolean itemNameDisplayed = viewCart.itemName().isDisplayed();

        Assert.assertTrue(itemNameDisplayed);
    }

    @Test
    public void test_VerifyItemDetails() {
        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);

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
        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);

        home.clickItemFromList();
        boolean mainPic = viewCart.mainPicture().isDisplayed();
        List<WebElement> otherPics = viewCart.otherPictures();

        Assert.assertTrue(mainPic);
        Assert.assertTrue(otherPics.size() >= 1);
    }

    @Test
    public void test_VerifySellerInfo() {
        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);

        home.clickItemFromList();
        boolean sellerInfo = viewCart.sellerInfo().isDisplayed();

        Assert.assertTrue(sellerInfo);
    }

    @Test
    public void test_ShopWithConfidenceSection() {
        Home home = new Home(driver);
        ViewCart viewCart = new ViewCart(driver);

        home.clickItemFromList();
        boolean confidenceSection = viewCart.confidenceSection().isDisplayed();

        Assert.assertTrue(confidenceSection);
    }

}
