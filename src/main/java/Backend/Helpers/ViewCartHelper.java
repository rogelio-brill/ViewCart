package Backend.Helpers;

import Backend.Constants.Endpoints;
import Backend.Utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ViewCartHelper {

    private static final String BASE_URL = ConfigManager.getInstance().getString("url");

    public ViewCartHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.useRelaxedHTTPSValidation();
    }

    public Response getRenderedComponents() {
        String cookie = "ak_bmsc=398ACEA86DDA8577C4C8A97E9C034D0E~000000000000000000000000000000~YAAQ15TYF/sJxsp/AQAA87aP4Q9iw88myFoIIAP8BDsqxeNOiyiyXzPY6fZnqrfHAqZVZmGQ/CXfZYTWowahoLjcUg09N2gqoXQg6x1OrNci6pSxNTxNg30WxOUGpYy3x62NpzcpCcovpiTsbablWRBdynYE13iobbSYHn+zbscKkLfMUwPmQhltKnkP8DY1GNwMiD7te5hkR6AKu6n3ttx3LvI09e9zvIHcJr+slsS/KsbZJIPr8q5afdqZX03sSDhEWoaoghJdSY2Q1bMZZR7q6UHDbokIfjRaGZAsJQcTeoLqEeIK2j9SuyISlB/YSR4zs/VTrmCSxFmWHipsBb4o99uGBtjrYaD1teXkSJOrO3vsJz1ldrYrq68=; bm_sv=281B9D174703B3F34BB2342CD5354B2D~67+2QLVlBjVP2G9t26lVeSSao//lbnp5FFXRFY92FgU0vBXHpLyQoGFEcRPMuvc4DhE5IBvRH2pz2/v5gnZTEeX9pp7wsPXMBzw/yW/pluth70jqjhR3UeuXOtTZpdReaDed9po9r3DrQEKnfz9yzw==; dp1=bbl/US660881e5^; nonsession=BAQAAAX42/BiUAAaAADMABWQnTmU5NTEzMQDKACBmCIHlOGY5NDI1NDkxN2YwYWI4ZjFhZWIwZmIwZmZmNTY4ZTgAywABYkYh7TQnF1bOjkp+qVw4Si3ZSGt0ZQutvA**; s=CgAD4ACBiR1meOGY5NDI1NDkxN2YwYWI4ZjFhZWIwZmIwZmZmNTY4ZThAXJ27";

        Response response = RestAssured.given()
                .headers("Accept", "*/*")
                .headers("Accept-Encoding", "gzip, deflate, br")
                .headers("Accept-Language", "en-US,en;q=0.9")
                .headers("Connection", "keep-alive")
                .headers("Cookie", cookie)
                .header("Content-Type", "application/json; charset=utf-8")
                .headers("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36")
            .when()
                .get(Endpoints.GET_RENDERED_COMPONENTS)
            .then()
                .extract().response();

        return response;
    }

}
