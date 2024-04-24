package com.ms.ui.pages;

import com.ms.ui.base.ProjectSpecificMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UserManagement_PersonalDetails extends ProjectSpecificMethods {
	public UserManagement_PersonalDetails(RemoteWebDriver getDriver) {
		this.driver = getDriver;
	}

	public UserManagement_PersonalDetails enterFullName(String fname) {
		driver.findElement(By.id("UserReg_FullName")).sendKeys(fname);
		return this;
	}

	public UserManagement_PersonalDetails enterKTPID(String ktpid) {
		driver.findElement(By.id("UserReg_ktpid")).sendKeys(ktpid);
		return this;

	}

	public UserManagement_PersonalDetails SelectTitle(String title) {
		driver.findElement(By.id("UserReg_title")).sendKeys(title);
		return this;

	}

	public UserManagement_PersonalDetails selectktp_exp(String date) {
		driver.findElement(By.id("selectktp_exp")).sendKeys(date);
		return this;
	}
	// Write methods for all information on page
	
	
	//Finally click Next
	public UserManagement_PersonalDetails clickNext() {
		driver.findElement(By.linkText(langProp.getProperty("UserReg.link"))).click();
		return new UserRegistration_SelectFarmerLead(driver);
	}
}
