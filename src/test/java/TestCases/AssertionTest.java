package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class AssertionTest extends TestBase {
	
	LoginPage login;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initalization();
		 login = new LoginPage();
	}
	
	@Test  (enabled = false) 
	public void verifyTitleTest() 
	{
		// String title = login.verifyTitle();
	    //Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
		
		 login.verifyTitle();   // this is not mandatory
		 Assert.assertTrue(true);   // test = passes
		// Assert.assertTrue(false);   // test = failed
		// Assert.assertTrue(false, "Title verify");   // when test will be failed then message will be print
		// Assert.assertTrue(true, "Title verify");  // msg is not printed
	}
	
	@Test  (enabled = false) 
	public void verifyKiteLogoTest()
	{
		boolean kitelogo = login.verifyKiteLogo();
		Assert.assertEquals(kitelogo, true);
		//Assert.assertEquals(kitelogo, false, "Kite Logo Verify");  // when test will be failed then message will be print
	}
	
	@Test (enabled = true) 
	public void verifyZerodhaLogoTest ()
	{
		
		//boolean zerodhalogo = login.verifyZerodhaLogo();
		//Assert.assertEquals(zerodhalogo, true);
		
		Assert.assertFalse(false);  // test case pass
		// Assert.assertFalse(true, "Zerodha logo");     
	}
	
	@Test (enabled = false) 
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
