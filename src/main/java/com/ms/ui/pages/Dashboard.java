package com.ms.ui.pages;

import com.aventstack.extentreports.ExtentTest;
import com.ms.ui.base.ProjectSpecificMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Dashboard extends ProjectSpecificMethods {
	public Dashboard(RemoteWebDriver getDriver, ExtentTest test) {

		this.driver = getDriver;
		this.test = test;
	}
	public Login clickLogout() {
		driver.findElement(By.className(langProp.getProperty("login.class"))).click();
		return new Login(driver,test);
	}
	public Dashboard clickAnalyticsDashboard() {
		driver.findElement(By.linkText(langProp.getProperty("ana.link"))).click();
		return new Dashboard(driver,test);
	}
	public Dashboard verifyDashboard() {
		if(driver.findElement(By.xpath("ana.text")).getText().contains("Analytics")) {
			System.out.println("Dashboard page verified");
		}
		else{
			System.out.println("Dashboard Page not verified");
		}
		return this;
	}
}
