package demoworkshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Welcomepage extends Basepage {
	public Welcomepage(WebDriver driver)
	{
		super(driver);
		
	}
	
	public WebElement getLoginbutton() {
		return loginbutton;
	}

	@FindAll({@FindBy(xpath = "//a[text()='Log in']")})
	private WebElement loginbutton;
	

}
