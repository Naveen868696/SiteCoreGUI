package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {

	// all the webelements on DashBoard page
	public WebDriver driver;

	By searchBar = By.xpath("//input[@id='global-enhancements-search-query']");
	By AcceptButton = By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']");

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement searchBar() {
		return driver.findElement(searchBar);
	}

	public void AcceptButton() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AcceptButton));
		driver.findElement(AcceptButton).click();
		;
	}

}
