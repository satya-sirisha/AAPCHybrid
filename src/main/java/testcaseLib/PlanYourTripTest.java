package testcaseLib;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverScript.DriverClass;
import moduleLib.PlanYourTrip;


public class PlanYourTripTest {
	
	/* TestCae2:
	 * open browser
	 * navigate to URl
	 *  Plan your Trip table
	 *  select Origin
	 *  select Destination
	 *  select day 
	 *  and so on
	 *  click on viewTrip*/
	DriverClass driverclass;
	PlanYourTrip planYourTrip;
	

	@BeforeMethod
	public void beforemethod() throws IOException {		
		/* Open Browser */
		
		driverclass =new  DriverClass();
		/*Navigate to URL : www.SydneyTrain
		 */
		driverclass.navigateURL();
		
		planYourTrip=new PlanYourTrip(driverclass); 
		
}
  @Test
  public void planYourTripMethod() throws Exception {
	  /*Plan your trip Method
		 */
	  planYourTrip.planYourTripM("Kogarah Station, Kogarah","Kiama Station, Kiama", "18-Apr-2018 (Wed)", "10", "10");
	  driverclass.waitforPageToLoad();
	  /*take ScreenShot 
		 */
	  driverclass.takeSnapShot("/ScreenShot/planYourTrip.png");
	  
	  
  }
  
@AfterMethod
public void afterMethod() throws IOException {		
		/* Close Browser */
	  
	  driverclass.closebrowser();	
		
}


}
