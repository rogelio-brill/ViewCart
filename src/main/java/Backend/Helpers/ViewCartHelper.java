package Backend.Helpers;

import Backend.Constants.Endpoints;
import Backend.Utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ViewCartHelper {

    private static final String BASE_URL = ConfigManager.getInstance().getString("url");

    private static final Map<String,Object> baseHeaders = new HashMap<String,Object>();

    public ViewCartHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();
        baseHeaders.put("Accept", "*/*");
        baseHeaders.put("Accept-Encoding", "gzip, deflate, br");
        baseHeaders.put("Accept-Language", "en-US,en;q=0.9");
        baseHeaders.put("Connection", "keep-alive");
        baseHeaders.put("Content-Type", "application/json; charset=utf-8");
        baseHeaders.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36");
    }

    public Response getRequest(String endpoint, String cookie) {
        return RestAssured.given()
                .headers(baseHeaders)
                .headers("Cookie", cookie)
            .when()
                .get(endpoint)
            .then()
                .extract().response();
    }

}
