package Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class TestUtil  extends TestBase {

	/*public static void takeScreenShot () throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Yogesh\\eclipse-workspace\\New folder\\FrameWorkProject\\Screenshots\\photo.png");
		FileHandler.copy(source, dest);
	}*/
	
	public static void takeScreenShot (String name) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Yogesh\\eclipse-workspace\\New folder\\FrameWorkProject\\Screenshots\\"+name+".png");
		FileHandler.copy(source, dest);
	}
	public static String getDateTime()
	{
		Date date = new Date();
		return date.toString();
	}	
}
