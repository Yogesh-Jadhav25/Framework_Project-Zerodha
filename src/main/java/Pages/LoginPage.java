package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//img[@alt='Kite']") private WebElement kiteLogo;
	@FindBy(xpath = "//img[@alt='Zerodha']") private WebElement zerodhaLogo;
	
	@FindBy(xpath = "//input[@id='userid']") private WebElement userIdTextBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordTextBox;
	@FindBy(xpath = "//button[@type='submit']") private WebElement submitBtn;
	
	@FindBy(xpath = "//input[@id='pin']") private WebElement pin;
	@FindBy(xpath = "//button[@type='submit']") private WebElement continueBtn;
	
	@FindBy(xpath = "//span[@class='nickname']") private WebElement nickname;
	
	public LoginPage ()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle ()
	{
		 return driver.getTitle();
	}
	
	public boolean verifyKiteLogo ()
	{
		return kiteLogo.isDisplayed();
	}
	
	public boolean verifyZerodhaLogo ()
	{
		return zerodhaLogo.isDisplayed();
	}
	
	public String loginToApp () throws InterruptedException, IOException
	{
		userIdTextBox.sendKeys(readPropertyFile("userid"));
		//Thread.sleep(2000);
		passwordTextBox.sendKeys(readPropertyFile("password"));
		//Thread.sleep(2000);
		submitBtn.click();
		//Thread.sleep(2000);
		pin.sendKeys(readPropertyFile("pin"));
		//Thread.sleep(2000);
		continueBtn.click();
		//Thread.sleep(3000);
		
		return nickname.getText();
	
	}
	
	

}
