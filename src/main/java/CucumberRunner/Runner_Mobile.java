package CucumberRunner;

import com.aventstack.extentreports.service.ExtentService;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import org.testng.annotations.*;
import wrappers.CommonNativeWrappers;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

@CucumberOptions(features = {"src/main/resources/CucumberFeatures"},
        glue = {"CucumberSteps", "hooks"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty:src\\Reports\\PrettyReport\\STDOUT","html:target/cucumber-reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@Sanity")//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",publish = true,

//
public class Runner_Mobile extends CommonNativeWrappers {//GenericWrappers //MobileProjectSpecificMethods

    static AppiumDriverLocalService server;
    public static Properties mobileLangProp;
    @Parameters({"platformName", "deviceName", "udid", "appPackage", "appActivity", "automationName",
            "chromeDriverPort", "systemPort", "xcodeOrgId", "xcodeSigningId", "bundleId", "app", "mjpegServerPort",
            "wdaLocalPort"})
    @BeforeTest
    public void bm(String platformName, String deviceName, @Optional("") String udid, @Optional("") String appPackage,
                   @Optional("") String appActivity, @Optional("") String automationName,
                   @Optional("") String chromeDriverPort, @Optional("") String systemPort, @Optional("") String xcodeOrgId,
                   @Optional("") String xcodeSigningId, @Optional("") String bundleId, @Optional("") String app,
                   @Optional("") String mjpegServerPort, @Optional("") String wdaLocalPort) throws MalformedURLException, InterruptedException {
        launchApp(platformName, deviceName, udid, appPackage, appActivity, automationName, chromeDriverPort, systemPort,
                xcodeOrgId, xcodeSigningId, bundleId, app, mjpegServerPort, wdaLocalPort);
        //launchAndroidApp();
    }

    @BeforeSuite()
    public void startApp() throws Exception {

        // Read the AppConfig.property to know the browser, url & language to run

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("./config/MobileAppConfig.properties");
        prop.load(file);

        String lang = prop.getProperty("language");

        mobileLangProp = new Properties();
        FileInputStream file1 = new FileInputStream("./config/Mobile" + lang + ".properties");
        mobileLangProp.load(file1);

        //Start server
        startAppium();
    }

    /*@AfterMethod(alwaysRun = true)
    public void am() {
        closeApp();
    }*/

    //Test method for Android app launching
    public void launchAndroidApp() throws MalformedURLException, InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setDeviceName("Galaxy A30");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setCapability("uiautomator2ServerInstallTimeout", 120000);
        options.setApp(System.getProperty("user.dir") + "\\Apks\\UAT-OlamMarkets.apk");

        new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(5000);
        System.out.println("Android app is launched!");
    }

    public void startAppium() {

        String nodePath = null;
        String appiumPath = null;


        // windows path
        nodePath = "C:\\Program Files\\nodejs\\node.exe";
        //appiumPath = "C:\\Users\\bharathy.perumal\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        appiumPath = "C:\\Users\\s.srinivasan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        System.out.println(System.getProperty("user.dir"));

        System.out.println("Starting server");

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File(appiumPath))
                .usingDriverExecutable(new File(nodePath))
                .usingPort(4723)
                .withLogFile(new File("AppiumLog.text"))
                .withIPAddress("127.0.0.1")
                .withArgument(GeneralServerFlag.USE_PLUGINS,"element-wait")
                .withTimeout(Duration.ofSeconds(200));

        server = AppiumDriverLocalService.buildService(builder);


     /*   service = AppiumDriverLocalService
                .buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(nodePath))
                        .usingPort(4723).withAppiumJS(new File(appiumPath)));
                        //.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/"));*/


        server.start();
        System.out.println("Server started");
    }

    @AfterSuite
    public void stopAppium() {
        try {
            getDriver().quit();
            System.out.println("Driver quited");
            server.stop();
            System.out.println("Service stopped");
        }

        catch (Exception e) {
            System.out.println("Appium already stopped");
        }
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Report being generated");
        ExtentService.getInstance().setSystemInfo("User Name", System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("64 Bit", "Windows 10");
        ExtentService.getInstance().setSystemInfo("64 Bit", "Windows 10");
        //ExtentService.getInstance().setTestRunnerOutput("Cucumber TestNG Test Runner");
        System.out.println("Report generation completed");
        System.out.print("Stop service");
    }




}