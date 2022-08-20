package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
	
	public class DuplicateLoginTest extends TestBase{
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
			Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
		}
		
		@Test 
		public void verifyKiteLogoTest()
		{
			boolean kitelogo = login.verifyKiteLogo();
			Assert.assertEquals(kitelogo, true);
		}
		
		@Test 
		public void verifyZerodhaLogoTest ()
		{
			boolean zerodhalogo = login.verifyZerodhaLogo();
			Assert.assertEquals(zerodhalogo, true);
		}
		
		@Test
		public void loginToAppTest () throws InterruptedException, IOException
		{
			String value = login.loginToApp();
			Assert.assertEquals(value, "Yogesh");
			Reporter.log("Login to Application");
		}
		
		
		@AfterMethod 
		public void exit ()
		{
			driver.close();
		}

}
