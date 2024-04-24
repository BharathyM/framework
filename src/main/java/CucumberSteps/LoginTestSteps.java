package CucumberSteps;

import com.ms.ui.base.ProjectSpecificMethods;
import com.ms.ui.pages.Domain;
import com.ms.ui.pages.Login;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class LoginTestSteps extends ProjectSpecificMethods {

    Domain domain = new Domain(driver,test);
    Login login = new Login(driver,test);

    @Given("navigates to ofi-direct web application")
    public void navigatesToOfiDirectWebApplication() throws IOException {
        try {
            startApp();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        domain.loadUrl();
        domain.clickDashBoardOFIUSer();
        login.login_Ofi_USer();


    }


 /*   @And("User selects the {string} option radio button")
    public void userSelectsTheOptionRadioButton(String arg0) {
    }

    @And("User enters the username as {string}")
    public void userEntersTheUsernameAs(String arg0) {
    }

    @And("User enters the password as {string}")
    public void userEntersThePasswordAs(String arg0) {
    }

    @When("User clicks the {string} Login button")
    public void userClicksTheLoginButton(String arg0) {
    }

    @Then("Login should be successful and navigates to Dashboard page")
    public void loginShouldBeSuccessfulAndNavigatesToDashboardPage() {
    }

    @And("Now click the sign-out button for successful signout -{string}.")
    public void nowClickTheSignOutButtonForSuccessfulSignout(String arg0) {
    }

    @Then("Check logout is successful.")
    public void checkLogoutIsSuccessful() {
    }

    @Then("Login should be unsuccessful and an {string} message should be displayed")
    public void loginShouldBeUnsuccessfulAndAnMessageShouldBeDisplayed(String arg0) {
    }*/
}
