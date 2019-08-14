package testngwithexcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assertingurbanladder {
	WebDriver driver; 
	FileInputStream fi;
	Workbook work;
	Sheet s;
	 Row row;
	 Cell cell;
	 int r=1;
	 int c=0;
	@BeforeClass
	public void setbrowser()
	{
		System.setProperty("webdriver.chrome.driver","./softwares/chromedriver.exe");
	}
	@Test(priority=0)
	public void fileopen() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	 fi=new FileInputStream("C:\\Users\\Lakshmi\\Desktop\\Urbanladder.xlsx");
		 work = WorkbookFactory.create(fi);
		s = work.getSheet("Sheet1");
		
	}
	@Test(priority=1)
	public void comapre()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://urbanladder.com/");
		driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']")).click();
		List<WebElement> l = driver.findElements(By.xpath("//div[@id='topnav_wrapper']/ul[@class='topnav bodytext']/li"));
		for(WebElement e:l)
		{
			row=s.getRow(r);
			
			Assert.assertEquals(e.getText(),row.getCell(1).getStringCellValue());
			row.createCell(0).setCellValue(e.getText());
			row.createCell(2).setCellValue("Pass");
			r++;
		
		}
	}

	@Test(priority=2)
	public void fileclose() throws IOException
	{
		FileOutputStream fo=new FileOutputStream("C:\\Users\\Lakshmi\\Desktop\\Urbanladder.xlsx");
	work.write(fo);
	fo.flush();
	fi.close();
	fo.close();
		
	}
	@AfterClass
	public void close()
	{
		driver.close();
	}
	
}
