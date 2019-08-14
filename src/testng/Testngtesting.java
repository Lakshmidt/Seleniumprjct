package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testngtesting {
	@Test
	public void run() {
		Reporter.log("Testing",true);
		Reporter.log("TCo1",true);
	}

}
