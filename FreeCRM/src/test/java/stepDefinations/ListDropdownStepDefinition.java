package stepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.When;

public class ListDropdownStepDefinition extends AbstractStepDefinition {
	
	WebDriver driver = getDriver();
	
	@When("^User Selects the Radio button and Verify the button is selected$")
    public void user_selects_the_radio_button_and_verify_the_button_is_selected() throws Throwable {
        boolean isChecked = false;
        List<WebElement> radiobutton = driver.findElements(By.xpath("//input[contains(@name,'cars') and contains(@type,'radio')]"));
        int size = radiobutton.size();
        System.out.println("The Size of the List : " + size);
        
        for(int i=0; i<size; i++) {
        	
        	isChecked = radiobutton.get(i).isSelected();
        	
        	if(!isChecked) {
        		radiobutton.get(i).click();
        		Thread.sleep(2000);
        	}   	
        }
    }

	@When("^User Selects the options from Dropdown$")
    public void user_selects_the_options_from_dropdown() throws Throwable {
        WebElement element = driver.findElement(By.id("carselect"));
        
        Select sel = new Select(element);
        
        Thread.sleep(2000);
        System.out.println("Select by Benz Value");
        sel.selectByValue("benz");
        
        Thread.sleep(2000);
        System.out.println("Select Honda by index");
        sel.selectByIndex(2);
        
        Thread.sleep(2000);
        System.out.println("Select BMW by visible text");
        sel.selectByVisibleText("BMW");
        
        Thread.sleep(2000);
        System.out.println("Print all the options in select tag");
        List<WebElement> options = sel.getOptions();
        int size = options.size();
        
        for(int i = 0; i<size; i++) {
        	String option = options.get(i).getText();
        	System.out.println(option);
        }      
    }
	
	@When("^User Multi Selects the options from Dropdown$")
    public void user_multi_selects_the_options_from_dropdown() throws Throwable {
        WebElement element = driver.findElement(By.id("multiple-select-example"));
        
        Select sel = new Select(element);
        
        Thread.sleep(2000);
        System.out.println("Select orange By value");
        sel.selectByValue("orange");
        
        Thread.sleep(2000);
        System.out.println("De-Select orange By value");
        sel.deselectByValue("orange");
        
        Thread.sleep(2000);
        System.out.println("Select Peach By index");
        sel.selectByIndex(2);
       
        Thread.sleep(2000);
        System.out.println("Select apple By Visible Test");
        sel.selectByVisibleText("Apple");
		
        Thread.sleep(2000);
        System.out.println("Print all Selected value");
        List<WebElement> Selectedoptions = sel.getAllSelectedOptions();
        int size = Selectedoptions.size();
        System.out.println("Selected option count : " + size);
        for (WebElement option : Selectedoptions) {
        	System.out.println("Option Text : " + option.getText());
        }
        
        Thread.sleep(2000);
        System.out.println("De-Select All options");
        sel.deselectAll();
    }

}
