package APITestCases.OFIS_ChildSurvey;

import org.testng.annotations.BeforeTest;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TC010_save extends RESTAssuredBase {

	@BeforeTest
	public void setValues() {

		testCaseName = getClass().getName();
		testDescription = getClass().getName();
		nodes = getClass().getName();
		authors = "";
		category = "API";
		dataFileName = "";

	}

	@Test(enabled = false)
	public void save() {

		File file = new File(".//src/test/testdata/OFIS-ChildSurvey/save.json");
		Map<String, String> headers = new HashMap<String, String>();
		RestAssured.useRelaxedHTTPSValidation();
		headers.put("Authorization", TOKEN);
		Response response = postWithBodyAndHeaderParam(headers, file, "ofischildsurvey/childsurvey/kafka/failure/save");
		reportRequestInJson(response.prettyPrint());
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		verifyResponseCode(response, 201);

	}

}
