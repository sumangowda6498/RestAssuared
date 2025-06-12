package basic_Post;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class NestedJsonArray {
    @Test
    void jsonarraymethod(){

        JSONObject parameters=new JSONObject();
        parameters.put("name","Jhon");
        parameters.put("Designation","suman");
        parameters.put("id",100);

        JSONObject details=new JSONObject();
        details.put("Official Number", 1234567890);
        details.put("Personal Number",1234567891);
        details.put("Land line", 223344);
        details.put("Email id", "abc@gmail.com");

        //Create instance of JSONArray
        JSONArray contactDetails = new JSONArray();

        contactDetails.put(details);
        //Make contactDetails as value to "Contact" Key
        parameters.put("contact",contactDetails);

        //print the JSON object as String in the console
        System.out.println(parameters.toString());
    }
}
