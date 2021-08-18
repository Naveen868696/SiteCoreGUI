package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighestSketchBook {

	public WebDriver driver;

	public HighestSketchBook(WebDriver driver) {
		this.driver = driver;
	}

	By addToBasket = By.xpath("//div[contains(text(),'Add to basket')]");
	By basketValue = By.xpath(
			"//body/div[@id='content']/div[@id='checkout']/div[@id='multi-shop-cart-list']/div[1]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/p[1]/span[1]/span[2]");

	public WebElement addToBasket() {
		return driver.findElement(addToBasket);
	}

	public WebElement basketValue() {
		return driver.findElement(basketValue);
	}

}
