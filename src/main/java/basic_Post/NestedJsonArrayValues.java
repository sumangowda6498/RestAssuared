package basic_Post;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class NestedJsonArrayValues {
    @Test
    void jsonarrayvlues(){
        JSONObject parameters = new JSONObject();
        parameters.put("name", "John");
        parameters.put("Designation", "Test Engineer");
        parameters.put("id", 100);

        //Create instance of JSONObject to store contact numbers
        JSONObject detailsNumber = new JSONObject();
        detailsNumber.put("Official Number", 1234567890);
        detailsNumber.put("Personal Number",1234567891);
        detailsNumber.put("Land line", 223344);

        //Create instance of JSONObject to store Email id's
        JSONObject detailsEmail = new JSONObject();
        detailsEmail.put("Email id1", "abc@gmail.com");
        detailsEmail.put("Email id2", "def@gmail.com");

        //Create instance of JSONArray
        JSONArray contactDetails = new JSONArray();
        //Move the created JSONObjects to JSONArray
        contactDetails.put(detailsNumber);
        contactDetails.put(detailsEmail);

        //Make contactDetails as value to "Contact" Key
        parameters.put("Contact", contactDetails);

        //print the JSON object as String in the console
        System.out.println(parameters.toString());
    }
}

