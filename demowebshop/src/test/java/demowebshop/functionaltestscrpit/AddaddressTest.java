package demowebshop.functionaltestscrpit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import demowebshop.Baseclass;
import demowebshop.fileutility.Readproperties;
import demowebshop.listnersimplementation.Listnersclass;
@Listeners(Listnersclass.class)
public class AddaddressTest extends Baseclass{
	@Test
	public void test() {	
		
	    //click on my profile
      		test.log(Status.INFO, "clicked on my profile");
      	//click on address
    		test.log(Status.INFO, "clicked on address");
      	//click on add new address
    		test.log(Status.INFO, "clicked on add new address");
//    		Assert.fail();
        //entering all details
		test.log(Status.INFO, "entered all the details");
		System.out.println( "AddadressTest executed successful");

        
        
        
        

        
        
        
         
 
		
	}
	
	

}
