package APITestCases.OFIS_FarmerDataAsService;

import org.testng.annotations.BeforeTest;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TC011_createFarmer extends RESTAssuredBase {

	@BeforeTest
	public void setValues() {

		testCaseName = getClass().getName();
		testDescription = getClass().getName();
		nodes = getClass().getName();
		authors = "";
		category = "API";
		dataFileName = "";

	}

	@Test

	public void createFarmer() {

		File file = new File(".//src/test/testdata/OFIS-Farmer-Data-As-Service/createFarmer.json");
		Map<String, String> headers = new HashMap<String, String>();
		RestAssured.useRelaxedHTTPSValidation();
		headers.put("accept", "application/json");
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", TOKEN);
		headers.put("app-id", "1");
		Response response = postWithBodyAndHeaderParam(headers,file,"ofisfarmer-data-as-service/farmer/register");
		int statusCode = response.getStatusCode();
		reportRequestInJson(response.prettyPrint());
		System.out.println(statusCode);
		verifyResponseCode(response, 200);

	}

}
