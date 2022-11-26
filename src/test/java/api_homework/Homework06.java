package api_homework;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Homework06 extends ReqresBaseUrl {

     /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

    @Test
    public void homework06(){

        spec.pathParam("pp1","unknown");
        Response response=given().spec(spec).contentType(ContentType.JSON).when().get("/{pp1}");
       // response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();
        List<String> pant_value=jsonPath.getList("data.pantone_value");
        System.out.println(pant_value);

        List<Integer> ids=jsonPath.getList("data.id");
        System.out.println(ids);

      /*  List<Integer> idsGreaterThan3=new ArrayList<Integer>();

        for (Integer w:ids) {
            if (w>3){
                idsGreaterThan3.add(w);
            }
        }

       */
        List<Integer> idsGreaterThan3=jsonPath.getList("data.findAll{it.id>3}id");

        System.out.println(idsGreaterThan3);

        assertEquals(3,idsGreaterThan3.size());

        List<String> names=jsonPath.getList("data.findAll{it.id<3}.name");

        System.out.println(names);
        assertEquals(2,names.size());







    }
}
