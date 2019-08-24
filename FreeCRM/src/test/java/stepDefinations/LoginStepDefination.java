package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDefination extends AbstractStepDefinition{
	
	WebDriver driver = getDriver();
	
	@Before("@Smoke")
	public void test_setup_method() {
		System.out.println("Hooks Before Method");
	}
	
	@After("@Smoke")
	public void test_teardown_method() throws InterruptedException {
		System.out.println("Hooks After Method");
		Thread.sleep(3000);
		driver.quit();	
	}
	
	@Given("^User is already on login page$")
    public void user_is_already_on_login_page() throws InterruptedException {
		driver.get("https://ui.cogmento.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^Title of Login page is CMR$")
    public void title_of_login_page_is_cmr() {
    	String title = driver.getTitle();
    	System.out.println("The Title is: " + title);
    	Assert.assertEquals("CRM", title);      
    }

    @Then("^User Enter UserName and Password$")
    public void user_enter_username_and_password() {
    	driver.findElement(By.name("email")).sendKeys("ajay24789@gmail.com");
    	driver.findElement(By.name("password")).sendKeys("Ajay4444");        
    }

    @Then("^User Clicks on login button$")
    public void user_clicks_on_login_button() {
    	driver.findElement(By.xpath("//div[text()='Login']")).click();
    }

    @And("^User is on Home page$")
    public void user_is_on_home_page() throws InterruptedException {
    	Thread.sleep(5000);
    	boolean Value =	driver.findElement(By.xpath("//span[text()='Ajay Kumar']")).isDisplayed();
    	Assert.assertEquals(true, Value);    	
    }
    
    
    @And("^User Logout from CRM Application$")
    public void user_logout_from_crm_application() throws InterruptedException {
        driver.findElement(By.xpath("(//i[@class='settings icon'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a/span[text()='Log Out']")).click();
        Thread.sleep(5000);
        driver.quit();
    }

    @Then("^User clicks on Calender tab$")
    public void user_clicks_on_calender_tab() throws InterruptedException {
        driver.findElement(By.xpath("//a/span[text()='Calendar']")).click();
        Thread.sleep(3000);
    }

    @Then("^User should see Calender content$")
    public void user_should_see_calender_content() {
        boolean value = driver.findElement(By.id("dashboard-toolbar")).isDisplayed();
        Assert.assertEquals(true, value);
    }	
    
    @Then("^User Enter UserName \"([^\"]*)\" and Password \"([^\"]*)\" fields$")
    public void user_enter_username_something_and_password_something_fields(String UserName, String Passwrod) {
    	driver.findElement(By.name("email")).sendKeys(UserName);
    	driver.findElement(By.name("password")).sendKeys(Passwrod); 
    }
    
    @Then("^User Enter UserName (.+) and Password (.+) fields from Example$")
    public void user_enter_username_and_password_fields_from_example(String username, String password) {
    	driver.findElement(By.name("email")).sendKeys(username);
    	driver.findElement(By.name("password")).sendKeys(password);
    }
    
    @Then("^User Mouse Hover and Clicks on Contact Tab$")
    public void user_mouse_hover_and_clicks_on_contact_tab() throws InterruptedException {
    	
    	WebDriverWait wait = new  WebDriverWait(driver, 20);
    	WebElement contactTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/contacts']")));
    	boolean status = contactTab.isDisplayed();
    	System.out.println(status);
    	if(status==true) {
    		System.out.println("Contact Tab is Displayed");
    	} else {
    		System.out.println("Contact Tab is NOT Displayed");
    	}
    			 
    	Actions action = new Actions(driver);
    	action.moveToElement(contactTab).build().perform();
    	Thread.sleep(3000);
    	contactTab.click();        
    }

    @Then("^Verify the Contact page is loaded$")
    public void verify_the_contact_page_is_loaded() throws InterruptedException {
    	Thread.sleep(5000);
        boolean element1 = driver.findElement(By.id("dashboard-toolbar")).isDisplayed();
        boolean element2 = driver.findElement(By.xpath("//a[@href='/contacts/new']")).isDisplayed();
        System.out.println(element1);
        System.out.println(element2);
        if(element1==true) {
        	System.out.println("Toolbar is Displayed");
        }else {
        	System.out.println("Toolbar NOT is Displayed");
        }
        if(element2==true) {
        	System.out.println("New Button is Displayed");
        }else {
        	System.out.println("New Button NOT is Displayed");
        }       
    }

    @Then("^User Clicks on Create New Button$")
    public void user_clicks_on_create_new_button() throws InterruptedException {
    	Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/contacts/new']")).click();
    }

    @Then("^Enter FirstName (.+) and LastName (.+)$")
    public void enter_firstname_and_lastname(String firstname, String lastname) throws InterruptedException {
    	Thread.sleep(5000);
    	boolean FN = driver.findElement(By.name("first_name")).isDisplayed();
        boolean LN = driver.findElement(By.name("last_name")).isDisplayed();
        System.out.println(FN);
        System.out.println(LN);
        if(FN==true) {
        	System.out.println("Firstname TXT is Displayed");
        }else {
        	System.out.println("Firstname TXT NOT is Displayed");
        }
        if(LN==true) {
        	System.out.println("Lastname TXT is Displayed");
        }else {
        	System.out.println("Lastname TXT NOT is Displayed");
        }
        
        driver.findElement(By.name("first_name")).sendKeys(firstname);
        Thread.sleep(3000);
        driver.findElement(By.name("last_name")).sendKeys(lastname);      
    }

    @Then("^Click on Save Button$")
    public void click_on_save_button() throws InterruptedException {
    	Thread.sleep(5000);
        boolean saveButton = driver.findElement(By.xpath("//button[@class='ui linkedin button']")).isDisplayed();
        System.out.println(saveButton);
        if(saveButton==true) {
        	System.out.println("Save button is Displayed");
        }else {
        	System.out.println("Save button NOT is Displayed");
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
        
    }

    @Then("^Verify the New Contact Created (.+) and (.+)$")
    public void verify_the_new_contact_created_and(String firstname, String lastname) throws InterruptedException {
    	Thread.sleep(5000);
    	for(int i=1; i<=2; i++) {
    		
        boolean newContact = driver.findElement(By.xpath("(//tbody/tr/td[2])["+i+"]")).isDisplayed();
        System.out.println(newContact);
        if(newContact==true) {
        	System.out.println("New Contact is Displayed");
        }else {
        	System.out.println("New Contact NOT is Displayed");
        }
        
        String expecteName = firstname + " " + lastname;
        System.out.println("Expected Name: " + expecteName);
        
        String actualName = driver.findElement(By.xpath("(//tbody/tr/td[2])["+i+"]")).getText();
        System.out.println("Actual Name: " + actualName); 
        
        if(expecteName.equals(actualName)) {
        	System.out.println(expecteName + " = " + actualName);
        	break;
    	}else {
    		System.out.println(expecteName + " != " + actualName);
    		continue;
    	} 
        
    	}
    }

    
}




