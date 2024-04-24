package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import wrappers.GenericWrappers;

public class Hooks extends GenericWrappers {
    @AfterStep
    public void afterEachStep(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getId());
        }
    }
}