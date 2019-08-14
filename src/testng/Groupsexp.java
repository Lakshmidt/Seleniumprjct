package testng;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Groupsexp {
	@BeforeClass
	public void login()
	{
		Reporter.log("login",true);
	}
	@Test(priority=1,groups= {"user","smoke"})
	public void createuser()
	{
		Reporter.log("Create",true);
	}
	@Test(priority=2,groups= {"user"},enabled=false)
	public void edituser()
	{
		Reporter.log("edit",true);
	}
	@Test(priority=3,groups= {"user"})
	public void deleteuser()
	{
		Reporter.log("delete",true);
	}
	@Test(priority=4, groups= {"product","smoke"})
	public void creatproduct()
	{
		Reporter.log("Createproduct",true);
	}
	@Test(priority=5,groups= {"product"})
	public void deleteproduct()
	{
		Reporter.log("deleteproduct",true);
	}
	
}
