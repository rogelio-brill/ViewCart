package Backend;

import Backend.Helpers.ViewCartHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

public class ViewCartApi {

    private ViewCartHelper viewCartHelper;

    @BeforeClass
    public void init() {
        viewCartHelper = new ViewCartHelper();
    }

    @Test
    public void test_Rendered_Components() {
        Response resp = viewCartHelper.getRenderedComponents();

        int status = resp.getStatusCode();
        String body = resp.getBody().prettyPrint();

        Assert.assertEquals(status, 200);
        Assert.assertTrue(body.equals("{\n" + "    \n" + "}"));
    }

    @Test
    public void test_addToCart() {
        Response resp = viewCartHelper.getAddToCart();

        int status = resp.getStatusCode();
        String body = resp.getBody().prettyPrint();

        Assert.assertEquals(status, 200);
        Assert.assertTrue(body.contains("true"));
    }

    @Test
    public void test_ads() { // Figure our cache key
        Response resp = viewCartHelper.getAds();

        int status = resp.getStatusCode();

        Assert.assertEquals(status, 204);
    }
}
