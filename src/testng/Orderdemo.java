package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Orderdemo extends BaseclassForOrder{
	@Test
	public void test()
	{
		Reporter.log("Test Method",true);
	}
	@Test
	public void test1()
	{
		Reporter.log("Test Method1",true);
	}
}
