package com.ms.ui.base;

import com.ms.ui.utilities.HTMLReporter;
import com.ms.ui.utilities.ReadExcelData;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

public class ProjectSpecificMethods extends HTMLReporter {

    public String excelFileName;
    public RemoteWebDriver driver;
    public static Properties langProp;

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
        FileInputStream file = new FileInputStream("./config/AppConfig.properties");
        prop.load(file);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        /*/
        disable chrome security
         */
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        //options.addExtensions(new File("./Config/Windows-Accounts.crx"));
        // options.addExtensions(new File("C:\\Users\\abubakersiddiq.m\\webFramework\\extender\\Windows-Accounts.crx"));
        // options.addExtensions(new File("D:\\OneDrive - Olam International\\Documents\\extendsCRX\\Windows-Accounts.crx"));


        //if (prop.getProperty("browser").equalsIgnoreCase("headless chrome")) {
            //options.setHeadless(true);
           // driver = new ChromeDriver(options);}

        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    ".\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe");

            //System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            driver = new ChromeDriver(options);

        } else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        String lang = prop.getProperty("language");

        langProp = new Properties();
        FileInputStream file1 = new FileInputStream("./config/" + lang + ".properties");
        langProp.load(file1);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }
    @AfterSuite
    public void afterSuite() {
        endResult();
    }
}


