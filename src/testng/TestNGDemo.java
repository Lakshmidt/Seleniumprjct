package testng;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {
	@BeforeMethod
	public void login()
	{
		Reporter.log("login", true);
	}
	@AfterMethod
	public void logout()
	{
		Reporter.log("logout",true);
	}
	@Test
	public void usercreated()
	{
		Reporter.log("user created", true);
	}

	@Test
	public void deleteuser()
	{
		Reporter.log("user deleted",true);
	}
	
}
