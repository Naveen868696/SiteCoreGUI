package pageObject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SketchBookPage {

	public WebDriver driver;

	public SketchBookPage(WebDriver driver) {
		this.driver = driver;
	}

	By sortBy = By.xpath("//div[@id='sortby']");
	By AcceptButton = By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']");

	By lowest = By.xpath("//a[contains(text(),'Lowest Price')]");
	By highest = By.xpath("//a[contains(text(),'Highest Price')]");
	By sortedLowestPrice = By.xpath("//span[@class='currency-value']");
	By sortedHighestPrice = By.xpath("//span[@class='currency-value']");

	public WebElement sortBy() {
		return driver.findElement(sortBy);
	}

	public WebElement lowest() {
		return driver.findElement(lowest);
	}

	public WebElement highest() {
		return driver.findElement(highest);
	}

	public WebElement sortedLowestPrice() {
		return (WebElement) driver.findElements(sortedLowestPrice);
	}

	public WebElement sortedHighestPrice() {
		return (WebElement) driver.findElements(sortedHighestPrice);
	}

	public void AcceptButton() {
		if (driver.findElement(AcceptButton).isDisplayed()) {
			driver.findElement(AcceptButton).click();
		}
	}

	public void sorted() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sortedLowestPrice));
		List<WebElement> lowestPrices = driver.findElements(sortedLowestPrice);
		Iterator<WebElement> itr = lowestPrices.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}

	}

	public void LowestValue() {
		List<WebElement> lowestPrices = driver.findElements(sortedLowestPrice);
		Iterator<WebElement> itr1 = lowestPrices.iterator();
		double min = Double.parseDouble(lowestPrices.get(0).getText().replace(",", ""));

		while (itr1.hasNext()) {
			double tmp = Double.parseDouble(itr1.next().getText().replace(",", ""));
			if (tmp < min) {
				min = tmp;

			}

		}
		System.out.println(min);

	}

	public void HighestPrice() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sortedHighestPrice));
		List<WebElement> HighestPrices = driver.findElements(sortedHighestPrice);
		System.out.println("HGHJK   " + HighestPrices.get(0));

		Iterator<WebElement> itr = HighestPrices.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}

	}

	public void HighestValue() {
		List<WebElement> HighestPrices = driver.findElements(sortedHighestPrice);
		Iterator<WebElement> itr = HighestPrices.iterator();
		double max = Double.parseDouble(HighestPrices.get(0).getText().replace(",", ""));
		int indexOfMax = 0;
		int index = 0;

		while (itr.hasNext()) {
			double tmp = Double.parseDouble(itr.next().getText().replace(",", ""));
			if (tmp > max) {
				max = tmp;
				indexOfMax = index;
			}

			index++;
		}
		System.out.println(max);
		HighestPrices.get(indexOfMax).click();

	}

	public void windowHandle() {
		String parent = driver.getWindowHandle();

		// This will return the number of windows opened by Webdriver and will return
		// Set of Strings
		Set<String> s1 = driver.getWindowHandles();

		// Now we will iterate using Iterator
		Iterator<String> I1 = s1.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			// Here we will compare if parent window is not equal to child window then we
			// will close

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(
						"Title of Highest Value Sketcbook ==" + driver.switchTo().window(child_window).getTitle());
			}
		}

	}

}
