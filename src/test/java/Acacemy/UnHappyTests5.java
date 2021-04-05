package Acacemy;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.DashBoardPage;
import pageObject.loginPage;
import resources.base;

public class UnHappyTests5 extends base {
	public static Logger log  = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	DashBoardPage dp;
	loginPage lp;
	
	@BeforeTest
	public void initialization() throws IOException
	{
		driver = Initializebrowser(); // Initializing the driver
		driver.manage().window().maximize(); // Maximize the browser
		dp = new DashBoardPage(driver);	// Initializing the dashboard page
		lp= new loginPage(driver);	// Initializing the login page	
	}
	
	@Test(dataProvider="getData")
	public void Baselogin(String email,String password) throws IOException
	{	
		
		driver.get(prop.getProperty("url")); // Navigate to Intellisense.io login page
		lp.getemail().sendKeys(email); // Enter email id 
		lp.getpassword().sendKeys(password); // Enter password
		lp.getlogin().click(); // Click login button
		
	}

	@Test
	public void Links() throws IOException, InterruptedException
	{
		
		driver.get(prop.getProperty("url")); // Navigate to DashBoard
		dp.gethomepageTB().click(); // Clicks on HomePage ToolBar Icon
		dp.getHomepageConfirmationBox().click(); // Clicks OK on Confirmation Box
		dp.getlinktoAddWidget().click(); // Click on Link Create Widget
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name = 'intercom-tour-frame']"))); // New Frame is displayed
		dp.getWidgetFrameCancel().click(); // Click on Cancel
		dp.getIntelliSense().click(); // Click on IntelliSense.io Home Icon
		String cURL = driver.getCurrentUrl(); // Storing Current URL in a strin
		Assert.assertEquals(cURL, "https://reference-test.intellisense.io/#!/id/dashboards/554"); // Assertion to check the Current Page URL with HomePage URL
	
	}
	

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		
		data[0][0]="menna+automation@intellisense.io"; // Email
		data[0][1]="MAQA1$test"; //Password
		return data;
	}
	
   @AfterTest
   public void Teardown() throws InterruptedException
   {
	   dp.getuserIcon().click(); // Clicks on User icon from Navigation Bar
	   dp.getsignout().click(); // Clicks on SignOut
	   dp.getsignoutOK().click(); // Clicks OK on SigOut Confirmation Box
	   driver.close(); // Closes the current Browser
   }
}
