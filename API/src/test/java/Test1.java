import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.net.URI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class Test1 {



    @Test

    public void getcall(){
        baseURI="https://api.coindesk.com/v1/bpi/currentprice.json";


     Response resr = RestAssured.given()
             .when()
             .get(baseURI);
        int statusCode = resr.getStatusCode();
        System.out.println(statusCode);

//        if (!(resr.statusCode() ==202)){
//            System.out.println(resr.statusCode());
//        }
    }
}
