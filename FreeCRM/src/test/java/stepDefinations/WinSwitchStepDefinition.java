package stepDefinations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WinSwitchStepDefinition extends AbstractStepDefinition {
	
	WebDriver driver = getDriver();
	
	public JavascriptExecutor js;

	@Given("^User is on Practice page$")
	public void user_is_on_Practice_page() throws InterruptedException {
		
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
	}

	@When("^User Clicks on Open Wnidow button$")
	public void user_Clicks_on_Open_Wnidow_button() throws InterruptedException {
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Paternt Window: " + parentWindow);
		
	}

	@Then("^Verify Two Windows Opened$")
	public void verify_Two_Windows_Opened() throws InterruptedException {
		
		String parentWindow = driver.getWindowHandle();
		
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();
		Thread.sleep(5000);
		
		Set<String> handles = driver.getWindowHandles();
		
		for (String handle: handles) {
			System.out.println("Haldle is: " + handle);
			if(!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				Thread.sleep(3000);
				WebElement searchBox = driver.findElement(By.id("search-courses"));
				searchBox.sendKeys("Python");
				Thread.sleep(3000);
				driver.close();
				Thread.sleep(3000);
				break;
			}
			
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);
		WebElement nameTxt = driver.findElement(By.id("name"));
		nameTxt.sendKeys("Ajay Kumar");    
	}
	
	@When("^Scroll to iFrame section$")
    public void scroll_to_iframe_section() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("courses-iframe"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000); 
		
    }

    @Then("^Performs action on Frame$")
    public void performs_action_on_frame() throws InterruptedException {
    	Thread.sleep(1000);
    	driver.switchTo().frame("courses-iframe");
    	WebElement searchBox = driver.findElement(By.id("search-courses"));
    	Thread.sleep(1000);		
		searchBox.sendKeys("Python");
		Thread.sleep(1000);
		driver.switchTo().defaultContent();  
    }

    @Then("^Scroll to Name Textbox and Type$")
    public void scroll_to_name_textbox_and_type() throws InterruptedException {
    	
    	js = (JavascriptExecutor) driver;
    	
    	Thread.sleep(3000);
		WebElement nameTxt = driver.findElement(By.id("name"));
		js.executeScript("arguments[0].scrollIntoView(true);", nameTxt);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0, -190);");
		Thread.sleep(3000);
		nameTxt.sendKeys("Ajay Kumar"); 
		Thread.sleep(2000);
		
		WebElement chkLabel = driver.findElement(By.xpath("//fieldset/legend[text()='Checkbox Example']"));
		
		js.executeScript("arguments[0].scrollIntoView(true);", chkLabel);
		Thread.sleep(1000);
		
		WebElement bmwChkbox = driver.findElement(By.id("bmwcheck")); 
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", bmwChkbox);
		Thread.sleep(1000);	
    	}
    
    	@When("^Scroll to Switch alert button section$")
    	public void scroll_to_switch_alert_button_section() throws InterruptedException {
    		
    	js = (JavascriptExecutor) driver;
    		
        Thread.sleep(3000);
        WebElement alertLabel = driver.findElement(By.xpath("//fieldset/legend[text()='Switch To Alert Example']"));
        js.executeScript("arguments[0].scrollIntoView(true);", alertLabel);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0, -100);");
		Thread.sleep(1000);
    	}

    	@Then("^Work with Alert and Confirm Popups$")
    	public void work_with_alert_and_confirm_popups() throws InterruptedException {
    	Thread.sleep(1000);
        WebElement nameTxt = driver.findElement(By.id("name"));
        nameTxt.sendKeys("Ajay");
        WebElement alertBtn = driver.findElement(By.id("alertbtn"));
        alertBtn.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);
        nameTxt.sendKeys("Ajay");
        WebElement confirmBtn = driver.findElement(By.id("confirmbtn"));
        confirmBtn.click();
        Thread.sleep(3000);
        Alert confirm = driver.switchTo().alert();
        confirm.dismiss();
        Thread.sleep(3000);
    	}

}
