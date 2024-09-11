package restAssuredAPITesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;


public class RestTest {

@Test
    public void getCall() {
    baseURI = "https://api.coindesk.com/v1/bpi/currentprice.json";
    Response response = RestAssured.given()
            .when()
            .get(baseURI);
    int code = response.getStatusCode();
    System.out.println("status code: " + code);
    if (response.getStatusCode() == 200) {
        String rate = response.jsonPath().getString("bpi.GBP.rate");
        System.out.println("GBP.RATE: " + rate);
        String description = response.jsonPath().getString("bpi.GBP.description");
        System.out.println("GBP.DESCRIPTION: " + description);
    }

}
@Test
    public void getCall2(){
            RestAssured.baseURI= "https://api.coindesk.com/v1";

    RequestSpecification httpRequest = RestAssured.given();
    Response response = httpRequest.get("/bpi/currentprice.json");
          int statusCode = response.statusCode();
    if ( response.getStatusCode()==200){
        System.out.println("status code" +response.getStatusCode());
        String rate = response.jsonPath().getString("bpi.GBP.rate");
        System.out.println("GBP.RATE: " + rate);
        String description = response.jsonPath().getString("bpi.GBP.description");
        System.out.println("GBP.DESCRIPTION: " + description);
    }
}

@Test
    public void getCall3(){
    baseURI ="https://api.coindesk.com/v1";
    RequestSpecification httpReqest = RestAssured.given();
    Response response = httpReqest.get("/bpi/currentprice.json");
    int statusCode = response.getStatusCode();
    System.out.println("Status code = " + statusCode);
    if(response.getStatusCode()==200){
        String abcd = response.jsonPath().getString("bpi.USD.rate");
        System.out.println("USD rate =" + abcd);
        String abc = response.jsonPath().getString("bpi.GBP.rate");
        System.out.println("GBP rate =" +abc);
    }



}

@Test
    public void getCell4(){
    baseURI= "https://api.coindesk.com/v1/bpi/currentprice.json";
    RequestSpecification httpsRequest = RestAssured.given();
    Response response = httpsRequest.get(baseURI);
    int statusCode = response.getStatusCode();
    System.out.println("Status code : " + statusCode);
    String dollarPrice = response.jsonPath().getString("bpi.USD.rate");
    String poundPrice = response.jsonPath().getString("bpi.GBP.rate");
    System.out.println("DollarRate:" + dollarPrice);
    System.out.println("PoundRate:" + poundPrice);
}
}
