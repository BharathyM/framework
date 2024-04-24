package com.ms.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UserRegistration_uploadDoc extends UserRegistration_BankDetails {

	public UserRegistration_uploadDoc(RemoteWebDriver getDriver) {
		super(getDriver);
		// TODO Auto-generated constructor stub
	}
	
	//Finally click Next
		public UserRegistration_uploadDoc clickNext() {
			driver.findElement(By.linkText(langProp.getProperty("UserReg.link"))).click();
			return new UserRegistration_CreateID(driver);
		}


}
