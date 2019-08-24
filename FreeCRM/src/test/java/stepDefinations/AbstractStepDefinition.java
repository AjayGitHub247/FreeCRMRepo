package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractStepDefinition {
	
	protected static WebDriver driver;
	
	protected WebDriver getDriver() {
		if(driver==null) {
			System.setProperty("webdriver.chrome.driver", "C://Bin//chromedriver.exe");
			driver = new ChromeDriver();		
		}
		return driver;
	}

}
