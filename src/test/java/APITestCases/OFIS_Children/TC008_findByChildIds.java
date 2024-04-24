package APITestCases.OFIS_Children;

import org.testng.annotations.BeforeTest;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.ms.ui.RestAssuredBase.RESTAssuredBase;

public class TC008_findByChildIds extends RESTAssuredBase {

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
	public void findByChildIds() {

		File file = new File(".//src/test/testdata/OFIS-Children-Services/findByChildIds.json");
		Map<String, String> headers = new HashMap<String, String>();
		RestAssured.useRelaxedHTTPSValidation();
		headers.put("accept", "application/json");
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", TOKEN);
		Response response = postWithBodyAndHeaderParam(headers, file, "ofischild/child/findchildren");
		reportRequestInJson(response.prettyPrint());
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		verifyResponseCode(response, 200);

	}

}
