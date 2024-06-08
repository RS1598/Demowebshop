package demowebshop.functionaltestscrpit;

import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.Status;

import demowebshop.Baseclass;

@Listeners(demowebshop.listnersimplementation.Listnersclass.class)

public class Demo2Test extends Baseclass{
	@org.testng.annotations.Test(retryAnalyzer = demowebshop.listnersimplementation.Retrylistner.class)
	public void test()
	{
//		Assert.fail();
		Reporter.log(driver.getTitle(),true);
		System.out.println("Demo2Test executed");
	}

}
