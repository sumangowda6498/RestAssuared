package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManger implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String respName;

    public void onStart(ITestContext testContext){
        String timeStamp= new SimpleDateFormat("yyyn.MM.dd.HH.mm.ss").format(new Date());
        respName="Test-Report-"+timeStamp+".html";

        sparkReporter=new ExtentSparkReporter(".\\reports\\"+respName);

        sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
        sparkReporter.config().setReportName("Pet store User API");
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application","Pest store Users API");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name",System.getProperty("user.name"));
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("user","Suman");




    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test=extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getName());
        test.log(Status.PASS,"Test Passed");

    }
public  void onTestFailure(ITestResult result){
    test=extent.createTest(result.getName());
    test.createNode(result.getName());
    test.assignCategory(result.getMethod().getGroups());
    test.log(Status.FAIL,"Test Failed");
    test.log(Status.FAIL,result.getThrowable().getMessage());

}

public void onTestSkipped(ITestResult result){
    test=extent.createTest(result.getName());
    test.createNode(result.getName());
    test.assignCategory(result.getMethod().getGroups());
    test.log(Status.SKIP,"Test Skipped");
    test.log(Status.FAIL,result.getThrowable().getMessage());
}

public void onFinish(ITestContext testContext){
        extent.flush();
}
}
