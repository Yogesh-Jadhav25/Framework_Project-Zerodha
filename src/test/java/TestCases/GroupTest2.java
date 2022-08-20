package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class GroupTest2 extends TestBase {
	
	LoginPage login;
	@BeforeMethod (groups = {"A","B"})
	public void setUp() throws IOException
	{
		initalization();
		 login = new LoginPage();
	}
	
	@Test (groups = "A")
	public void verifyTitleTest() 
	{
		String title = login.verifyTitle();
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
	}
	
	@Test (groups = "B")
	public void verifyKiteLogoTest()
	{
		boolean kitelogo = login.verifyKiteLogo();
		Assert.assertEquals(kitelogo, true);
	}
	
	@Test (groups = "A")
	public void verifyZerodhaLogoTest ()
	{
		boolean zerodhalogo = login.verifyZerodhaLogo();
		Assert.assertEquals(zerodhalogo, true);
	}
	
	@Test (groups = "Regression")
	public void loginToAppTest () throws InterruptedException, IOException
	{
		String value = login.loginToApp();
		Assert.assertEquals(value, "Yogesh");
		
	}
	
	
	@AfterMethod  (groups = {"A","B"})
	public void exit ()
	{
		driver.close();
	}

}
