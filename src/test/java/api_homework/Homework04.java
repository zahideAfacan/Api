package api_homework;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Homework04 extends HerOkuAppBaseUrl {



 /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
            Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"

 */
    @Test
    public void homework04(){

        spec.pathParam("pp1","booking").queryParams("firstname","Brandon","lastname","Wilson");

        Response response=given().spec(spec).when().get("/{pp1}");
        response.prettyPrint();

        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));



    }

}
