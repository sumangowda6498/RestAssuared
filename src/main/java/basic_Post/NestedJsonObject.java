package basic_Post;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class NestedJsonObject {
@Test
    void nestedjsonob(){
        JSONObject parameters=new JSONObject();
        parameters.put("name","suman");
        parameters.put("Designation","suman");
        parameters.put("id",100);

        //Create new JSON Object to store contact details
    JSONObject details = new JSONObject();
    details.put("Official Number", 1234567890);
    details.put("Personal Number",1234567891);
    details.put("Land line", 223344);
    details.put("Email id", "abc@gmail.com");

    //make details as value to "Contact" Key
    parameters.put("Contact", details);

    //print the JSON object as String in the console
    System.out.println(parameters.toString());
    }
}
