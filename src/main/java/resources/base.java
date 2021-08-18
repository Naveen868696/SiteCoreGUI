package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	public WebDriver driver;
	public Properties prop = new Properties();

	public WebDriver Initializebrowser() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\navee\\eclipse-workspace\\SiteCore\\src\\main\\java\\resources\\browser.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\navee\\eclipse-workspace\\SiteCore\\src\\main\\java\\resources\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
