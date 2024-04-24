package com.ms.ui.pages;

import com.aventstack.extentreports.ExtentTest;
import com.ms.ui.base.ProjectSpecificMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Login extends ProjectSpecificMethods {
	public Login(RemoteWebDriver getDriver, ExtentTest test) {

		this.driver = getDriver;
		this.test = test;
	}

	public Login login_Ofi_USer() {
		driver.findElement(By.cssSelector(langProp.getProperty("login_Ofi_User"))).click();
		return this;
	}

	public Login enterUsername(String username) {
		driver.findElement(By.id(langProp.getProperty("username.id"))).sendKeys(username);
		return this;
	}

	public Login enterPassword(String password) {
		driver.findElement(By.id(langProp.getProperty("password.id"))).sendKeys(password);
//		return new LoginPage();
		return this;
	}

	//This is for example - Edit accordingly as per usecase
	public Login clickLogin_Positive() {
		driver.findElement(By.className(langProp.getProperty("login.class"))).click();
		return new Dashboard(driver,test).clickLogout();
	}

	public Login clickLogin_Negative() {
		driver.findElement(By.className(langProp.getProperty("login.class"))).click();
		return this;
	}

	public void verifyDashboard() {
		if (driver.findElement(By.xpath("ana.text")).getText().contains("Analytics")) {
			System.out.println("Dashboard page verified");
		} else {
			System.out.println("Dashboard Page not verified");
		}
	}


}
