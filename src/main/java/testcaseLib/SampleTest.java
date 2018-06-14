package testcaseLib;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverScript.DriverClass;
import moduleLib.SampleProgram;

public class SampleTest {
	DriverClass driverclass;
	SampleProgram getCarQuote;
	

	@BeforeMethod
	public void beforemethod() throws IOException {		
		/* Open Browser */
		
		driverclass =new  DriverClass();
		driverclass.navigateURL();
	    getCarQuote=new SampleProgram(driverclass);
		
}

	
  @Test
  public void sampleTest() throws Exception {
	  
	  getCarQuote.getCarQuoteMethod("Audi","2018","20","New South Wales","sirisha99.bikkina@gmail.com");
	  driverclass.takeSnapShot("/ScreenShot/screenshot.png");
			  
}
  
//  @AfterMethod
//  public void afterMethod() {		
//		/* Close Browser */
//	  
//	  webDriverIntractions.closebrowser();	
//		
//}

  
}
