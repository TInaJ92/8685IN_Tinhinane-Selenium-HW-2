package reporting;

import com.relevantcodes.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.Reporter;

import java.io.File;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;
    private static ITestContext context;

    public synchronized static ExtentReports getInstance(){
        if(extent == null){
            File outputDirectory = new File(context.getOutputDirectory());
            File resultDirectory = new File(outputDirectory.getParentFile(),"html");

//            Date date = new Date();
//            String fileName = "report_" + date.toString().replace(" ", "_").replace(":", "_")+".html";
            String fileName = "test_report.html";
            extent = new ExtentReports(System.getProperty("user.dir") + File.separator + "src" + File.separator
                    + "test" + File.separator + "reports" + File.separator + fileName,true);
            Reporter.log("Extent Report Directory" + resultDirectory, true);
            extent.addSystemInfo("Host Name", "Maximus").addSystemInfo("Environment","QA")
                    .addSystemInfo("User Name", "Sami Sheikh");

            extent.loadConfig(new File(System.getProperty("user.dir")+ "/src/main/resources/reporting/report-config.xml"));
        }
        return extent;
    }

    public static void setOutputDirectory(ITestContext context){
        ExtentManager.context = context;
    }
}
