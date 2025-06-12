package basic_Get;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class HTTPrequest2 {

    @Test
    void getRequestMethod(){
        RestAssured.useRelaxedHTTPSValidation();// By Subhadip Das
        // Specify the base URL to the RESTful web service
        //https://reqres.in/api/users?page=2
        RestAssured.baseURI = "https://reqres.in/api/";

        // Get the RequestSpecification of the request that you want to sent to the server.
        //The server is specified by the BaseURI that we have specified in the above step.
        RequestSpecification httpRequest =RestAssured.given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response=httpRequest.request(Method.GET, "users?page=2");

        //print the message body of the response received from the server
        String responsebody= response.getBody().asString();
        System.out.println("Status code: "+response.getStatusCode());
        System.out.println("Response Body is =>"+responsebody);

        //to get last received session id from the server and print the value returned
        String responseid=response.getSessionId();
        String resposeid2=response.sessionId();
        System.out.println("getsessionId: "+responseid +" session Id "+resposeid2);

        //to get the value of the content-type header field and print the value returned
        String COntenttype=response.getContentType();
        System.out.println("Get Content type: "+ COntenttype);

        //To retrieve status line of the response from the server and print the returned value.
        String getStatusLine=response.getStatusLine();
        System.out.println("getStatusLine: "+getStatusLine);

    }
}

