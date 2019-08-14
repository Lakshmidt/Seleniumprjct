package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo3 extends Baseclass{
	@Test
	public void deleteuser()
	{
		Reporter.log("user deleted",true);
	}
}
