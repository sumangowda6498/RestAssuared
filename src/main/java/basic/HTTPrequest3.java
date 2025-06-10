package basic;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class HTTPrequest3 {
    @Test
    void getRequestmethodHeaders(){
        RestAssured.useRelaxedHTTPSValidation();// By Subhadip Das

        RestAssured.baseURI="https://reqres.in/api/";

        RequestSpecification httpsRequest=RestAssured.given();

        Response response=httpsRequest.request(Method.GET,"/users?page=2");

        // Get all the headers, return value is of type Headers.
        Headers allHeaders= response.getHeaders();

        // Headers class implements Iterable interface.
        // Iterate over all the Headers using an advance for loop as shown in the code below
        for (Header header:allHeaders){
            System.out.println("Key: "+header.getName()+" | Value: "+header.getValue());
        }

        System.out.println("\nTotal number of  Headers: "+allHeaders.size());
    }
}
