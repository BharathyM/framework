package com.ms.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UserRegistration_SelectFarmerLead extends UserManagement_PersonalDetails {

	public UserRegistration_SelectFarmerLead(RemoteWebDriver getDriver) {
		super(getDriver);
		// TODO write methods
	}
	
	
	//Finally click Next
	public UserManagement_PersonalDetails clickNext() {
		driver.findElement(By.linkText(langProp.getProperty("UserReg.link"))).click();
		return new UserRegistration_SelectFarmerLead(driver);
	}

}
