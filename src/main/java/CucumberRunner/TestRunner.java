package CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"CucumberSteps"}
        ,features = "src\\main\\resources\\CucumberFeatures\\Login.feature",
        		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
       // ,features = "C:\\Users\\bharathy.perumal\\IdeaProjects\\MS_WebUI_Automation-Multilingual\\src\\main\\resources\\CucumberFeatures\\Login.feature",
        tags = "@Login",
        //plugin = {"pretty","html:target/cucumber.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class TestRunner extends AbstractTestNGCucumberTests {

    /*@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/

}