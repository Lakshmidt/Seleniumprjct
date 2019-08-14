package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {
	@Test
	public void demo()
	{
		Reporter.log("Demo1tc01", true);
		Reporter.log("Demo1tc02",true);
	}

}
