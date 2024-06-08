package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import demowebshop.Baseclass;
import demowebshop.fileutility.Readexcel;
import demowebshop.fileutility.Readproperties;

public class LoginTest1 extends Baseclass{
	
	
	@DataProvider

	public Object[][] dataSuppliertest(){
		Readexcel readExcel=new Readexcel();
		Object[][] data =readExcel.getmultipledata("sheet1");

		return data;

	}

	

	@Test(dataProvider = "dataSupplier")

	public LoginTest1(String username,String password){

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		Readproperties read=new Readproperties();


		String url =read.fetchproperty("url");

		driver.get(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.partialLinkText("Log in")).click();

		driver.findElement(By.id("Email")).sendKeys(username);

		driver.findElement(By.id("Password")).sendKeys(password);
		
		System.out.println("LoginTest executed");
		
	
	}

}
