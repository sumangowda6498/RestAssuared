package basic_Post;

import io.restassured.RestAssured;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PetstoreOrderPostChatGPT {
    public static void main(String[] args) {
        RestAssured.useRelaxedHTTPSValidation();

        String apiUrl = "http://petstore.swagger.io/v2/store/order";

        String jsonInputString = "{"
                + "\"id\": 12345,"
                + "\"petId\": 999,"
                + "\"quantity\": 2,"
                + "\"shipDate\": \"2025-06-12T12:00:00.000Z\","
                + "\"status\": \"placed\","
                + "\"complete\": true"
                + "}";

        try {
            // Create URL and connection
            RestAssured.useRelaxedHTTPSValidation();
            URL url = new URL(apiUrl);
            RestAssured.useRelaxedHTTPSValidation();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method and headers
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Send JSON input
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Get response code
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line.trim());
                }
                System.out.println("Response Body: " + response.toString());
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
