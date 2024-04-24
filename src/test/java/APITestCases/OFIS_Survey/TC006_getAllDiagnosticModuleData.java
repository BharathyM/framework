package APITestCases.OFIS_Survey;

import org.testng.annotations.BeforeTest;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TC006_getAllDiagnosticModuleData extends RESTAssuredBase {

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

	public void getAllDiagnosticModuleData() {
         
		Map<String, String> headers = new HashMap<String, String>();
		RestAssured.useRelaxedHTTPSValidation();
		headers.put("accept", "application/json");
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", TOKEN);
		Response response = getWithHeader(headers,"ofissurvey/survey/diagnosticmodule/getAllDiagnosticModuleData");
		int statusCode = response.getStatusCode();
		reportRequestInJson(response.prettyPrint());
		System.out.println(statusCode);
		verifyResponseCode(response, 200);

	}

}
