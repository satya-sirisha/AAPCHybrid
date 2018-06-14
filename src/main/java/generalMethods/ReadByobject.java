package generalMethods;

import org.openqa.selenium.By;



public class ReadByobject {
	static By by;
	public static By getbyproperty(String BykeyValue) {
		String s=Fileutility.getdesiredproperty(BykeyValue);
		String byattribute=s.split(";")[0];
		String byvalue=s.split(";")[1];
		switch(byattribute.toUpperCase()) {
		case "ID":
			by=By.id(byvalue);
		break;
		case "NAME":
			by=By.name(byvalue);
			break;
		case "XPATH":
			by=By.xpath(byvalue);
			break;
		}
		return by;
	}

}
