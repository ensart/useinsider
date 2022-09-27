package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiDelete {

    @Test
    public void deletePositive() {

        RequestSpecification spec;
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();

        spec.pathParams("first", "pet", "second", "567434");

        //Map<String, Object> expected = new HashMap<>();
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        //Map<String, Object> actualMap = response.as(HashMap.class);
        //Assert.assertTrue(actualMap.size() == 0);
    }

    @Test
    public void deleteNegative() {

        RequestSpecification spec;
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();

        spec.pathParams("first", "pet", "second", "567434");

        //Map<String, Object> expected = new HashMap<>();
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        response.then().assertThat().statusCode(404); //404 Pet not found

        //Map<String, Object> actualMap = response.as(HashMap.class);
        //Assert.assertTrue(actualMap.size() == 0);
    }

}
