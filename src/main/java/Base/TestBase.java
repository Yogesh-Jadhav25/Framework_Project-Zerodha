package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase  {
	
	
	public static  WebDriver driver;
	
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	
	public void initalization () throws IOException
	
	
	{
		String browserName = readPropertyFile("browser");
		if (browserName.equalsIgnoreCase("chrome"))
		{	
		ChromeOptions ops = new ChromeOptions();        //for disable notification
		ops.addArguments("--disable-notifications");
		
		//WebDriverManager.chromedriver().setup();
		ops.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe" );
	    driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();             //for deleting All cookies
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.get("https://kite.zerodha.com/");
		driver.get(readPropertyFile("url"));
		}
		
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe" );
			 driver = new FirefoxDriver();
			 driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(readPropertyFile("url"));
		}
		
		else if (browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.msedge.driver", "msedgedriver.exe" );
			 driver = new EdgeDriver();
			 driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(readPropertyFile("url"));
		}
	}
	
	//Read the Property File 
	
	public String readPropertyFile(String value) throws IOException
	{
		Properties prop = new Properties ();
		FileInputStream file = new FileInputStream("C:\\Users\\Yogesh\\eclipse-workspace\\New folder\\FrameWorkProject\\src\\main\\java\\Config\\Config.properties");
		prop.load(file);
		return prop.getProperty(value);
	}
	
	//Read Excel File
	
	public String readExcelFile (int rowNum, int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream ("C:\\Users\\Yogesh\\eclipse-workspace\\New folder\\FrameWorkProject\\Test Data\\Test1.xlsx");
	   Sheet excelSheet = WorkbookFactory.create(file).getSheet("Sheet4");
	   String value = excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	   return value;
	}

}
