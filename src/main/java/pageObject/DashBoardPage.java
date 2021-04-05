package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage {
	
	// all the webelements on DashBoard page
	public WebDriver driver;
	By intellisenseHomePageIcon = By.xpath("//img[@class='pull-left']");
	By TestDashBoardText 		= By.xpath("//h1[contains(text(),'Test dashboard')]");
	By HomepageConfirmationBox	= By.xpath("//button[contains(text(),'OK')]");
	By homePageTB				= By.xpath("//body/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/ng-include[1]/div[1]/li[1]");
	By duplicateDashbaordTB 	= By.xpath("//body/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/ng-include[1]/div[1]/li[2]");
	By exportDataTB 			= By.xpath("//body/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/ng-include[1]/div[1]/li[4]");
	By ShareTB					= By.xpath("//body/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/ng-include[1]/div[1]/li[3]");
	By createWidgetTB 		 	= By.xpath("//body/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/ng-include[1]/div[1]/li[5]");
	By reOrderWidgetTB			= By.xpath("//body/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/ng-include[1]/div[1]/li[6]");
	By deleteTB					= By.xpath("//body/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/ng-include[1]/div[1]/li[7]");
	By linktoCreateDashboard 	= By.xpath("//span[contains(text(),'Learn how to create a Dashboard')]");
	By linktoAddWidget			= By.xpath("//span[contains(text(),'Learn how to create a Widget')]");
	By linktouseToolBarss		= By.xpath("//span[contains(text(),'Learn how to use the Dashboard Toolbar')]");
	By searchNavBar				= By.xpath("//header/div[1]/div[3]/a[1]");
	By userNavBar				= By.xpath("//header/div[1]/div[3]/button[4]");
	By helpNavBar				= By.xpath("//header/div[1]/div[3]/button[2]");
	By intercomNavBar			= By.xpath("//header/div[1]/div[3]/button[1]");
	By dateTimeNavBar			= By.xpath("//header/div[1]/div[3]/button[3]");
	By dashBoardframeNext		= By.xpath("//button[contains(text(),'Next')]");
	By dashBoardFrameCancel		= By.xpath("//span[@role='button']");
	By widgetframeNext			= By.xpath("//button[contains(text(),'Next')]");
	By WidgetFrameCancel 		= By.xpath("//span[@role='button']");
	By useDashBoardframeNext	= By.xpath("//button[contains(text(),'Next')]");
	By useDashBoardFrameCancel 	= By.xpath("//span[@role='button']");
	By dashBoardDropdown		= By.xpath("//body/div[3]/div[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/li[1]/a[1]/i[1]");
	By userIcon					= By.xpath("//header/div[1]/div[3]/button[4]");
	By signout					= By.xpath("//button[@ng-click='signOut()']");
	By signoutOK				= By.xpath("//button[contains(text(),'OK')]");
	By duplicateBoxText			= By.xpath("//h1[contains(text(),'Name Duplicate Dashboard')]");
	By duplicateboardName		= By.xpath("//input[@id='name']");
	By duplicateOK				= By.xpath("//button[contains(text(),'OK')]");
	
	
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getIntelliSense()
	{
		return driver.findElement(intellisenseHomePageIcon);
	}
	public WebElement getDashBoardText()
	{
		return driver.findElement(TestDashBoardText);
	}
	public WebElement getexportDataTB()
	{
		return driver.findElement(exportDataTB);
	}
	public WebElement getduplicateDashbaordTB()
	{
		return driver.findElement(duplicateDashbaordTB);
	}
	public WebElement gethomepageTB()
	{
		return driver.findElement(homePageTB);
	}
	public WebElement getShareTB()
	{
		return driver.findElement(ShareTB);
	}
	public WebElement getcreateWidgetTB()
	{
		return driver.findElement(createWidgetTB);
	}
	public WebElement getreOrderWidgetTB()
	{
		return driver.findElement(reOrderWidgetTB);
	}
	public WebElement getdeleteTB()
	{
		return driver.findElement(deleteTB);
	}
	public WebElement getlinktoCreateDashboard()
	{
		return driver.findElement(linktoCreateDashboard);
	}
	public WebElement getlinktoAddWidget()
	{
		return driver.findElement(linktoAddWidget);
	}
	public WebElement getlinktouseToolBarss()
	{
		return driver.findElement(linktouseToolBarss);
	}
	public WebElement getsearchNavBar()
	{
		return driver.findElement(searchNavBar);
	}
	public WebElement getuserNavBar()
	{
		return driver.findElement(userNavBar);
	}
	public WebElement gethelpNavBar()
	{
		return driver.findElement(helpNavBar);
	}
	public WebElement getintercomNavBar()
	{
		return driver.findElement(intercomNavBar);
	}
	public WebElement getdateTimeNavBar()
	{
		return driver.findElement(dateTimeNavBar);
	}
	public WebElement getdashBoardframeNext()
	{
		return driver.findElement(dashBoardframeNext);
	}
	public WebElement getdashBoardFrameCancel()
	{
		return driver.findElement(dashBoardFrameCancel);
	}
	public WebElement getwidgetframeNext()
	{
		return driver.findElement(widgetframeNext);
	}
	public WebElement getWidgetFrameCancel()
	{
		return driver.findElement(WidgetFrameCancel);
	}
	public WebElement getuseDashBoardframeNext()
	{
		return driver.findElement(useDashBoardframeNext);
	}
	public WebElement getuseDashBoardFrameCancel()
	{
		return driver.findElement(useDashBoardFrameCancel);
	}
	public WebElement getdashBoardDropdown()
	{
		return driver.findElement(dashBoardDropdown);
	}
	public WebElement getuserIcon()
	{
		return driver.findElement(userIcon);
	}
	public WebElement getsignout()
	{
		return driver.findElement(signout);
	}
	public WebElement getsignoutOK()
	{
		return driver.findElement(signoutOK);
	}
	public WebElement getduplicateBoxText()
	{
		return driver.findElement(duplicateBoxText);
	}
	public WebElement getduplicateboardName()
	{
		return driver.findElement(duplicateboardName);
	}
	public WebElement getduplicateOK()
	{
		return driver.findElement(duplicateOK);
	}
	public WebElement getHomepageConfirmationBox()
	{
		return driver.findElement(HomepageConfirmationBox);
	}
	

}
