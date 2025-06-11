package basic;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class httpsJsonpath5Exercise {
    @Test
    void exercise(){
        RestAssured.useRelaxedHTTPSValidation();
        Response response= RestAssured.get("https://reqres.in/api/");
        JsonPath jsonPathEvaluate=response.jsonPath();
        List<String> availability=jsonPathEvaluate.get("page");
        System.out.println("Page"+availability);

    }
}
