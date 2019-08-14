package assertdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AssertDemo {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}
	@Test
	public void test1()
	{
		WebDriver driver=new ChromeDriver(); 
		driver.get("http://www.google.com/");
		Assert.assertEquals(driver.getTitle(), "invalid");
		driver.close();
	}
	@Test
	public void test2()
	{
		WebDriver driver=new ChromeDriver(); 
		driver.get("http://www.google.com/");
		SoftAssert s=new SoftAssert();
		s.assertEquals(driver.getTitle(), "invalid");
		driver.close();
		s.assertAll();
	}

}
