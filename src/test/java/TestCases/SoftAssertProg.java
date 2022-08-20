package TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertProg {

	@Test
	public void Method1 ()
	{
		SoftAssert s = new SoftAssert();
		System.out.println("method 1");
		s.assertEquals(false, false);
		System.out.println("method 2");
		s.assertEquals(false, true);
	}
	
	@Test
	public void Method2 ()
	{
		SoftAssert s = new SoftAssert();
		System.out.println("method 1");
		s.assertEquals(false, false);
		System.out.println("method 2");
		s.assertEquals(false, true);
		System.out.println("method 3");
		s.assertEquals(true, true);
		System.out.println("method 4");
		s.assertEquals(true, false);
		s.assertAll();
	}

}
