package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ActionsStepDefinition extends AbstractStepDefinition {
	
	WebDriver driver = getDriver();
	
	public JavascriptExecutor js;
	
	@Then("^Scroll to Mouse Hover Label$")
    public void scroll_to_mouse_hover_label() throws InterruptedException {
		
		js = (JavascriptExecutor) driver;
		
		WebElement mouseHoverLabel = driver.findElement(By.xpath("//fieldset/legend[text()='Mouse Hover Example']"));
		
		js.executeScript("arguments[0].scrollIntoView(true);", mouseHoverLabel);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -100);");
		Thread.sleep(2000);
    }

    @Then("^Mouse Hover on button and Click on Top$")
    public void mouse_hover_on_button_and_click_on_top() throws InterruptedException {
    	
    	WebElement mainElement = driver.findElement(By.id("mousehover"));
         
    	Actions action = new Actions(driver);
    	action.moveToElement(mainElement).perform();
    	
    	Thread.sleep(2000);
    	
    	WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']/a[text()='Top']"));
    	action.moveToElement(subElement).click().perform();
    			
    	Thread.sleep(2000);
    }
    
    @Given("^User is on jquery Drag and Drop page$")
    public void user_is_on_jquery_page() throws InterruptedException {
    	driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^Perform Drag and Drop operation$")
    public void perform_drag_and_drop_operation() throws InterruptedException {
    	
    	driver.switchTo().frame(0);
    	
        WebElement fromElement = driver.findElement(By.id("draggable"));
        WebElement toElement = driver.findElement(By.id("droppable"));
        
        Actions action = new Actions(driver);
        //Method Drag and Drop
        //action.dragAndDrop(fromElement, toElement).build().perform();
        
        //Click - Hold - Drag - Release
        action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
        Thread.sleep(5000);
    }
    
    @Given("^User is on jquery slider page$")
    public void user_is_on_jquery_slider_page() throws InterruptedException {
    	
    	driver.get("https://jqueryui.com/slider/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
    }

    @Then("^Perform slide operation$")
    public void perform_slide_operation() throws InterruptedException {
         
    	driver.switchTo().frame(0);
    	
    	WebElement element = driver.findElement(By.xpath("//div[@id='slider']/span"));
    	
    	Actions action = new Actions(driver);
    	action.dragAndDropBy(element, 200, 0).build().perform();
    	Thread.sleep(3000);
    	driver.switchTo().defaultContent();
    	Thread.sleep(2000);
    }
    
    @When("^User Navigate to Login page$")
    public void user_navigate_to_login_page() throws Throwable {
    	
    	Thread.sleep(2000);
    	
    	WebElement loginLink = driver.findElement(By.xpath("//ul/li/a[@href='/sign_in']"));
    	
    	Actions action = new Actions(driver);
    	
    	action.moveToElement(loginLink).build().perform();
    	
    	Thread.sleep(2000);
    	action.moveToElement(loginLink).click().build().perform();
    	Thread.sleep(5000);
        
    }

    @Then("^User Enters Invalid User ID and Password$")
    public void user_enters_invalid_user_id_and_password() throws Throwable {
        
    	Thread.sleep(2000);
    	WebElement emailTxt = driver.findElement(By.id("user_email"));
    	emailTxt.sendKeys("test@email.com");
    	Thread.sleep(2000);
    	emailTxt.sendKeys(Keys.TAB);
    	Thread.sleep(2000);
    	WebElement passwordTxt = driver.findElement(By.id("user_password"));
    	Thread.sleep(2000);
    	passwordTxt.sendKeys("123123");
    	
    }

    @Then("^User Verify the error message$")
    public void user_verify_the_error_message() throws Throwable {
    	Thread.sleep(2000);
    	WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']")); 
    	boolean flag = errorMessage.isDisplayed();
    	Assert.assertTrue(flag);
    }

    @And("^User Press Enter Key$")    
    public void user_press_enter_key() throws Throwable {
    	Thread.sleep(2000);
    	WebElement login = driver.findElement(By.name("commit"));
    	login.sendKeys(Keys.ENTER);
    	Thread.sleep(3000);
    }

    @Then("^User Press select all shortcut key$")
    public void user_press_select_all_shortcut_key() throws Throwable {
    	Thread.sleep(2000);
    	WebElement openWindowBtn = driver.findElement(By.id("openwindow"));
    	Thread.sleep(2000);
    	//openWindowBtn.sendKeys(Keys.CONTROL, "a");
    	//openWindowBtn.sendKeys(Keys.chord(Keys.CONTROL, "a"));   	
    	String selectAll = Keys.chord(Keys.CONTROL, "a");
    	openWindowBtn.sendKeys(selectAll);
    	Thread.sleep(2000);
    }
    
    @Then("^User Press select all shortcut key using Actions$")
    public void user_press_select_all_shortcut_key_using_actions() throws Throwable {
    	Thread.sleep(2000);
    	Actions action = new Actions(driver);
    	action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
    	Thread.sleep(2000);
    }

}
