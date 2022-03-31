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
        String jsonString = resp.getBody().prettyPrint();

        System.out.println(jsonString);

        Assert.assertEquals(status, 200);
        //Assert.assertTrue(jsonString.contains("renderedComponents"));
    }

}
