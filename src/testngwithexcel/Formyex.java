package testngwithexcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Formyex {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}
	public static void main(String... args) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		// TODO Auto-generated method stub

		FileInputStream fi=new FileInputStream("C:\\Users\\Lakshmi\\Desktop\\sample.xlsx");
		Workbook work = WorkbookFactory.create(fi);
		 Sheet s = work.getSheet("Sheet1");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://urbanladder.com/");
		driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']")).click();
		List<WebElement> l = driver.findElements(By.xpath("//div[@id='topnav_wrapper']/ul[@class='topnav bodytext']/li"));
		int r=0;
		Actions a=new Actions(driver);
		for(WebElement e:l)
		{	
			Row row = s.createRow(r);
			row.createCell(0).setCellValue(e.getText());
			Thread.sleep(1000);
			a.moveToElement(e).perform();
			String xpath = "//div[@id='topnav_wrapper']//li/span[contains(.,'"+e.getText()+"')]";
			Thread.sleep(1000);
			List<WebElement> sub = driver.findElements(By.xpath(xpath+"/..//div[@class='subnavlist_wrapper clearfix']//span"));
			int i=1;
			for(WebElement sube:sub)
			{
				row.createCell(i).setCellValue(sube.getText());
				i++;
			}
			r++;
		}
		FileOutputStream fo=new FileOutputStream("C:\\Users\\Lakshmi\\Desktop\\sample.xlsx");
		work.write(fo);
		fo.flush();
		fi.close();
		fo.close();
		driver.close();
	}

}
