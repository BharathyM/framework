package com.ms.ui.pages;

import com.aventstack.extentreports.ExtentTest;
import com.ms.ui.base.ProjectSpecificMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class Domain extends ProjectSpecificMethods {
    public Domain(RemoteWebDriver getDriver, ExtentTest test) {

        this.driver = getDriver;
        this.test = test;
    }

    public Domain loadUrl(){
        driver.get(langProp.getProperty("url"));
        return this;
    }
     public Domain clickDashBoardOFIUSer() throws IOException {


        try {

            driver.findElement(By.xpath(langProp.getProperty("domain.class"))).click();

            reportStep("OFIUser dashboard clicked Success","pass");

        }

        catch (Exception e) {

            try {
                reportStep("unable to click OFI user " +e,"FAIL",true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

        return this;

    }

}
