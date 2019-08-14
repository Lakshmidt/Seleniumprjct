package assertdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paralleldemo {
	static
	{
		System.setProperty("webdriver.chrome.driver","./softwares/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
	}
	WebDriver driver;
	@Parameters ({"browser"})
	@Test
	public void launchbrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.get("https://www.google.com");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			driver.get("https://www.google.com");
		}
	}
	@Test
	public void test()
	{
		Reporter.log("Testing",true);
	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
