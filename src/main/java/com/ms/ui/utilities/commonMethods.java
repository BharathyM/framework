package com.ms.ui.utilities;

/*
 *
 /* Author : Bharathy Perumal
 * This class contains common methods which can be referred in the
 * tests/class as per need basis
 *
 * */

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class commonMethods {

    public WebDriver driver;
    //Wait for the element to be clickable ignoring the StaleElementReferenceException

    private Duration maxTimeout;
    private static WebElement webElement;

    public boolean waitForElementToBeClickableBool(WebDriver    driver, By attributeValue, Duration waitTime) {
        boolean flag = false;
        try{
            new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(attributeValue));
            flag=true;
            return flag;

        }catch(Exception Ex){
            return flag;
        }
    }
    //Wait for the Alert present ignoring the StaleElementReferenceException

    public boolean waitForAlertPresent(WebDriver driver, Duration waitTime) {
        boolean flag = false;
        new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.alertIsPresent());
        try{
            driver.switchTo().alert();
            return flag = true;
        }catch(Exception Ex){
            return flag;
        }
    }

//Wait for the element to be visible ignoring the StaleElementReferenceException

    /**
     * This method is used to wait for element till visibility of element.
     *
     * @param driver
     * @param attributeValue
     *            - provide locator value of element till it is visible on
     *            application and then click that element.
     * @param waitTime
     *            - provide maximum wait time in seconds for driver
     */
    public boolean waitForElementToBeVisible(WebDriver driver, By attributeValue, Duration waitTime) {
        boolean flag = false;
        try {
            new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(attributeValue));
            flag=true;
            return flag;
        } catch (Exception Ex) {
            return flag;
        }
    }


//Switch to another Frame

    /**
     * This method is to Switch to an iframe
     *
     * @param driver
     * @param attributeValue-This
     *            is the unique attribute of the frame to be switched
     */
    public void switchToFrame(WebDriver driver, By attributeValue ) {
        try {

            if (waitForElementToBePresentBool(driver, attributeValue, maxTimeout)) {
                WebElement iframe =driver.findElement(attributeValue);
                driver.switchTo().frame(iframe);
                System.out.println("Switched to frame");
            } else {
                System.out.println("Frame not found");
            }
        } catch (Exception Ex) {
            System.out.println("Exception occured");
        }
    }

    private boolean waitForElementToBePresentBool(WebDriver driver, By attributeValue, Duration maxTimeout) {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * This method is to Switch to an default iframe
     *
     * @param driver
     * @param attributeValue-This
     *            is the unique attribute of the frame to be switched
     */
    public void switchToDefaultFrame(WebDriver driver) {
        try {
            driver.switchTo().defaultContent();

        } catch (Exception Ex) {
            System.out.println("Exception occured");
        }
    }



//Move to Element and Click Action in Selenium

    public void MouseClickActionMoveToElement(WebDriver driver, By attributeValue) {
        try {

            if (waitForElementToBeClickableBool(driver, attributeValue, maxTimeout)) {
                WebElement element = driver.findElement(attributeValue);
                //element.click();
                Actions builder = new Actions(driver);
                builder.moveToElement(element).click().build().perform();
                System.out.println("Able to locate and click to element !");

            } else {
                System.out.println("Not able to locate the element !");
            }
        } catch (Exception Ex) {
            System.out.println("Exception occured");
        }
    }

//Get text from the element and return as string

    public String getTextFromElement(WebDriver driver, By locator) {
        String text = null;
        try {
            if (waitForElementToBePresentBool(driver, locator, maxTimeout)) {
                WebElement element = driver.findElement(locator);
                text = element.getText();
                System.out.println("Element Text is: "+ text);

            } else {
                System.out.println("Element not present !");

            }
        } catch (Exception Ex) {
            System.out.println("Exception occured");

        }
        return text;
    }

//Get current system time


    /**
     * @Method:getcurrenttime This method is used to return system time in
     *                        seconds.
     */
    public static int getcurrenttime() {
        long currentDateMS = new Date().getTime();
        int seconds = (int) ((currentDateMS / 1000) % 3600);
        return seconds;
    }


//Close all windows except parent

    /**
     * @Method:closeAllOtherWindows - This method is used to close all open
     *                              windows except parent window.
     * @param driver
     * @return
     * @throws InterruptedException
     */
    public static boolean closeAllOtherWindows(WebDriver driver) throws InterruptedException {
        String Parent_Window = driver.getWindowHandle();
        java.util.Set<String> allWindowHandles = driver.getWindowHandles();
        for (String currentWindowHandle : allWindowHandles) {
            if (!currentWindowHandle.equals(Parent_Window)) {
                driver.switchTo().window(currentWindowHandle);
                driver.close();
                Thread.sleep(2000);
            }
        }
        driver.switchTo().window(Parent_Window);
        if (driver.getWindowHandles().size() == 1)
            return true;
        else
            return false;
    }

//Select a value in dropdown by Text

    /**
     * This method is for simple dropdown selection by visibleText
     *
     * @param driver
     * @param dropDownID-This
     *            is the unique attribute to find an dropdownelement
     * @param dropDownValue-This
     *            is the text to search in dropdown
     */
    public static void dropDownSelectionByText(WebDriver driver, By dropDownID, String dropDownValue) {
        try {
            WebElement element = null;
            new WebDriverWait(driver, Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));
            element = driver.findElement(dropDownID);
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(dropDownValue);
        }
        catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
        }
    }


