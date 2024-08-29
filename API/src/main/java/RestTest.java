
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.baseURI;


public class RestTest {

@Test
    public void getCall(){
        baseURI="https://api.coindesk.com/v1/bpi/currentprice.json";
        Response response = RestAssured.given()
                .when()
                .get(baseURI);
        if ( response.getStatusCode()==200){
            System.out.println("status code" +response.getStatusCode());

        int code = response.getStatusCode();
        System.out.println("status code: " + code);
        String rate = response.jsonPath().getString("bpi.GBP.rate");
        System.out.println("GBP.RATE: " + rate);
        String description = response.jsonPath().getString("bpi.GBP.description");
        System.out.println("GBP.DESCRIPTION: " + description);
    }
}
}
