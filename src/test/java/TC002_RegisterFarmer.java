import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ms.ui.base.ProjectSpecificMethods;
import com.ms.ui.pages.Login;

public class TC002_RegisterFarmer extends ProjectSpecificMethods {
    /*@BeforeTest
    public void setData() {
        excelFileName = "tc002";
    }*/

    @BeforeTest (alwaysRun = true)

    public void setData() {
        excelFileName = "tc002";
        testCaseName = "login to OFIUSER";
        testDescription = "login to OFI USER";
        nodes = "login";
        authors = "Bharathy";
        category = "ofis";

        // System.out.println(excelData);
    }

    @Test(dataProvider = "getData")
    public void login(String username, String password,String cname, String fname, String lname) {
        Login page = new Login(driver,test);
        page.enterUsername(username)
                .enterPassword(password)
                .clickLogin_Positive()
                .verifyDashboard();
    }
}
