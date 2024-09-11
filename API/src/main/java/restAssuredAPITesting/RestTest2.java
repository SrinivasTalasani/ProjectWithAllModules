package restAssuredAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestTest2 {


    @Test
    public void getUsers(){
        RestAssured.baseURI="https://reqres.in/api";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("/users?page=1");
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        String firstName = response.jsonPath().getString("data.first_name");
        System.out.println("FirstName: " + firstName);
        String email = response.jsonPath().getString("data.email");
        System.out.println("Email: " + email);

    }

    @Test
    public void getUsers6(){

        Response response = given().when().get("https://reqres.in/api/users?page=1");
    int actualStatus = response.getStatusCode();
        System.out.println(actualStatus);
        Assert.assertEquals(actualStatus,200);
        ResponseBody responseBody = response.getBody();
        System.out.println("abcd " + responseBody);


    }

    @Test
    public void weatherMessageBody() {
       RestAssured.baseURI = "https://reqres.in/api";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("/users?page=1");
//       Response response = httpRequest.get("/Hyderabad");

int statusCode =  response.getStatusCode();
        System.out.println(statusCode);
        // Retrieve the body of the Response
        ResponseBody body = response.getBody();

        // By using the ResponseBody.asString() method, we can convert the  body
        // into the string representation.
        System.out.println("Response Body is: " + body.asString());
    }

@Test

        public void post_request()
        {


            String jsonString = "{\"name\" : \"kanak\",\"password\" : \"kanak123\"}";

    /*
    	Construct a request specification
    */
            RequestSpecification request= RestAssured.given();

    /*
    	Setting content type to specify the format in which the request payload will be sent.
    */
            request.contentType(ContentType.JSON);

    /*
    	Adding URI
    */
            request.baseUri("https://reqres.in/api/users");

    /*
    	Adding body as string
    */
            request.body(jsonString);

    /*
    	Calling POST method on URI. After hitting, we get Response
    */
            Response response = request.post();

    /*
    	Printing Response as string
    */
            System.out.println(response.asString());

    /*
    	Get Validatable response to perform validation
    */
            ValidatableResponse validatableResponse = response.then();

    /*
    	Validate status code as 201
    */
            validatableResponse.statusCode(201);

            System.out.println(response.getStatusCode());
            System.out.println(response.getTime());
        }
    }


