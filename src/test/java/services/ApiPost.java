package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojos.PojoApiCategory;
import pojos.PojoApiMain;
import pojos.PojoApiTag;
import pojos.PojoPostNegative;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*
{
  "id": 0,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
}

 */

public class ApiPost {

    @Test
    public void postPositive() {

        RequestSpecification spec;
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();

        spec.pathParam("first", "pet");
        PojoApiCategory objCategory = new PojoApiCategory(2, "kedi");

        ArrayList<PojoApiTag> objTagList = new ArrayList<>();
        PojoApiTag objTag = new PojoApiTag();

        objTag.setName("siyam");
        objTag.setId(0);
        objTagList.add(objTag);

        PojoApiMain objPhotoUrls = new PojoApiMain();
        ArrayList<String> photoU = new ArrayList<>();
        photoU.add("photo string");
        objPhotoUrls.setPhotoUrls(photoU);
        PojoApiMain objPost = new PojoApiMain(567434, objCategory, "boncuk",
                objPhotoUrls.getPhotoUrls(), objTagList, "pending");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(objPost).when().post("/{first}");
        response.prettyPrint();


        response.then().assertThat().statusCode(200).body("id", equalTo(objPost.getId()),
                "name", equalTo(objPost.getName()));

        //PojoApiMain actualData = response.as(PojoApiMain.class);
        //Assert.assertEquals(actualData.getCategory().getName(),objCategory.getName(),"category name esit degil");

    }

    @Test
    public void postNegative() {

        RequestSpecification spec;
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();

        spec.pathParam("first", "pet");

        PojoPostNegative objPostNegative = new PojoPostNegative(4733452, "categoryN", "lastNameN", "photo url N",
                "tagsN", "lastStatueN");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(objPostNegative).when().post("/{first}");
        response.prettyPrint();

        response.then().assertThat().statusCode(500); //swagger document Invalid Input Code 405 !

    }

}
