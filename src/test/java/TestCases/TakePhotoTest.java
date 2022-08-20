package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.TestUtil;


public class TakePhotoTest  extends TestBase {
	
	LoginPage login;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initalization();
		 login = new LoginPage();
	}
	
	@Test 
	public void verifyTitleTest() 
	{
		String title = login.verifyTitle();
		Assert.assertEquals("Kite1 - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	
	/*@AfterMethod 
	public void exit (ITestResult it) throws IOException
	{
		if (ITestResult.FAILURE==it.getStatus())
		{
			Util1.takeScreenShot();
		}
		driver.close();
	}*/
	
	@AfterMethod 
	public void exit (ITestResult it) throws IOException
	{
		if (ITestResult.FAILURE==it.getStatus())
		{
			TestUtil.takeScreenShot(it.getName());
		}
		driver.close();
	}

}
