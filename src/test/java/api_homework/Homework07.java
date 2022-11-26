package api_homework;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Reqres_Pojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Homework07 extends ReqresBaseUrl {

  /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void homework07(){

        spec.pathParam("pp1","users");

        Reqres_Pojo expectedData=new Reqres_Pojo("morpheus","leader");
        System.out.println(expectedData);

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{pp1}");
        response.prettyPrint();

        Reqres_Pojo actualData=response.as(Reqres_Pojo.class);
        System.out.println(actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getJob(),actualData.getJob());


    }

}
