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

    public Response getRenderedComponents() {
        String cookie = "ak_bmsc=398ACEA86DDA8577C4C8A97E9C034D0E~000000000000000000000000000000~YAAQ15TYF/sJxsp/AQAA87aP4Q9iw88myFoIIAP8BDsqxeNOiyiyXzPY6fZnqrfHAqZVZmGQ/CXfZYTWowahoLjcUg09N2gqoXQg6x1OrNci6pSxNTxNg30WxOUGpYy3x62NpzcpCcovpiTsbablWRBdynYE13iobbSYHn+zbscKkLfMUwPmQhltKnkP8DY1GNwMiD7te5hkR6AKu6n3ttx3LvI09e9zvIHcJr+slsS/KsbZJIPr8q5afdqZX03sSDhEWoaoghJdSY2Q1bMZZR7q6UHDbokIfjRaGZAsJQcTeoLqEeIK2j9SuyISlB/YSR4zs/VTrmCSxFmWHipsBb4o99uGBtjrYaD1teXkSJOrO3vsJz1ldrYrq68=; bm_sv=281B9D174703B3F34BB2342CD5354B2D~67+2QLVlBjVP2G9t26lVeSSao//lbnp5FFXRFY92FgU0vBXHpLyQoGFEcRPMuvc4DhE5IBvRH2pz2/v5gnZTEeX9pp7wsPXMBzw/yW/pluth70jqjhR3UeuXOtTZpdReaDed9po9r3DrQEKnfz9yzw==; dp1=bbl/US660881e5^; nonsession=BAQAAAX42/BiUAAaAADMABWQnTmU5NTEzMQDKACBmCIHlOGY5NDI1NDkxN2YwYWI4ZjFhZWIwZmIwZmZmNTY4ZTgAywABYkYh7TQnF1bOjkp+qVw4Si3ZSGt0ZQutvA**; s=CgAD4ACBiR1meOGY5NDI1NDkxN2YwYWI4ZjFhZWIwZmIwZmZmNTY4ZThAXJ27";

        Response response = RestAssured.given()
                .headers(baseHeaders)
                .headers("Cookie", cookie)
            .when()
                .get(Endpoints.GET_RENDERED_COMPONENTS)
            .then()
                .extract().response();

        return response;
    }

    public Response getAddToCart() {
        String cookie = "ak_bmsc=79262ED71AA30AF27BAA62A6558D1330~000000000000000000000000000000~YAAQL3tBF9VGLdF/AQAA0uw+5w+5+fadx+udupieIYAoCyOaa8pP6IjJ7/YAp3CADvcMMbdudw6DxFeKHRFb3G6g2Bopsb7Dxnz13trW532if7LfAcSAQSavgIEPjcw/5rI4qd8a73reLha70fBh09C78eDFs5v3E9SO9V+zE1uQPcyS/tuO/c/4E5ocV/fBb793I1XHUCqAQvjGZQzvsRTmaZ3vpLhadkYQ/+OAlM9RsI9+Egzr4DWWrXX+ATSWqga2rNU/LueiyF2PMa61gDz5/a+3efpuVtWrPHfbhvZuTmRiKxxeP2OImS3Sn5WupCk/CpXlGFyEvKooe0sGnIjK4nsLYSTz4pob6RIChFB2pP+7p2dKFyl/AIg=; bm_sv=BD8DA247162F83D3BE310EAC560B69A9~LDjxkI5/12JjMMP0z91nl5PhiZVrFTh71e+ys1kO9peGt/O7oU/LjaHE5c1a0gPfylY5UZFxXtMK+96TT/s8FO+OyH1NMnm6CnwGEOcOs3nYEGnbSyT8mDZlrsDWuG+kQjFWQhlHYE4vFSWeCjt/0A==; dp1=bbl/US6609e3ee^; ebay=%5Esbf%3D%23000000%5E; nonsession=BAQAAAX42/BiUAAaAADMABWQosG45NTEzMQDKACBmCePuOGY5NDI1NDkxN2YwYWI4ZjFhZWIwZmIwZmZmNTY4ZTgAywABYkeD9jMTrBKT90REKnTDu4eaXsZqf+62ng**; s=CgAD4ACBiSM4HOGY5NDI1NDkxN2YwYWI4ZjFhZWIwZmIwZmZmNTY4ZThemSQw";

        Response response = RestAssured.given()
                .headers(baseHeaders)
                .headers("Cookie", cookie)
            .when()
                .get(Endpoints.GET_ADD_TO_CART)
            .then()
                .extract().response();

        return response;
    }

    public Response getAds() {
        String cookie = "__uzma=4265b97f-2945-4d02-b99c-8fd2c6f459b2; __uzmb=1645595789; __uzme=3007; __ssds=2; __ssuzjsr2=a9be0cd8e; __uzmbj2=1645595791; __uzmaj2=736fe162-f55c-43ad-bc97-ce81843f0fad; cid=MV3mNSSPIgc0b6Hk#1097606631; __gads=ID=f2caf0101226132b:T=1645687558:S=ALNI_MYWQkqLTakrFktmMDtuV5SyEvv8Kg; AMCVS_A71B5B5B54F607AB0A4C98A2@AdobeOrg=1; QuantumMetricUserID=734adefeb08a5c783a7905f1ace1d421; __gsas=ID=145f857afbe81754:T=1647380200:S=ALNI_MYk7EtEH23ap2boTZcb6Q4vkRAmSw; _gcl_au=1.1.1880009068.1648240353; _fbp=fb.1.1648240352855.318511100; _ga=GA1.2.817239178.1648240353; _ym_uid=164824035430368406; _ym_d=1648240354; cssg=dcd23c0317f0a76563f74822fff7966d; AMCV_A71B5B5B54F607AB0A4C98A2@AdobeOrg=-408604571|MCMID|45163264603655371960394402940086538807|MCAAMLH-1649369704|9|MCAAMB-1649369704|RKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y|MCCIDH|928616765|MCOPTOUT-1648772104s|NONE|vVersion|4.6.0; __gpi=UID=0000040455583e83:T=1648680855:RT=1648765851:S=ALNI_MZJhR38Y7HBE0RfOjVimjxtXBIk3g; cpt=^cpt_guid=7728b2af-737a-43b1-8416-0fafc17b7288^cpt_prvd=hcaptcha^; ak_bmsc=D26CAFA99E1444F0C5C26C16F520BF1E~000000000000000000000000000000~YAAQRntBF620BZ9/AQAA+mhS5w+po7pzWzBZVZWZjDgPXWb5gisWs/kJsB4BNNg1WQxfv4hRnD7IAt28EPsa0qPktz/cI0WdRe/xdJ8ItZlwyZMXoee1fZAU4KrYkw/Cn7p8GCdytnd1OqU3b3mX3DCLm69vkdXB5jV2rPBIkFKdWASuZVQvb+ujOQcxoO1Vn+4wNCwzVRbjaDLx2xwbWO+njbK69Ja4Gfh6soGU31Cy0TFwnAb5ATxctqVoTTkBdax7uO9ABLDeG2RCKpxg/ssyhql60Md8dAhTcZXvQRQrA4dt9oi5C9hb6It79Bmn8BJgcaqSwWfYVa0yDYF1YMgBSJq1vBUVy2M3C7FFa9Vri8sjcsl5+MsyPtQ=; __deba=3uJwRP_zwwiPy-LRf1QEpw0cHEcaIrTk2pOmLtPci9RfsAXGu0ry5ztd-SSBTN70oOrw9pWuFDMZmeJxUToF7dIPPS-LVRtVwWZoDQtbdQJinOanGumrb8O9V3VskFFj; __uzmc=3633912752635; __uzmd=1648853438; __uzmf=7f6000abe163f9-ec4e-4263-8191-3a40b618a0f916455957892843257649320-20d09f48422442c6127; __uzmcj2=4208719375493; __uzmdj2=1648853442; JSESSIONID=FB03EC16A7DD838625DB18873C32BB38; ds2=asotr/b7pwxzzzzzzz^; npii=btguid/d7e6f7cd17e0a0d31671bbc0ffb110416609ea66^cguid/25270bf517f0ab9712f4cbc5ff6763cb6609ea66^; ebay=^cv=15555^js=1^sbf=#10000000000^; dp1=bexpt/000164559580931763066661^bl/USen-US6609ea66^pbf/#c0002000008080820000006428b6e6^mpc/0|06254b266^u1p/cm9nYWd1XzM0MTE*6609ea66^u1f/Rogelio6609ea66^; ns1=BAQAAAX/S+NiMAAaAANgATGQotuZjNzJ8NjAxXjE2NDg2NzcyMzk4NDFeXjFeM3wyfDY1fDV8NHw3XjFeMl40XjNeMTJeMTJeMl4xXjFeMF4xXjBeMV42NDQyNDU5MDc1AKUADWQotuYyMzg5MTcyODU2LzA7B33Qzl5F8YCSj/S1Pj486ZgFfMY*; s=CgAD4ACBiSNTmZDdlNmY3Y2QxN2UwYTBkMzE2NzFiYmMwZmZiMTEwNDEA7gAYYkjU5jAGaHR0cHM6Ly93d3cuZWJheS5jb20vB4Jtgrc*; nonsession=BAQAAAX/S+NiMAAaAAEAAC2QotuZyb2dhZ3VfMzQxMQAzAA5kKLbmOTUzMTUtOTM3OSxVU0EBZAAHZgnqZiMwMjAwOGEACAAcYm8QZjE2NDg4NTM4NTd4MjU0NDk3MTQ0MTQ0eDB4Mk4AygAgZgnqZmQ3ZTZmN2NkMTdlMGEwZDMxNjcxYmJjMGZmYjExMDQxAMsAAmJHim4yOACdAAhkKLbmMDAwMDAwMDF+45vseZ8tdpcwZVOFFDXZXCQ6Kw**; bm_sv=C5B8426A735EF5B78B76722E168B6098~9Bgj9e7WoLBpDZrI0p2jKzDgwMLFAiYHwp+9RHhyA1yPz32xy4RXbZGLvWpf3o55a6XsItsexWW6s7L2hRuo3fSyx17moVzx/fwa388IZKkDu4VEdfFjIkw2L9mOUk7yFGJ968mOs2tQ0ROtWvikqKSWZ+MEp3Azjmr8SL6Ug5Q=";

        Response response = RestAssured.given()
                .headers(baseHeaders)
                .headers("Cookie", cookie)
            .when()
                .get(Endpoints.GET_ADS)
            .then()
                .extract().response();

        return response;
    }


}
