package HRM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ExtentReportsDemo {
	static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static void reportSetup() {
		
		
		// ---------------- Extent Report Setup ----------------
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/extent-report.html");
        spark.config().setDocumentTitle("Betopia HRM Automation Report");
        spark.config().setReportName("Login Test Report");
        spark.config().setTheme(Theme.STANDARD);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Application", "Betopia HRM");
        extent.setSystemInfo("Tester", "Ekramul Haque");
        extent.setSystemInfo("Environment", "Staging");
		
		
		
		
		
		
//		  htmlReporter = new ExtentHtmlReporter("HRM.html"); 
//			
//			 // create ExtentReports and attach reporter(s)
//	        extent = new ExtentReports();
//	        extent.attachReporter(htmlReporter);
//	        //htmlReporter.config().setTheme(Theme.DARK);
//	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
//	        
//	        
//	        
//	       // htmlReporter.config().setChartVisibilityOnOpen(true);
//	       // htmlReporter.config().setDocumentTitle("Simple Automation Report");
//	        //htmlReporter.config().setReportName("Test Report");
//	        //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
//	        htmlReporter.config().setTheme(Theme.STANDARD);
	        
	        
			  
		}

}
