package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.util.List;


// WORK IN PROGRESS

public class ExtendReporter implements IReporter {

    private  ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> suites, String outputDirectory){
        extent = new ExtentReports();


    ExtentSparkReporter spark = new ExtentSparkReporter("target/test-output/Spark.html");
    extent.attachReporter(spark);
    extent.setSystemInfo("Host Name","Od laika do informatyka");
    extent.setSystemInfo("User Name","Matt");

    extent.createTest("Test001")
        .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");

    extent.flush();

        try {
            spark.loadXMLConfig(System.getProperty("user.dir") + "\\extent-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
