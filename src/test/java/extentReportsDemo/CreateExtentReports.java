package extentReportsDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateExtentReports {

	public static void main(String[] args) {
		
		
		ExtentReports extentReports =new ExtentReports();
		ExtentSparkReporter extentSparkReporter =new ExtentSparkReporter("ExentReport.html");
		
		extentReports.attachReporter(extentSparkReporter);
		extentReports.flush();
		

	}

}
