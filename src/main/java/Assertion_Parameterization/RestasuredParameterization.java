package Assertion_Parameterization;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestasuredParameterization {
    @Test
    void assertion(){
        RestAssured.useRelaxedHTTPSValidation();// By Subhadip Das
//https://reqres.in/api/users?page=2
        RestAssured.baseURI="https://reqres.in/api/";

        RequestSpecification httpsRequest=RestAssured.given();

        Response response=httpsRequest.request(Method.GET,"/users?page=2");

        //Validating STATUS CODE from response
        int statusCode= response.statusCode();
        System.out.println("Statuscode:"+statusCode);
        Assert.assertEquals(statusCode/*actualcode*/,200,"incorrectsatuscode");


        //Validating STATUS LINEfrom response
        String statusLine= response.statusLine();
        System.out.println(statusLine);
        Assert.assertEquals(statusLine/*actual ststus Line*/,"HTTP/1.1 200 OK", "Incorrect status line resturned");

        //Validating text from response
        String responseBody=response.getBody().asString();
        System.out.println("\n STATUS BODY: "+responseBody);
        Assert.assertEquals(responseBody.contains("lindsay"),true,"responseBody doesnot contains lindsay");
    }
}
