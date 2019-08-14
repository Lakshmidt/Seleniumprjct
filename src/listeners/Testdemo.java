package listeners;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Resultreport.class)
public class Testdemo {
	@Test
	public void test1() {
		System.out.println("Test1 method");
		//Assert.fail();
	}
	@Test
	public void test2()
	{
		System.out.println("Test2 method");
	}

}
