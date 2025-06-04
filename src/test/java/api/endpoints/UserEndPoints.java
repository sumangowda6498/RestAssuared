package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//created to perform CRUD operation
public class UserEndPoints {

   public static Response createUser(User payoad){
               Response response= given()
                         .contentType(ContentType.JSON)
                         .accept(ContentType.JSON)
                         .body(payoad)
                       .when()
                         .post(Routes.post_url);

               return response;
    }

    public static Response readUser(String userName){
        Response response= given()
                    .pathParam("username",userName)
                .when()
                    .post(Routes.get_url);

        return response;
    }


    public static Response updateUser(String userName,User payoad){  //userName is the path parameter and Payload is the body
        Response response= given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .pathParam("username",userName)
                    .body(payoad)
                .when()
                    .post(Routes.post_url);

        return response;
    }

    public static Response deleteUser(String userName){
        Response response= given()
                    .pathParam("username",userName)
                .when()
                    .post(Routes.get_url);

        return response;
    }
}
