package basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;

public class HTTPrequest_Header_4 {
    @Test
    void get_responseHeader(){
        RestAssured.useRelaxedHTTPSValidation();//to pass SSL certificate error

        Response response= RestAssured.get("");

        // Reader header is passed with exact header name as argument.
        // In the below line,we will get header named "Content-Type
        String contentTypeValue=response.header("Content-Type");
        System.out.println("content-type Value is: "+contentTypeValue);

        //Key Server its value
        String serverValue=response.header("Server");
        System.out.println("Server: "+serverValue);

        // In the below line,we will get header named "Date"
        String date = response.header("Date");
        System.out.println("Date value: " + date);
    }

}
