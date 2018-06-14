package moduleLib;

import java.io.IOException;

import driverScript.DriverClass;


public class SampleProgram {

	DriverClass driverclass;
	public SampleProgram(DriverClass driverclass) {
	this.driverclass=driverclass;
	}
	public void getCarQuoteMethod(String CarModel,String Year,String Age,String State,String Email) throws IOException {
		driverclass.click("HomepageConstant.getcarquote");
		driverclass.selectbytext("HomepageConstant.make",CarModel);
		driverclass.SendKeys("HomepageConstant.year",Year);
		
		driverclass.SendKeys("HomepageConstant.age", Age);
		driverclass.click("HomepageConstant.female");
		driverclass.selectbytext("HomepageConstant.state",State);
		
		driverclass.SendKeys("HomepageConstant.email", Email);
		
//		driverclass.waitforPageToLoad();
//		//Assert.assertTrue(driverclass.FINDElement("HomepageConstant.getquote").isEnabled());
//		driverclass.waitforPageToLoad();
//		
//		driverclass.click("HomepageConstant.getquote");
//		driverclass.waitforPageToLoad();
//		
		

}
}
