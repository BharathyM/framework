package APITestCases.OFIS_ChildSurvey;

import org.testng.annotations.BeforeTest;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TC005_findSubmittedModulesByChildIdList extends RESTAssuredBase {

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
	public void getAllSubmittedmodules() {

		File file = new File(".//src/test/testdata/OFIS-ChildSurvey/findSubmittedModulesByChildIdList.json");
		Map<String, String> headers = new HashMap<String, String>();
		RestAssured.useRelaxedHTTPSValidation();
		headers.put("Authorization", TOKEN);
		Response response = postWithBodyAndHeaderParam(headers, file,
				"https://otofis-sit-manna-zuul.olamdigital.com/ofischildsurvey/ofischildsurvey/findsubmittedmodulesbychildids?surveyYear=2019");
		reportRequestInJson(response.prettyPrint());
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		verifyResponseCode(response, 200);

	}

}
