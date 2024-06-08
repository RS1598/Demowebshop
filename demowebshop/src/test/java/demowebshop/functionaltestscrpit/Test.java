package demowebshop.functionaltestscrpit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import demowebshop.fileutility.Readproperties;

public class Test {
	@org.testng.annotations.Test
	public void test (){
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
	
		Readproperties read =new Readproperties();
		String url = read.fetchproperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
//		Assert.assertEquals(driver.getTitle().contains("login"), true);
		//Assert.assertTrue(forgetpassword.isDisplayed());
//		SoftAssert softAssert=new SoftAssert();
//		softAssert.assertEquals(driver.getTitle().contains("login"), true);
//		Reporter.log("Login Page is displayed",true);
        String username =read.fetchproperty("username");
		String password =read.fetchproperty("password");
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		System.out.println("loggedinsuccessfully");
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		System.out.println("LogOut succesfully");
		System.out.println("Test executed");
		driver.close();

		
	}
	

}
