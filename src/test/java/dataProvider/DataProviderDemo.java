package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo

{
	@Test(dataProvider="getData2",dataProviderClass=DataProviderSupplier.class)
	public void loginApp(String username,String pswd) 
	{
	System.out.println(username +">>>>"+pswd);	
	}

	
}
