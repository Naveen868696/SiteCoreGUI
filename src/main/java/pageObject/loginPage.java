package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By email = By.xpath("//input[@id = 'email']");
	By password = By.xpath("//input[@id = 'password']");
	By login = By.xpath("//button[contains(text(),'Sign in')]");
	
	
	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	public WebElement getlogin()
	{
		return driver.findElement(login);
	}

}
