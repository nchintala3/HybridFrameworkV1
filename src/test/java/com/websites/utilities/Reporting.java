package com.websites.utilities;
//Listener class used to generate extent Reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
public void onStart(ITestContext testcontext) {
	String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //timestamp
	String repName="Test Report-"+timestamp+".html";
	sparkReporter = new ExtentSparkReporter(System.getProperty(("user.dir")+ "/test-output/"+repName)); //specify location
	try {
		sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	extent = new ExtentReports();
	extent.attachReporter(sparkReporter);
	extent.setSystemInfo("Host name", "localhost");
	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("user", "Nagendra");
	
	sparkReporter.config().setDocumentTitle("OrangeHRMTest");
	sparkReporter.config().setReportName("Functional Test Report");
	sparkReporter.config().setTheme(Theme.DARK);
	}
public void onTestSuccess(ITestResult tr) {
	logger = extent.createTest(tr.getName());
	logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
}
public void onTestFailure(ITestResult tr) {
	logger = extent.createTest(tr.getName());
	logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	 File f = new File(screenshotPath);
	 
	  if (f.exists()) {
		  try {
		  logger.fail("Screenshot is below:"+ logger.addScreenCaptureFromPath(screenshotPath));
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  }
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
  public void onFinish(ITestContext testcontext) {
	  extent.flush();
  }
}

