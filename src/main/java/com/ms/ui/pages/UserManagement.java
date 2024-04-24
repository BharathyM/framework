package com.ms.ui.pages;

import com.aventstack.extentreports.ExtentTest;
import com.ms.ui.base.ProjectSpecificMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UserManagement extends ProjectSpecificMethods {
	public UserManagement(RemoteWebDriver getDriver, ExtentTest test) {
		this.driver = getDriver;
	}
	
	
	//write methods to handle page navigation here
	
	//Finally click next
	public UserManagement_PersonalDetails clickFramerRegistration() {
		driver.findElement(By.linkText(langProp.getProperty("FarmerReg.link"))).click();
		return new UserManagement_PersonalDetails(driver);
	}
}
