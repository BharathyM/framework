package MobileTestcase;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import wrappers.GenericWrappers;

@CucumberOptions(features = {"src/main/resources/CucumberFeatures"},
        glue = {"src.main.java.CucumberSteps", "src.main.java.hooks"},
        monochrome = true,
        publish = true,
        snippets = SnippetType.CAMELCASE,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@Sanity")//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

public class Runner_001 extends GenericWrappers {


    @Parameters({"platformName", "deviceName", "udid", "appPackage", "appActivity", "automationName",
            "chromeDriverPort", "systemPort", "xcodeOrgId", "xcodeSigningId", "bundleId", "app", "mjpegServerPort",
            "wdaLocalPort"})
    @BeforeMethod
    public void bm(String platformName, String deviceName, @Optional("") String udid, @Optional("") String appPackage,
                   @Optional("") String appActivity, @Optional("") String automationName,
                   @Optional("") String chromeDriverPort, @Optional("") String systemPort, @Optional("") String xcodeOrgId,
                   @Optional("") String xcodeSigningId, @Optional("") String bundleId, @Optional("") String app,
                   @Optional("") String mjpegServerPort, @Optional("") String wdaLocalPort) {
        launchApp(platformName, deviceName, udid, appPackage, appActivity, automationName, chromeDriverPort, systemPort,
                xcodeOrgId, xcodeSigningId, bundleId, app, mjpegServerPort, wdaLocalPort);
    }

    @AfterMethod(alwaysRun = true)
    public void am() {
        closeApp();
    }




}