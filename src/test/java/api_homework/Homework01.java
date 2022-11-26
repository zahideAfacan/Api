package api_homework;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertTrue;

public class Homework01 extends ReqresBaseUrl {

     /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void homework(){

        spec.pathParams("pp1","users","pp2",3);

        Response response=given().spec(spec).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200).
                statusLine("HTTP/1.1 200 OK");


    }

}
