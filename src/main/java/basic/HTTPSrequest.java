package basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

public class HTTPSrequest {
    @Test

    void getUser(){
        RestAssured.useRelaxedHTTPSValidation();// By Subhadip Das
//        given()
////https://petstore.swagger.io/v2/
//                //https://reqres.in/api/users?page=2
//                .when()
//                    .get("https://petstore.swagger.io/v2/")
//
//                .then()
//                    .statusCode(200)
//                    .body("page",equalTo(2))
//                    .log().all();
        Response response;
       // response = RestAssured.get("http://localhost:8080/InfyClinicV2/APP_V2/getDoctor/byId?doctorId=1001");

         response = RestAssured.get("https://reqres.in/api/users?page=2");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

    }
}
