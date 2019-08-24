package stepDefinations;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class DealStepDefination extends AbstractStepDefinition {
	
	WebDriver driver = getDriver();
    
    @Then("^User Enter UserName and Password fields from data table$")
    public void user_enter_username_and_password_fields_from_data_table(DataTable Credential) {
    	
    	List<List<String>> data = Credential.raw();
    	driver.findElement(By.name("email")).sendKeys(data.get(0).get(0));
    	driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));    
    }
    
    @Then("^User Mouse Hover and Clicks on Deal Tab$")
    public void user_mouse_hover_and_clicks_on_deal_tab() throws InterruptedException {
    	
    	WebDriverWait wait = new  WebDriverWait(driver, 20);
    	WebElement dealTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/deals']")));
    	boolean status = dealTab.isDisplayed();
    	Assert.assertEquals(true, status);   			 
    	Actions action = new Actions(driver);
    	action.moveToElement(dealTab).build().perform();
    	Thread.sleep(3000);
    	dealTab.click();    
    }
    
    @Then("^Verify the Deal page is loaded$")
    public void verify_the_deal_page_is_loaded() throws InterruptedException {
    	Thread.sleep(5000);
        boolean element1 = driver.findElement(By.id("dashboard-toolbar")).isDisplayed();
        boolean element2 = driver.findElement(By.xpath("//a[@href='/deals/new']")).isDisplayed();
        Assert.assertEquals(true, element1);
        Assert.assertEquals(true, element2);
    }
    
    @Then("^User Clicks on Create New Button Deal$")
    public void user_clicks_on_create_new_button_deal() throws InterruptedException {
    	Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/deals/new']")).click();
    }
    
    @Then("^Enter Title and Description and Probability and Amount from data table$")
    public void enter_title_and_description_and_probability_and_amount_from_data_table(DataTable details) throws InterruptedException {
    	
    	Thread.sleep(5000); 	
    	List<List<String>> data = details.raw();	
        driver.findElement(By.name("title")).sendKeys(data.get(0).get(0));
        Thread.sleep(2000);
        driver.findElement(By.name("description")).sendKeys(data.get(0).get(1));
        Thread.sleep(2000);
        driver.findElement(By.name("probability")).sendKeys(data.get(0).get(2));
        Thread.sleep(2000);
        driver.findElement(By.name("amount")).sendKeys(data.get(0).get(3));
    }
    
    @Then("^Click on Save Deal Button$")
    public void click_on_save_deal_button() throws InterruptedException {
    	Thread.sleep(5000);
        boolean saveButton = driver.findElement(By.xpath("//button[@class='ui linkedin button']")).isDisplayed();
        Assert.assertEquals(saveButton, true);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
    }
    
    @Then("^Verify the New Deal created with Title and Amount from data table$")
    public void verify_the_new_deal_created_with_title_and_amount_from_data_table(DataTable Verifydata) throws InterruptedException {
    	Thread.sleep(5000);
    	List<List<String>> data = Verifydata.raw();
    	
    	String Title = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
    	Assert.assertEquals(data.get(0).get(0), Title);
    	Thread.sleep(2000);
    	String Amount = driver.findElement(By.xpath("//tbody/tr/td[5]")).getText();
    	Assert.assertEquals(data.get(0).get(1), Amount);
    }

}
