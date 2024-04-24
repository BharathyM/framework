package wrappers;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class GenericWrappers extends IosWebWrappers {

    public AppiumDriverLocalService service;
   // @BeforeSuite
    public void startAppium() {

        String nodePath = null;
        String appiumPath = null;

        // windows path
        nodePath = "C:\\Program Files\\nodejs\\node.exe";
        appiumPath = "C:\\Users\\josephkennedy.e\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        System.out.println(System.getProperty("user.dir"));

        System.out.println("Starting server");
        service = AppiumDriverLocalService
                .buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(nodePath))
                        .usingPort(Integer.valueOf("4723")).withAppiumJS(new File(appiumPath))
                        .withArgument(() -> "--base-path", "/wd/hub/")
                        .withArgument(() -> "--plugins", "images"));
        service.start();
        System.out.println("Server started");
    }

    //@AfterSuite
    public void stopAppium() {
        try {
            service.stop();
            System.out.println("Service stopped");
        }

        catch (Exception e) {
            System.out.println("Appium already stopped");
        }
    }
}
