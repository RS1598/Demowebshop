package demoworkshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {

	public Loginpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public WebElement getEmailtextfield() {
		return emailtextfield;
	}
	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}
	public WebElement getLoginbutton() {
		return loginbutton;
	}
	@FindAll({@FindBy(id = "Email"),@FindBy(name = "Email")})
    private WebElement emailtextfield;
	@FindAll({@FindBy(id = "Password"),@FindBy(name = "Password")})
	private WebElement passwordtextfield;
	@FindAll({@FindBy(xpath = "//input[@class='button-1 login-button']")})
	private WebElement loginbutton;
	

	

}
