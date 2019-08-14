package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Prioritydemo {
	@Test(priority=1)
	public void test1()
	{
		Reporter.log("test1",true);
	}
	@Test(priority=0,invocationCount=2)
	public void test2()
	{
		Reporter.log("test2",true);
	}
	@Test(priority=2)
	public void test3()
	{
		Reporter.log("test3",true);
	}

}
