package UITestcase;

import com.ms.ui.base.ProjectSpecificMethods;
import com.ms.ui.pages.Login;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC002_RegisterFarmer extends ProjectSpecificMethods {
    @BeforeTest
    public void setData() {
        excelFileName = "tc002";
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
