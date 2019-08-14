package assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pomclass.Gpasswordpage;

public class Primarygmail {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver= new ChromeDriver();
		Gpasswordpage g=new Gpasswordpage(driver);
		driver.get("https://www.gmail.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("identifierId")).sendKeys("lakshmidt2");
		g.nextclick();
		driver.findElement(By.name("password")).sendKeys("9886123759");
		//g.nextclick();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@class='CwaK9']/span[text()='Next']")).click();
		WebElement ele = driver.findElement(By.xpath("//div[@class='aAy J-KU-KO aIf-aLe']"));
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(ele));
		String color=ele.getCssValue("color");
		System.out.println(color);
		if(color.equals("rgba(51, 51, 50, 1)"))
		{
			System.out.println("Primary section is selected");
		}
		else		
		{
			//driver.findElement(By.xpath("//div[text()='Social']")).click();
			//Thread.sleep(1000);
			ele.click();
		}
		 WebElement l = driver.findElement(By.xpath("//div[@class='J-J5-Ji amH J-JN-I']"));
		System.out.println(l.getText());
		String s=l.getText().substring(8);
		StringBuffer s1=new StringBuffer(s);
		s=s1.deleteCharAt(1).toString();
		Integer n=Integer.parseInt(s);
		System.out.println(n);
		List<WebElement> lst = driver.findElements(By.xpath("//tbody/tr[@jscontroller='ZdOxDb']"));
		System.out.println(lst.size());
		System.out.println();
		get(1);
	}
	public static void get(int i)
	{
		 //WebElement ele = (WebElement)lst.get(i);
		 String subxpath="//span[@class='bog']";
		 String senderxpath="//div[@class='yW']";
		 WebElement sender = driver.findElement(By.xpath("//tbody/tr[@jscontroller='ZdOxDb']"+"["+i+"]"+senderxpath+"/span/span"));
		 System.out.println("Sender name: "+sender.getText());
		 WebElement sub = driver.findElement(By.xpath("//tbody/tr[@jscontroller='ZdOxDb']"+"["+i+"]"+subxpath+"/span"));
		 System.out.println("Subject: "+sub.getText());
	}
}
