package testcaseLib;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverScript.DriverClass;
import moduleLib.SampleProgram;
import moduleLib.SearchTrain;

public class SearchTrainTest {
	/* TestCae1:
	 * open browser
	 * navigate to URl
	 *  Search train time table table
	 *  select line
	 *  select direction
	 *  select day 
	 *  and so on
	 *  click on viewTables*/
	
	
	DriverClass driverclass;
	SearchTrain searchtrain;
	

	@BeforeMethod
	public void beforemethod() throws IOException {		
		/* Open Browser */
		
		driverclass=new  DriverClass();
		/*Navigate to URL : www.SydneyTrain
		 */
		driverclass.navigateURL();
		searchtrain=new SearchTrain(driverclass); 
		
}
  @Test
  public void searchTrainMethod() throws Exception {
	  /*Search for train time table
		 */
	  searchtrain.searchTrainM("Hunter Line", "Scone or Dungog to Newcastle Interchange", "8-Apr-2018 (Sun)", "10", "10");
	  driverclass.waitforPageToLoad();
	  /*take ScreenShot 
		 */
	  driverclass.takeSnapShot("/ScreenShot/searchtrain.png");
	  
	  
  }
  
@AfterMethod
public void afterMethod() throws IOException {		
		/* Close Browser */
	  
	  driverclass.closebrowser();	
		
}


}
