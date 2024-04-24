package UITestcase;

import com.ms.ui.base.ProjectSpecificMethods;
import com.ms.ui.pages.Domain;
import com.ms.ui.pages.Login;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC001_Login extends ProjectSpecificMethods {

   @BeforeTest (alwaysRun = true)

    public void setData() {
       excelFileName = "tc001";
       testCaseName = "login to OFIUSER";
       testDescription = "login to OFI USER";
       nodes = "login";
       authors = "Bharathy";
       category = "ofis";

        // System.out.println(excelData);
    }

    @Test (dataProvider = "getData",groups = {"sanity"})
    public void login(String username, String password) {
        Login page = new Login(driver,test);
        Domain domain=new Domain(driver,test);
        try {
            domain.clickDashBoardOFIUSer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        page.login_Ofi_USer();
    }

    @AfterTest
    public void methodName() {
        closeApp();

    }
}
