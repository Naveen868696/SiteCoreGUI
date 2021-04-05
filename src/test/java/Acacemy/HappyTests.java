package Acacemy;

import java.io.IOException;
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

public class HappyTests extends base {
	public WebDriver driver;
	DashBoardPage dp;
	loginPage lp;
	
	@BeforeTest
	public void initialization() throws IOException
	{
		driver = Initializebrowser(); // Initializing the driver
		driver.manage().window().maximize(); // Maximize the browser
		dp = new DashBoardPage(driver);	// Initializing the DashBoard page
		lp= new loginPage(driver);	// Initializing the login page	
	}
	
	@Test(dataProvider="getData")
	public void baselogin(String email,String password) throws IOException
	{
		driver.get(prop.getProperty("url")); // Navigate to Intellisense.io login page
		lp.getemail().sendKeys(email); // Enter email id 
		lp.getpassword().sendKeys(password); // Enter password
		lp.getlogin().click(); // Click login button
	}
	
	@Test
	public void homePageDashBoard() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url")); // Navigate to DashBoard Page
		dp.gethomepageTB().click(); // Clicks on HomePage ToolBar Icon
		dp.getHomepageConfirmationBox().click(); // Clicks OK on Confirmation Box
	}

	@Test
	public void dashBoard554() throws IOException
	{
		driver.get(prop.getProperty("url")); // Navigate to DashBoard Page
		String title = driver.findElement(By.xpath("//h1[contains(text(),'Test dashboard')]")).getText(); // Storing the DashBoard name into a string
		System.out.println(title); // Prints the title of DashBoard
		Assert.assertEquals(title, "Test dashboard"); // Checks whether DashBoard title matches with expected name or not
	}
	@Test
	public void duplicateDashBoard() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url")); // Navigate to DashBoard Page
		dp.getduplicateDashbaordTB().click(); // Clicks on Duplicate DashBoard ToolBar Icon
	}
	@Test
	public void linkDashboard() throws IOException, InterruptedException
	{	
		driver.get(prop.getProperty("url")); // Navigate to DashBoard Page
		dp.getlinktoCreateDashboard().click(); // Clicks on Link to Create DashBoard 
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name = 'intercom-tour-frame']"))); // Switching to new frame
		dp.getdashBoardFrameCancel().click(); // Clicks on Cancel icon
	}
	@Test
	public void linkCreateWidget() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url")); // Navigate to DashBoard Page
		dp.getlinktoAddWidget().click(); // Clicks on Link to Create Widget 
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name = 'intercom-tour-frame']"))); // Switching to new frame
		dp.getWidgetFrameCancel();	// Clicks on Cancel icon
	}
	@Test
	public void linkuseDashBoard() throws IOException, InterruptedException
	{		
		driver.get(prop.getProperty("url")); // Navigate to DashBoard Page
		dp.getlinktouseToolBarss().click(); // Clicks on Link to use DashBoard ToolBars
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name = 'intercom-tour-frame']"))); // Switching to new frame
		dp.getuseDashBoardFrameCancel().click(); // Clicks on Cancel icon
	}
	
	@Test
	public void disabledCreateWidgetTB() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url")); // Navigate to DashBoard Page
		Assert.assertTrue(dp.getcreateWidgetTB().getAttribute("class").contains("disabled"), "Create widgget button is enabled"); // Assertion to Check Create Widget TooBar is disabled
	}
	
	@Test
	public void disabledShareTB() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url")); // Navigate to DashBoard Page
		Assert.assertTrue(dp.getShareTB().getAttribute("class").contains("disabled"), "Create widgget button is enabled"); // Assertion to Check Share TooBar is disabled
	}
	
	@Test
	public void disabledReOrderWidgetTB() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url")); // Navigate to DashBoard Page
		Assert.assertTrue(dp.getreOrderWidgetTB().getAttribute("class").contains("disabled"), "Create widgget button is enabled"); // Assertion to Check ReOrder Widget TooBar is disabled
	}
	
	@Test
	public void disabledDeleteTB() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url")); // Navigate to DashBoard Page
		Assert.assertTrue(dp.getdeleteTB().getAttribute("class").contains("disabled"), "Create widgget button is enabled"); // Assertion to Check Delete TooBar is disabled
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		data[0][0]="menna+automation@intellisense.io"; // email id
		data[0][1]="MAQA1$test"; // password
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
