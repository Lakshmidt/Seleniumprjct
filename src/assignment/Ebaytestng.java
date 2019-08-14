package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ebaytestng {
	static WebDriver driver;
	static
	{
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
	}
	public static void browser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();	
		driver.get("https://in.ebay.com");
	}
	public static void main(String []args)
	{
		browser("chrome");
		search();
		result();
		proscroll();
		nthp(10);
	}
	public static void search()
	{
		driver.findElement(By.id("gh-ac")).sendKeys("Fashion");
		WebElement ele = driver.findElement(By.id("gh-cat"));
		Select s=new Select(ele);
		s.selectByVisibleText("Clothing, Shoes & Accessories");
		driver.findElement(By.id("gh-btn")).click();
	}
	public static void result()
	{
		List<WebElement> lst = driver.findElements(By.xpath("//div[@id='srp-river-results']//li[@class='s-item   ']//h3"));
		for(WebElement e:lst)
		{
			System.out.println(e.getText());
		}
	}
	public static void nthp(int i)
	{
		String xpath="//div[@id='srp-river-results']//li[@class='s-item   ']"+"["+i+"]//h3";
		driver.findElement(By.xpath(xpath)).click();
	}
	public static void proscroll()
	{
		List<WebElement> l = driver.findElements(By.xpath("//li[@class='s-item   ']//h3"));
		JavascriptExecutor j = (JavascriptExecutor)driver;
		for(WebElement e:l)
		{
			j.executeScript("window.scrollBy(0,200)");
			System.out.println(e.getText());
		}
	}
	public static void allpro()
	{
		
	}
}
