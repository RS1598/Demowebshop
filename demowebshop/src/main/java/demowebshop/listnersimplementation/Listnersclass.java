package demowebshop.listnersimplementation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import demowebshop.Baseclass;
import demowebshop.fileutility.Javautility;

public class Listnersclass implements ITestListener,ISuiteListener{
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	

	@Override
	public void onStart(ISuite suite) {
		Javautility javautility=new Javautility();
		spark=new ExtentSparkReporter("./AdvancedReports/"+suite.getName()+javautility.GetSystemDate()+"html");
		report=new ExtentReports();
		report.attachReporter(spark);
		Reporter.log(suite.getName()+"has started execution",true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
		Reporter.log(result.getName()+"testscript Execution started",true);
		test.log(Status.INFO,result.getName()+"testscripthas started execution");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+"testscript successfully executed",true);	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+"testscript skipped",true);	

	}
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log(suite.getName()+"hasexecution completed",true);	

	}


	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+"testscript failed and captured the screenshot",true);
		Javautility java=new Javautility();

		//type casting
		String screenshotpath=("./Failedscreenshots/"+result.getName()+java.GetSystemDate()+".png");
		TakesScreenshot tS=(TakesScreenshot)Baseclass.sdriver;
		
		//path
//		File path=new File("./Failedscreenshots/"+result.getName()+java.GetSystemDate()+".png");
		File path =new File(screenshotpath);
		//take screenshot
		File img =tS.getScreenshotAs(OutputType.FILE);
		try {
			org.openqa.selenium.io.FileHandler.copy(img, path);//copy
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath("."+screenshotpath);
		test.log(Status.FAIL, result.getName()+"testscript has failed andsuccessfully captured");
		
		


	}



	



	


	

}
