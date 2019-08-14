package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Dependencies {
	@Test (groups= {"user"}, enabled=true)
	public void createuser()
	{
		Reporter.log("create",true);
	}
	@Test(groups= {"user"}, dependsOnMethods = "createuser", dependsOnGroups = "product")
	public void deleteser()
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
