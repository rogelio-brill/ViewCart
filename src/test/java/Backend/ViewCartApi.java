package Backend;

import Backend.Constants.Cookies;
import Backend.Constants.Endpoints;
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
        Response resp = viewCartHelper.getRequest(Endpoints.GET_RENDERED_COMPONENTS, Cookies.GET_RENDERED_COMPONENTS);

        int status = resp.getStatusCode();
        String body = resp.getBody().prettyPrint();

        Assert.assertEquals(status, 200);
        Assert.assertTrue(body.equals("{\n" + "    \n" + "}"));
    }

    @Test
    public void test_addToCart() {
        Response resp = viewCartHelper.getRequest(Endpoints.GET_ADD_TO_CART, Cookies.GET_ADD_TO_CART);

        int status = resp.getStatusCode();
        String body = resp.getBody().prettyPrint();

        Assert.assertEquals(status, 200);
        Assert.assertTrue(body.contains("true"));
    }

    @Test
    public void test_ads() { // Figure our cache key
        Response resp = viewCartHelper.getRequest(Endpoints.GET_ADS, Cookies.GET_ADS);

        int status = resp.getStatusCode();

        Assert.assertEquals(status, 204);
    }
}
