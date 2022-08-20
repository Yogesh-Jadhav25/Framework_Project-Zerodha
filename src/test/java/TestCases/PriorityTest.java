package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class PriorityTest extends TestBase{
	
	LoginPage login;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initalization();
		 login = new LoginPage();
	}
	
	@Test (priority = -2)
	public void verifyTitleTest() 
	{
		String title = login.verifyTitle();
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test (priority = -1)
	public void verifyKiteLogoTest()
	{
		boolean kitelogo = login.verifyKiteLogo();
		Assert.assertEquals(kitelogo, true);
	}
	
	@Test (priority = 1)
	public void verifyZerodhaLogoTest ()
	{
		boolean zerodhalogo = login.verifyZerodhaLogo();
		Assert.assertEquals(zerodhalogo, true);
	}
	
	@Test (priority = 2)
	public void loginToAppTest () throws InterruptedException, IOException
	{
		String value = login.loginToApp();
		Assert.assertEquals(value, "Yogesh");
		
	}
	
	
	@AfterMethod 
	public void exit ()
	{
		driver.close();
	}

}
