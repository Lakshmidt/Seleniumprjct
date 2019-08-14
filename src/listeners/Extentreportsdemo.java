package listeners;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreportsdemo {
	ExtentReports report=new ExtentReports();
	ExtentTest test=report.createTest("Demo");
	
	@Test
	public void reportdemo() throws IOException
	{
		ExtentHtmlReporter rep=new ExtentHtmlReporter("C:\\Users\\Lakshmi\\Music\\Demo\\TestNGproject\\Reports\\report.html");
		
		rep.config().setDocumentTitle("Automation");
		rep.config().setReportName("Testing");
		rep.config().setTheme(Theme.STANDARD);
	//	test.addScreenCaptureFromPath("");
		
		report.attachReporter(rep);
		report.setSystemInfo("hostname", "Lakshmi");
		report.setSystemInfo("Evnname","Windows");
		report.setSystemInfo("Project name","Dempproject");
		Assert.fail();
		//test.log(Status.INFO, "Running extent report");
		//test.log(Status.PASS, "test is pass");
		//report.flush();
	}
	@AfterMethod
	public void aftermethod(ITestResult r)
	{
		System.out.println(r.getMethod().getMethodName());
		System.out.println(r.getStatus());
		if(r.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test is pass");
			report.flush();
		}
		else
		{
			test.log(Status.FAIL, "Test is fail");
			report.flush();
		}
	}
}
