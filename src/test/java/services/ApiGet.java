package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiGet {

    @Test
    public void getPositive() {

        RequestSpecification spec;
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();

        //String url = "https://petstore.swagger.io/v2/pet/findByStatus?status=available&status=pending&status=sold";


        spec.pathParams("first", "pet", "second", "findByStatus").
                queryParam("status", "available");
               // queryParam("status", "pending").
               // queryParam("status", "sold");
        //Swagger document teki endpoint teki queryParams 'daki statuleri tek tek girmek gerekiyor
        //queryParams 'ı tam olarak girdigimizde butun statusleri vermemektedir.


        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        //Response response = given().when().get(url);
        //response.prettyPrint();
    }

    @Test
    public void getNegative() {

        RequestSpecification spec;
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2v3v4").build();

        //String url = "https://petstore.swagger.io/v2/pet/findByStatus?status=available&status=pending&status=sold";


        spec.pathParams("first", "pet", "second", "findNegative").
                queryParam("status", "available");
        // queryParam("status", "pending").
        // queryParam("status", "sold");
        //Swagger document teki endpoint teki queryParams 'daki statuleri tek tek girmek gerekiyor
        //queryParams 'ı tam olarak girdigimizde butun statusleri vermemektedir.


        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        response.then().assertThat().statusCode(404). //400 Swagger Document !
                statusLine("HTTP/1.1 404 Not Found");

        //Response response = given().when().get(url);
        //response.prettyPrint();
    }

}


