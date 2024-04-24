package com.ms.ui.base;

import com.ms.ui.utilities.HTMLReporter;
import com.ms.ui.utilities.ReadExcelData;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MobileProjectSpecificMethods extends HTMLReporter {

    public String excelFileName;
    public AppiumDriver driver;
    public static Properties mobileLangProp;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        startReport();
    }
    @BeforeClass
    public void beforeClass(){
        startTestCase(testCaseName, testDescription);
    }
    @BeforeMethod
    public void startApp() throws Exception {
        //Reports
        svcTest = startTestModule(nodes);
        svcTest.assignAuthor(authors);
        svcTest.assignCategory(category);

        // Read the AppConfig.property to know the browser, url & language to run

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("./config/MobileAppConfig.properties");
        prop.load(file);

        String lang = prop.getProperty("language");

        mobileLangProp = new Properties();
        FileInputStream file1 = new FileInputStream("./config/Mobile" + lang + ".properties");
        mobileLangProp.load(file1);
    }

    @AfterMethod
    public void closeApp() {
        driver.quit();
    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return ReadExcelData.readData(excelFileName);
    }

    @Override
    public long takeSnap() {
        long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
        try {
            FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".png"));
        } catch (WebDriverException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return number;
    }
    @AfterSuite
    public void afterSuite() {
        endResult();
    }
}


