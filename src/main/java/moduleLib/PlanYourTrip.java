package moduleLib;

import java.io.IOException;

import driverScript.DriverClass;

public class PlanYourTrip {
	
DriverClass driverclass;
	
	public PlanYourTrip(DriverClass driverclass){
		this.driverclass=driverclass;
	}
	
	public void planYourTripM(String From,String To,String Day,String Hour,String Minute) throws IOException{
		DriverClass.SendKeys("PlanYourTrip.from", From);
		DriverClass.SendKeys("PlanYourTrip.to", To);
		DriverClass.click("PlanYourTrip.arriveBfr");
		DriverClass.selectbytext("PlanYourTrip.day",Day);
		DriverClass.selectbytext("PlanYourTrip.hour",Hour);
		DriverClass.selectbytext("PlanYourTrip.minute",Minute);
		DriverClass.click("PlanYourTrip.remember");
		/*  Add Assertion*/
		DriverClass.assertTrueMethod("PlanYourTrip.viewTrip");
		
		DriverClass.click("PlanYourTrip.viewTrip");

}

}
