package testng;

import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class Parameters {
	
	@org.testng.annotations.Parameters({"un","pw"})
	@Test
	public void test(@Optional("admin") String u,String p)
	{
		Reporter.log(u,true);
		Reporter.log(p,true);
	}

}
