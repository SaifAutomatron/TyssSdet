package com.crm.vtiger.genericutility;


import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 * @author Saif
 *
 */
public class MyListenerIMP implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) 
	{
		test = report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS,result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP,result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {

		ExtentSparkReporter htmlReporter= new ExtentSparkReporter("./Extentreport.html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Vtiger App");
		
	    report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Platform", "Windows");
		report.setSystemInfo("OS", "Windows 10 Home");
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("Reporter", "Saif");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL,result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL,result.getThrowable());
		
		String	date=new JavaUtility().getCurrentDate().replace(" ", "_").replace(":", "_");
		WebDriverUtility wlib=new WebDriverUtility();
    	try {
			String path = wlib.takeScreenShot(result.getMethod().getMethodName()+date);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
    		
	}
	
	
	
	

}
