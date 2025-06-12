package basic_Post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class Demo11_post {
    @Test
    void postbasicdemo11(){
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI="https://reqres.in/api/";

        RequestSpecification request = RestAssured.given();
        String token="reqres-free-v1";
        request.header("Content-Type", "application/json");
       // request.header("Authorization", "Bearer " + token);
        JSONObject requestParams = new JSONObject();


        requestParams.put("email","eve.holt@reqres.in");
        requestParams.put("password","pistol");

        request.body(requestParams.toString());

        Response response=request.post("register");

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        String responsebody=response.getBody().toString();
        System.out.println(responsebody);


    }
}
