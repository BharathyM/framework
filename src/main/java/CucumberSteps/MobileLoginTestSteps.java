package CucumberSteps;

import com.ms.ui.base.ProjectSpecificMethods;
import com.ms.ui.pages.Domain;
import com.ms.ui.pages.Login;
import com.ms.ui.pages.MobileLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import wrappers.GenericWrappers;

import java.io.IOException;

public class MobileLoginTestSteps extends GenericWrappers {


    @Given("customer launches mobile app")
    public void customer_launches_mobile_app() {

       //  launchAndroidApp();
        //System.out.println(System.getProperty("user.dir") + "./Apks/UAT-OlamMarkets.apk");
        System.out.println("App is launched!");

    }

    @When("^Enter the UserID and Password \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" $")
    public void enter_the_userid_and_password(String userid, String password,String country, String logintype) throws Throwable {
        new MobileLoginPage().enterUserIDPassword(userid, password, country, logintype);
    }

    @When("Enter the UserID and Password {string}{string}{string}{string}")
    public void enterTheUserIDAndPassword(String userid, String password,String country, String logintype) throws IOException {
        new MobileLoginPage().enterUserIDPassword(userid, password, country, logintype);
    }


}
