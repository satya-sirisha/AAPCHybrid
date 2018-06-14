package driverScript;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import generalMethods.Constantvalues;
import generalMethods.Fileutility;
import generalMethods.Initiatebrowser;
import generalMethods.ReadByobject;
import junit.framework.Assert;

public class DriverClass {
public static WebDriver driver;
	
	public static WebDriver getCurrentDriver() throws IOException {
	if(	driver==null) {

		driver=Initiatebrowser.browsertype(Fileutility.getdesiredproperty(Constantvalues.BROWSER).toUpperCase());
	}
		
		return driver;
	}
	
	public static WebElement FINDElement(String BykeyValue) throws IOException {
		waitforPageToLoad();
		return getCurrentDriver().findElement(ReadByobject.getbyproperty(BykeyValue));
		
	}
	public List<WebElement> FINDElements(String BykeyValue) throws IOException {
		waitforPageToLoad();
		return getCurrentDriver().findElements(ReadByobject.getbyproperty(BykeyValue));
	}
	public static void click(String BykeyValue) throws IOException {
		FINDElement(BykeyValue).click();
		//Assert.assertTrue(BykeyValue.isEnabled());
	}
	public static void SendKeys(String BykeyValue,String text) throws IOException {
		FINDElement(BykeyValue).clear();
		FINDElement(BykeyValue).sendKeys(text);
	}
	public void switchToSecondWIndow() throws IOException {
		Set<String> windows=getCurrentDriver().getWindowHandles();
		Iterator<String> itr=windows.iterator();
			String firstwindow=itr.next();
			String secondwind=itr.next();
			getCurrentDriver().switchTo().window(secondwind);
	}
	public void switchTofirstWindow() throws IOException {
		Set<String> windows=getCurrentDriver().getWindowHandles();
		Iterator<String> itr=windows.iterator();
			String firstwindow=itr.next();
			String secondwind=itr.next();
			getCurrentDriver().switchTo().window(firstwindow);
	}
	
	public static void selectbytext(String ByKeyValue,String text) throws IOException {
		Select sel=new Select(FINDElement(ByKeyValue));
		sel.selectByVisibleText(text);
	}
	
	
	public static void navigateURL() throws IOException{
		getCurrentDriver().get(Fileutility.getdesiredproperty(Constantvalues.URL));
	}
	public static void waitforPageToLoad() throws IOException {
		getCurrentDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	}
	public void closebrowser() throws IOException {
		getCurrentDriver().quit();
	}
	
	 public void takeSnapShot(String FileName) throws Exception{

	        //Convert web driver object to TakeScreenshot
		 EventFiringWebDriver eventFiringWebDriver=new EventFiringWebDriver(getCurrentDriver());
             //Call getScreenshotAs method to create image file
         File SrcFile=eventFiringWebDriver.getScreenshotAs(OutputType.FILE);
             //Move image file to new destination
         File DestFile=new File(System.getProperty("user.dir")+FileName);
              //Copy file at destination
          FileUtils.copyFile(SrcFile, DestFile);

	    }

 public static void assertTrueMethod(String BykeyValue) throws IOException{
	 Assert.assertTrue(FINDElement( BykeyValue).isEnabled());
 }
 


}
