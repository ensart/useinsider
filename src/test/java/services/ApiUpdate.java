package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojos.PojoApiCategory;
import pojos.PojoApiMain;
import pojos.PojoApiTag;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiUpdate {

    @Test
    public void updatePositive() {

        RequestSpecification spec;
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();

        spec.pathParams("first", "pet");
        PojoApiCategory objCategory = new PojoApiCategory(2, "kedi updated");

        ArrayList<PojoApiTag> objTagList = new ArrayList<>();
        PojoApiTag objTag = new PojoApiTag();

        objTag.setName("siyam updated");
        objTag.setId(0);
        objTagList.add(objTag);

        PojoApiMain objPhotoUrls = new PojoApiMain();
        ArrayList<String> photoU = new ArrayList<>();
        photoU.add("photo string");
        objPhotoUrls.setPhotoUrls(photoU);
        PojoApiMain objPost = new PojoApiMain(567434, objCategory, "boncuk updated",
                objPhotoUrls.getPhotoUrls(), objTagList, "pending");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(objPost).
                when().put("/{first}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("id", equalTo(objPost.getId()),
                "name", equalTo(objPost.getName()));

    }

    @Test
    public void updateNegative() {

        RequestSpecification spec;
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();

        spec.pathParams("first", "pet","second",567434);
        PojoApiCategory objCategory = new PojoApiCategory(2, "kedi updated");

        ArrayList<PojoApiTag> objTagList = new ArrayList<>();
        PojoApiTag objTag = new PojoApiTag();

        objTag.setName("siyam updated");
        objTag.setId(0);
        objTagList.add(objTag);

        PojoApiMain objPhotoUrls = new PojoApiMain();
        ArrayList<String> photoU = new ArrayList<>();
        photoU.add("photo string");
        objPhotoUrls.setPhotoUrls(photoU);
        PojoApiMain objPost = new PojoApiMain(567434, objCategory, "boncuk updated",
                objPhotoUrls.getPhotoUrls(), objTagList, "pending");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(objPost).
                when().put("/{first}/{second}");
        response.prettyPrint();

        response.then().assertThat().statusCode(405);

    }

}
