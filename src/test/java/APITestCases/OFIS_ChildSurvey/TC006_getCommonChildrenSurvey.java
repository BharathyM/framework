package APITestCases.OFIS_ChildSurvey;

import org.testng.annotations.BeforeTest;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TC006_getCommonChildrenSurvey extends RESTAssuredBase {

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
	public void getCommonChildrenSurvey() {

		Map<String, String> headers = new HashMap<String, String>();
		RestAssured.useRelaxedHTTPSValidation();
		headers.put("Authorization", TOKEN);
		Response response = getWithHeader(headers,
				"ofischildsurvey/ofischildsurvey/childsurvey/commonsurvey?childId=134&surveyYear=2019");
		reportRequestInJson(response.prettyPrint());
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		verifyResponseCode(response, 200);

	}

}
