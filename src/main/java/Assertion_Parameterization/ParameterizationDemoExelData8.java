package Assertion_Parameterization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ParameterizationDemoExelData8 {
    @Test
    void Demo8() throws IOException {

        Response response; //creating reference for Response interface

        // Path from where the excel file has to be read
        String path="testdata/getdemo8.xlsx";

        // File input stream which needs the input as the file location
        FileInputStream fis=new FileInputStream(path);

        // Workbook reference of the excel file
        XSSFWorkbook wb=new XSSFWorkbook(fis);

        // Sheet which needs to be accessed from within the workbook
        XSSFSheet sheet= wb.getSheetAt(0);

        // Count the number of rows
        int rowCount=sheet.getLastRowNum()- sheet.getFirstRowNum();
        System.out.println(rowCount);

        // Iterate the AccountNumber
        for (int i = 0; i <= rowCount; i++) {
// Pass the row number and the cell number from where the value has to be fetched
           double id = sheet.getRow(i).getCell(0).getNumericCellValue();
            int intValue = (int) Math.round(id);
            String ids=String.valueOf(intValue);
            System.out.println("id: "+id);
RestAssured.useRelaxedHTTPSValidation();
            // Make a request to the server by specifying the method Type and the method URL
            // This will return the Response from the server. Store the response in a reference variable created above.
            https://reqres.in/api/users?page=
            response = RestAssured.get("https://reqres.in/api/users/"+ids);
            String responseBody = response.getBody().asString();
            System.out.println("Response Body is =>  " + responseBody);
        }
        }

    }

//Workbook workbook = WorkbookFactory.create(fis);
//            Sheet sheet = workbook.getSheetAt(0); // Access the first sheet
//            Row row = sheet.getRow(0); // Access the first row
//            Cell cell = row.getCell(0); // Access the first cell
//
//            // Convert numeric cell value to string
//            if (cell.getCellType() == CellType.NUMERIC) {
//                String cellValueAsString = String.valueOf(cell.getNumericCellValue());
//                System.out.println("Numeric value as string: " + cellValueAsString);
//            } else {
//                System.out.println("Cell is not numeric.");
//            }
//
//            workbook.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//Key Points:
//Apache POI Library: Ensure you have Apache POI dependencies in your project. Add the following to your pom.xml if you're using Maven:
//
//
//Copy the code
//<dependency>
//    <groupId>org.apache.poi</groupId>
//    <artifactId>poi-ooxml</artifactId>
//    <version>5.2.3</version> <!-- Use the latest version -->
//</dependency>
//Cell Type Check: Always check the cell type using cell.getCellType() to ensure you're working with a numeric cell.
//
//Conversion: Use String.valueOf(cell.getNumericCellValue()) to convert the numeric value to a string.
//
//This approach ensures you handle numeric cells safely and effectively.