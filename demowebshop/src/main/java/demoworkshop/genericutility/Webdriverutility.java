package demoworkshop.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.Select;

public class Webdriverutility {
	public void clickonwebelement(WebElement element) {
		element.click();
	}
	public void sendtext(WebElement element,String text) {
		element.sendKeys(text);
	}
	public String gettitle(WebDriver driver) {
		return driver.getTitle();
	}
	public void acceptalert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void dismissalert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String geturl(WebDriver driver) {
		return driver.getCurrentUrl();	
	}
	public void selectbyindex(Select select,int num) {
		select.selectByIndex(num);
	}
	public void selectbyvalue(Select select,String text) {
		select.selectByValue(text);
		
	}
	public void selectbyvisibltext(Select select,String text) {
		select.selectByVisibleText(text);
	}
	public void deselectall(Select deselect) {
		deselect.deselectAll();
	}
	public void deselectbyindex(Select deselect,int num) {
		deselect.deselectByIndex(num);
	}
	public void deselectbyvalue(Select deselect) {
		deselect.deselectByValue(null);
	}
	public void deselectbyvisibletext(Select deselect) {
		deselect.deselectByVisibleText(null);
	}
	public void movetoelement(Actions actions) {
		actions.moveToElement(null).perform();
	}
	
	public void scrolltoelement(Actions actions) {
		actions.scrollToElement(null).perform();
	}
	public void movetoframe(WebDriver driver) {
		driver.switchTo().frame(0);
	}
	
	public void movetomainpage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void captureScreenhot(WebDriver driver,String screenshotname) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File img =ts.getScreenshotAs(OutputType.FILE);
		File pathFile=new File("./screenshot/"+screenshotname+".png");
		try {
			org.openqa.selenium.io.FileHandler.copy(img, pathFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}		
	public void  capturescreenshot(WebElement element,String screeshotname) {
		File img=element.getScreenshotAs(OutputType.FILE);
		File pathFile=new File("./screenshot/"+screeshotname+".png");
		try {
			org.openqa.selenium.io.FileHandler.copy(img, pathFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}
