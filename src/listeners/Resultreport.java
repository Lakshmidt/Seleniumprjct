package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Resultreport implements ITestListener{
	static int passc,failc,skipc;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String name=result.getName();
		Reporter.log("Test "+name+" method is started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String name=result.getName();
		Reporter.log("Test "+name+" method is pass",true);
		passc++;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String name=result.getName();
		Reporter.log("Test "+name+" method is fail",true);
		failc++;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String name=result.getName();
		Reporter.log("Test "+name+" method is skipped",true);
		skipc++;
	}



	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		int total=passc+failc+skipc;
		int per=(passc/total)*100;
		Reporter.log("Percentage of pass "+per+"%",true);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		String name=context.getClass().toString();
		Reporter.log(name+" is stared",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("Pass count "+passc,true);
		Reporter.log("Fail count "+failc,true);
		Reporter.log("skip count "+skipc,true);
	}
	

}
