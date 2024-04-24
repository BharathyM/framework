package com.ms.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UserRegistration_BankDetails extends UserRegistration_FarmerAddress {

	public UserRegistration_BankDetails(RemoteWebDriver getDriver) {
		super(getDriver);
		// TODO write methods
	}
	
	//Write required methods
	
		//Finally click Next
		
		public UserRegistration_BankDetails clickNext() {
			driver.findElement(By.linkText(langProp.getProperty("UserReg.link"))).click();
			return new UserRegistration_uploadDoc(driver);
		}

}
