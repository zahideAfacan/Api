package api_homework;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Homework02 extends ReqresBaseUrl {

     /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty

     */
    @Test
    public void homework02(){

        spec.pathParams("pp1","users","pp2",23);

        Response response=given().spec(spec).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        assertEquals(404,response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertEquals("cloudflare",response.getHeader("Server"));
        assertEquals(0,response.asString().replaceAll("[^A-Za-z0-9]","").length());





    }



}
