package stepDefinations;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class DealMapsStepDefinition extends AbstractStepDefinition {
	
	WebDriver driver = getDriver();
	
	 @Then("^User Enter UserName and Password fields with Maps$")
	    public void user_enter_username_and_password_fields_with_maps(DataTable Credential) {
		 
		 for(Map<String, String> data : Credential.asMaps(String.class, String.class)) {	 
			 	driver.findElement(By.name("email")).sendKeys(data.get("UserName"));
		    	driver.findElement(By.name("password")).sendKeys(data.get("Password")); 
		 	} 
	 	}
	        

	 
	 @Then("^Enter Title and Description and Probability and Amount with Maps$")
	    public void enter_title_and_description_and_probability_and_amount_with_maps(DataTable details) throws InterruptedException {
		 
		 Thread.sleep(5000);
		 
		 for(Map<String, String> data : details.asMaps(String.class, String.class)) {	 
			 driver.findElement(By.name("title")).sendKeys(data.get("Title"));
		     Thread.sleep(2000);
		     driver.findElement(By.name("description")).sendKeys(data.get("Description"));
		     Thread.sleep(2000);
		     driver.findElement(By.name("probability")).sendKeys(data.get("Probability"));
		     Thread.sleep(2000);
		     driver.findElement(By.name("amount")).sendKeys(data.get("Amount")); 
		 	} 
	 	}
	 
	 @Then("^Verify the New Deal created with Title and Amount with Maps$")
	    public void verify_the_new_deal_created_with_title_and_amount_with_maps(DataTable details) throws InterruptedException {
		 
		 for(Map<String, String> data : details.asMaps(String.class, String.class)) {
			 
			 	Thread.sleep(5000);
			 	
			 	WebDriverWait wait1 = new  WebDriverWait(driver, 20);
		    	WebElement title = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[2]")));
		    	boolean status1 = title.isDisplayed();
		    	Assert.assertEquals(true, status1); 
		    	
			 	String Title = title.getText();
			 	System.out.println(Title);
		    	Assert.assertEquals(data.get("Title"), Title);
		    	
		    	WebDriverWait wait2 = new  WebDriverWait(driver, 20);
		    	WebElement amount = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[5]")));
		    	boolean status2 = amount.isDisplayed();
		    	Assert.assertEquals(true, status2);
		    	
		    	String Amount = amount.getText();
		    	System.out.println(Amount);
		    	Assert.assertEquals(data.get("Amount"), Amount);
		 	} 
	        
	    }

}
