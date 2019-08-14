package assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Bluestone {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bluestone.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 WebElement ele = driver.findElement(By.xpath("//a[text()='Rings ']"));
		 Actions a=new Actions(driver);
		 Thread.sleep(1000);
		a.moveToElement(ele).perform();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[text()='Popular Ring Types ']/..//a[text()='Diamond']/..")).click();
		 a.moveToElement(driver.findElement(By.id("Price-form"))).perform();
		List<WebElement> l = driver.findElements(By.xpath("//section[@id='Price-form']/..//div[@class='bs-tt bs-tt-tl bs-tt-sq bs-tt-blue active']//span"));
		 for(WebElement e:l)
		 {
			 System.out.println(e.getText());
		 }
		 a.moveToElement(driver.findElement(By.xpath("//section[@class='block sort-by pull-right']"))).perform();
		 driver.findElement(By.xpath("//a[text()='Price Low to High ']")).click();
		 
	}

}
