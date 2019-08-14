package testngwithexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Wrtingtoexcel {
	@BeforeClass
	public void beforeclass()
	{
		System.setProperty("webdriver.chrome.driver","./softwares/chromedriver.exe");
	}
	@Test
	public void maintest() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fi=new FileInputStream("C:\\Users\\Lakshmi\\Desktop\\urbanladder.xlsx");
		Workbook work = WorkbookFactory.create(fi);
		 Sheet s = work.getSheet("Sheet1");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://urbanladder.com/");
		driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']")).click();
		List<WebElement> l = driver.findElements(By.xpath("//div[@id='topnav_wrapper']//li/span"));
		int r=0;
		Actions a=new Actions(driver);
		for(WebElement e:l)
		{	
			Row row = s.createRow(r);
			row.createCell(0).setCellValue(e.getText());
			r++;
		}
		
		 FileOutputStream fo=new FileOutputStream("C:\\Users\\Lakshmi\\Desktop\\Urbanladder.xlsx");
			work.write(fo);
			fo.flush();
			fi.close();
			fo.close();
	}
}
