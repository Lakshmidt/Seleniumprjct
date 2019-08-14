package extentreport;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {
	static ExtentHtmlReporter htmlreport;
	static ExtentTest test;
	static ExtentReports extest;
	static WebDriver driver;
	@BeforeSuite
	public void Bsuite()
	{
		htmlreport=new ExtentHtmlReporter(new File("C:\\Users\\Lakshmi\\Music\\Demo\\TestNGproject\\Reports\\extentreport.html"));
		extest=new ExtentReports();
		extest.attachReporter(htmlreport);
		test=extest.createTest("Selenium test");
	}
	@BeforeMethod
	public void Bmethod()
	{
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@AfterMethod
	public void Amethod()
	{
		driver.close();
	}
	@AfterSuite
	public void Asuite()
	{
		extest.flush();
	}
}
