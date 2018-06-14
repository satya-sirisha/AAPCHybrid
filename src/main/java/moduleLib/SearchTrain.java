package moduleLib;

import java.io.IOException;

import driverScript.DriverClass;


public class SearchTrain {
	DriverClass driverclass;
	
	public SearchTrain(DriverClass driverclass){
		this.driverclass=driverclass;
	}
	
	public void searchTrainM(String Line,String Direction,String Day,String Hour,String Minute) throws IOException{
		driverclass.selectbytext("HomepageConstant.line", Line);
		driverclass.selectbytext("HomepageConstant.direction", Direction);
		driverclass.click("HomepageConstant.arrBfr");
		driverclass.selectbytext("HomepageConstant.day",Day);
		driverclass.selectbytext("HomepageConstant.hour",Hour);
		driverclass.selectbytext("HomepageConstant.minute",Minute);
		driverclass.click("HomepageConstant.rememberMe");
		/*  Add Assertion*/
		driverclass.assertTrueMethod("HomepageConstant.viewTable");
		driverclass.click("HomepageConstant.viewTable");

}
}