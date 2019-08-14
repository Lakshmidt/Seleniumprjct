package pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Gpasswordpage {
	@FindBy(xpath="//span[@class='CwaK9']/span[text()='Next']")
	private WebElement ele;
	
	public Gpasswordpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void nextclick()
	{
		ele.click();
	}
}
