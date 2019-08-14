package extentreport;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listenersclass.class)
public class Testclassdemo extends BaseTest{
	@Test
	public void TitleAssert()
	{
		driver.get("https://www.google.com");
		Assert.assertEquals(driver.getTitle(),"Google");
	}
	@Test
	public void link() throws InterruptedException
	{
		driver.get("https://www.google.com");
		Assert.assertEquals(driver.getTitle(),"Google");
		driver.findElement(By.xpath("//div[@id='SIvCob']//a[7]")).click();
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//a[text()='Gmail']"));
		Assert.assertEquals(ele.getText(),"Gmail");
	}
	@Test
	public void autosuggestion()
	{
		driver.get("https://www.google.com");
		Assert.assertEquals(driver.getTitle(),"Google");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("airtel");
		List<WebElement> lst = driver.findElements(By.xpath("//div[@class='aajZCb']//li"));
		lst.get(1).click();
		WebElement ele = driver.findElement(By.xpath("//a[@href='https://www.airtel.in/prepaid-recharge']/h3"));
		Assert.assertEquals(ele.getText(), "Online Mobile Recharge, Prepaid Mobile Recharge - Airtel");
		ele.click();
	}
}
