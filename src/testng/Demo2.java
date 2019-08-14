package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo2 extends Baseclass {
	@Test
	public void usercreated()
	{
		Reporter.log("user created", true);
	}
}
