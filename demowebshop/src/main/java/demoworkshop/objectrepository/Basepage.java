package demoworkshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage {
	public Basepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
}
