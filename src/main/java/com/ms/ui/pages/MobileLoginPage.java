package com.ms.ui.pages;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.By;
import org.testng.Assert;
import wrappers.CommonNativeWrappers;

import java.io.IOException;

import static CucumberRunner.Runner_Mobile.mobileLangProp;

public class MobileLoginPage extends CommonNativeWrappers{// MobileProjectSpecificMethods
    public static String inputCountry;
    public void enterUserIDPassword(String userName, String password, String country, String logintype) throws IOException {

        inputCountry = country;
        System.out.println("country is "+ country);
        cancelAppUpdatePopUp();

        // Select the country for each login
        selectCountry(country);

        enterEmailOrMobile(userName);

        enterPassword( password);
        add_Log_With_ScreenShot("Login screen");
        clickLoginButton();
        ExtentCucumberAdapter.addTestStepLog("login button is clicked");
        sleep(10000);

        if (logintype.equals("invalid")) {
            String invalidMessage = getInvalidMessage();
            Assert.assertEquals(invalidMessage, "Invalid username or password");
            add_Log_With_ScreenShot("invalid login");
        } else {
            add_Log_With_ScreenShot("Valid login");
        }

        //throw new RuntimeException("throwing exception for testing failure scenarios!");

    }

    public void selectCountry(String country){

        System.out.println("code reached");
        System.out.println("Xpath of select country: "+mobileLangProp.getProperty("selectCountry.xpath"));
        click(getDriver().findElement(By.xpath(mobileLangProp.getProperty("selectCountry.xpath"))) );//selectCountry
        selectElementUsingText(country).click();
        click(getDriver().findElement(By.xpath(mobileLangProp.getProperty("okButton.xpath"))) );

    }

    public void enterEmailOrMobile(String emailOrMobile){

        click(getDriver().findElements(By.xpath(mobileLangProp.getProperty("email.xpath"))).get(0));
        enterValue(getDriver().findElements(By.xpath(mobileLangProp.getProperty("email.xpath"))).get(0), emailOrMobile);
        sleep(3000);

    }

    public void enterPassword(String password){

        click(getDriver().findElements(By.xpath(mobileLangProp.getProperty("password.xpath"))).get(0));
        enterValue(getDriver().findElements(By.xpath(mobileLangProp.getProperty("password.xpath"))).get(0), password);
        sleep(3000);

    }

    public void clickLoginButton(){

        click(getDriver().findElement(By.xpath(mobileLangProp.getProperty("loginButton.xpath"))) );

    }

    public String getInvalidMessage(){

        String message = "";
        try{
            message = getText(getDriver().findElement(By.xpath(mobileLangProp.getProperty("invalidMessage.xpath"))));
        }catch(Exception e){
            //
        }
        return message;
    }

    public void cancelAppUpdatePopUp() {//cancelPopUp.xpatheleIsDisplayed
        try {
            boolean isPopUpDispplayed = eleIsDisplayed(getDriver().findElement(By.xpath(mobileLangProp.getProperty("cancelPopUp.xpath"))));
            System.out.println("boolean value"+ isPopUpDispplayed);
            if(eleIsDisplayed(getDriver().findElement(By.xpath(mobileLangProp.getProperty("cancelPopUp.xpath")))) == true) {
                click(getDriver().findElement(By.xpath(mobileLangProp.getProperty("cancelPopUp.xpath"))) );
                System.out.println("Pass:Cancel popup is displayed");
            }
        } catch (Exception e) {
            System.out.println("Pass:Cancel popup is not displayed");
            System.err.println("==============="+ e);
        }

    }

}
