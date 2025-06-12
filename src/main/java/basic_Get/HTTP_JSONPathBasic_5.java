package basic_Get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HTTP_JSONPathBasic_5 {
    @Test
    void Json_path_Node_Data_Valuevalidation(){
        RestAssured.useRelaxedHTTPSValidation();//to pass SSLCert error
        Response response= RestAssured.get("https://reqres.in/api/users/2");

        // First get the JsonPath object instance from the Response interface
        // response.jsonPath();
        JsonPath jsonPathEvaluator=response.jsonPath();

        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath: doctorName(Note: You should not put $. in the Java code)
        String name = jsonPathEvaluator.get("page");
        System.out.println("Name of the doctor is: " + name);

        //directly fetch the value as string by using getString() & print it in the console
        System.out.println("Name of the doctor is: " + jsonPathEvaluator.getString("page"));

        Assert.assertEquals(name /* actual value */, "John"/* Expected Value */,"Incorrect account holder name");
    }
}
