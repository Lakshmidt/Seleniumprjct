package brokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.util.List;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlinkdemo {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}

	public static void main(String[] args) throws IOException   {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/Lakshmi/Desktop/html%20codes/Brokenlink.html");
		List<WebElement> lst = driver.findElements(By.tagName("a"));
		for(WebElement e:lst)
		{
			URL u=new URL(e.getAttribute("href"));
			HttpURLConnection con = (HttpURLConnection)u.openConnection();
			int i=con.getResponseCode();
			if(i==200)
			{
				System.out.println(e.getText()+" Link is not broken and code is "+i);
				System.out.println(con.getResponseMessage());
			}
			else
			{
				System.out.println(e.getText()+" Link is broken and code is "+i);
				System.out.println(con.getResponseMessage());
			}
		}
		driver.close();
	}

}
