package Acacemy;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import pageObject.DashBoardPage;
import pageObject.HighestSketchBook;
import pageObject.SketchBookPage;
import resources.base;

public class HappyTests extends base {
	public WebDriver driver;
	DashBoardPage dp;
	SketchBookPage sp;
	HighestSketchBook hs;

	@BeforeTest
	public void initialization() throws IOException {
		driver = Initializebrowser(); // Initializing the driver
		driver.manage().window().maximize(); // Maximize the browser
		dp = new DashBoardPage(driver); // Initializing the DashBoard page
		sp = new SketchBookPage(driver); // Initializing the SketchBook page
		hs = new HighestSketchBook(driver);
	}

	@Test
	public void homePageDashBoard() throws IOException, InterruptedException {
		driver.get(prop.getProperty("url")); // Navigate to DashBoard Page
		dp.AcceptButton(); //Click on Accept Button 
		dp.searchBar().sendKeys("SketchBook"); //Search for SketchBook
		dp.searchBar().sendKeys(Keys.ENTER); 
		sp.AcceptButton();
		sp.sortBy().click(); //Click on  sortBy 
		sp.lowest().click(); //Click on Lowest to sort
		System.out.println("***********Lowest Prices************");
		sp.sorted(); // Get the list of  lowest sketch book prices from the  current page 
		System.out.println("***********Lowest Value************");
		sp.LowestValue(); //Prints the lowest Sketch Book Price from the current page
		sp.sortBy().click(); //Click on  sortBy 
		sp.highest().click();//Click on HIghest to sort
		System.out.println("***********Highest Prices************");
		sp.HighestPrice();// Get the list of  Highest sketch book prices from the  current page 
		System.out.println("***********Highest Value************");
		sp.HighestValue();//Prints the Highest Sketch Book Price from the current page
		sp.windowHandle(); // Handling multiple windows
		hs.addToBasket().click(); // adds the highest priced sketch book to the basket
		String basketPrice = hs.basketValue().getText();
		// Verify the price of sketch book added in the basket with Highest value sketch book
		Assert.assertEquals(basketPrice, "4,893.67");
	}

	@AfterTest
	public void Teardown() throws InterruptedException {

		driver.quit(); // Closes the all open windows on Browser
	}
}
