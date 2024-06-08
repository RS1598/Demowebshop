package demowebshop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import demowebshop.fileutility.Readproperties;
import demowebshop.listnersimplementation.Listnersclass;
import demoworkshop.objectrepository.Welcomepage;

public class Baseclass extends Listnersclass{
	public WebDriver  driver;
	public static WebDriver sdriver;
	Readproperties read = new Readproperties();
//	Webdriverutility webdriverutility=new Webdriverutility();


	@BeforeClass
	public void openbrowser() {
		driver =new ChromeDriver();
//		String browser=System.getProperty("browser");
//		if(browser.contains("chrome")) {
//			driver=new ChromeDriver();
//		}
//		else if(browser.contains("edge")){
//			driver=new EdgeDriver();
//		}
//		sdriver=driver;
		driver.manage().window().maximize();
		String url = read.fetchproperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
	}
	@BeforeMethod
	public void login() {
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		Welcomepage welcomepage=new Welcomepage(driver);
//		webdriverutility.gettitle(driver);
		welcomepage.getLoginbutton().click();
//		webdriverutility.clickonwebelement(null);
		String username =read.fetchproperty("username");
		String password =read.fetchproperty("password");
//		
//		Loginpage loginpage=new Loginpage(driver);
//		loginpage.getEmailtextfield().sendKeys(username);
//		loginpage.getPasswordtextfield().sendKeys(password);
//		loginpage.getLoginbutton().click();
//		

//		Assert.assertEquals(driver.getTitle().contains("login"), true);
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		System.out.println("loggedinsuccessfully");
		

	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		System.out.println("LogOut succesfully");	
	}
	@AfterClass
	public void closebrowser() {
		driver.quit();
	}
	

}
