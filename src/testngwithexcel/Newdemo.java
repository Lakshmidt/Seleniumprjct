package testngwithexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Newdemo {
	public void main(String [] args) throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		FileInputStream fi=new FileInputStream("C:\\Users\\Lakshmi\\Desktop\\Excel.xlsx");
		Workbook work=WorkbookFactory.create(fi);
		Sheet s = work.getSheet("Sheet1");
		Row r = s.createRow(5);
		r.createCell(0).setCellValue("Hiiiiiiiiiii");
		FileOutputStream fo=new FileOutputStream("C:\\Users\\Lakshmi\\Desktop\\Excel.xlsx");
		work.write(fo);
		fo.flush();
		fi.close();
		fo.close();
	
	}

}

