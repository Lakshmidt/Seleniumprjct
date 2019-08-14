package testng;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class DataProvider {
	
	@org.testng.annotations.DataProvider(name="users")
	public String[][] userdata()
	{
		String[][]data=new String[3][2];
		data[0][0]="User A";
		data[0][1]="A";
		data[1][0]="User B";
		data[1][1]="B";
		data[2][0]="User C";
		data[2][1]="C";
		
		return data;
	}
	int c=0;
	@Test(dataProvider="users")
	public void creeateuser(String u,String p)
	{
		Reporter.log("Create: "+u+" Pwd: "+p,true);
		System.out.println(++c);
	}
}