//Select a value in dropdown by Value

    /**
     * This method is for simple dropdown selection by value
     *
     * @param driver
     * @param dropDownID-This
     *            is the unique attribute to find an dropdownelement
     * @param dropDownValue-This
     *            is the text to search in dropdown
     */
    public static void dropDownSelectionByValue(WebDriver driver, By dropDownID, String dropDownValue) {
        try {
            WebElement element = null;
            new WebDriverWait(driver,Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));
            element = driver.findElement(dropDownID);
            Select dropDown = new Select(element);
            dropDown.selectByValue(dropDownValue);
        }
        catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
        }
    }


//Select a value in dropdown by Index


    /**
     * This method is for simple dropdown selection by index
     *
     * @param driver
     * @param dropDownID-This
     *            is the unique attribute to find an dropdownelement
     * @param dropDownValue-This
     *            is the text to search in dropdown
     */
    public static void dropDownSelectionByIndex(WebDriver driver, By dropDownID, int dropDownValue) {
        try {
            WebElement element = null;
            new WebDriverWait(driver,Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));
            element = driver.findElement(dropDownID);
            Select dropDown = new Select(element);
            dropDown.selectByIndex(dropDownValue);
        }
        catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
        }
    }


//Function to wait until Page load is complete

    /**
     * Function to wait until the page loads completely
     *
     * @param timeOutInSeconds
     *            The wait timeout in seconds
     */

    public void waitUntilPageLoaded(long timeOutInSeconds) {
        WebElement oldPage = driver.findElement(By.tagName("html"));

        (new WebDriverWait(driver,Duration.ofSeconds(10))).until(ExpectedConditions.stalenessOf(oldPage));

    }

//Function to wait until the page readyState equals ‘complete’

    /**
     * Function to wait until the page readyState equals 'complete'
     *
     * @param timeOutInSeconds
     *            The wait timeout in seconds
     */

    public void waitUntilPageReadyStateComplete(long timeOutInSeconds) {
        ExpectedCondition<Boolean> pageReadyStateComplete = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        (new WebDriverWait(driver,Duration.ofSeconds(10))).until(pageReadyStateComplete);
    }

//Function to wait until the specified element is located

    /**
     * Function to wait until the specified element is located
     *
     * @param by
     *            The {@link WebDriver} locator used to identify the element
     * @param timeOutInSeconds
     *            The wait timeout in seconds
     */
    public void waitUntilElementLocated(By by, long timeOutInSeconds) {
        (new WebDriverWait(driver,Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

//Function to wait until the specified element is visible

    /**
     * Function to wait until the specified element is visible
     *
     * @param by
     *            The {@link WebDriver} locator used to identify the element
     * @param timeOutInSeconds
     *            The wait timeout in seconds
     */

    public void waitUntilElementVisible(By by, long timeOutInSeconds) {
        (new WebDriverWait(driver,Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

// Function to wait until the specified element is enabled

    /**
     * Function to wait until the specified element is enabled
     *
     * @param by
     *            The {@link WebDriver} locator used to identify the element
     * @param timeOutInSeconds
     *            The wait timeout in seconds
     */

    public void waitUntilElementEnabled(By by, long timeOutInSeconds) {
        (new WebDriverWait(driver,Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(by));
    }


    // Function to wait until the specified element is disabled

    /**
     * Function to wait until the specified element is disabled
     *
     * @param by
     *            The {@link WebDriver} locator used to identify the element
     * @param timeOutInSeconds
     *            The wait timeout in seconds
     */
    public void waitUntilElementDisabled(By by, long timeOutInSeconds) {
        (new WebDriverWait(driver,Duration.ofSeconds(10)))
                .until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));
    }

//Highlighting element before taking screenshot

    /**
     * Function to highlight the element on  current page
     * @param by The {@link WebDriver} locator used to identify the element
     */

    public void highlightElement(WebElement ele) throws InterruptedException{
        try	{
            //Creating JavaScriptExecuter Interface
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            for (int i = 0; i < 1; i++) {
                //Execute java script
                executor.executeScript("arguments[0].style.border='7px groove green'", ele);
                Thread.sleep(200);
                executor.executeScript("arguments[0].style.border=''", ele);
            }
        }	catch (Exception e) {
            System.out.println("Exception - "+e.getMessage());
        }
    }



}