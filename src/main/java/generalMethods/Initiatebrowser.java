package generalMethods;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;




public class Initiatebrowser {
	public	static	WebDriver driver;
public static WebDriver browsertype(String name) throws IOException {
	try {
		if(name.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\choud\\Desktop\\SELENIUM\\chromedriver\\chromedriver.exe");
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			//capability.setCapability("marionette", true);
			driver = new ChromeDriver();
			//driver.manage().window().maximize();
		}
		else
			if(name.equalsIgnoreCase("firefox")) {
		     System.setProperty("webdriver.gecko.driver","C:\\Users\\choud\\Desktop\\SELENIUM\\geckodriver\\geckodriver.exe" );
		DesiredCapabilities capability = DesiredCapabilities.firefox();
			//capability.setCapability("marionette", true);
			driver= new FirefoxDriver();
		}else
			if(name.equalsIgnoreCase("IE Bowser")) {
			System.setProperty("webdriver.ie.driver","C:\\Users\\choud\\Desktop\\SELENIUM\\IEDriverServer.exe");
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			driver = new InternetExplorerDriver();
			//driver.manage().window().maximize();
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		
	}
	
	return driver;
	
}
public static void main(String[] args) throws IOException {
	browsertype(Constantvalues.BROWSER);
	
	
}

}
