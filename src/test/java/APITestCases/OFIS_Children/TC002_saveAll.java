package APITestCases.OFIS_Children;

import org.testng.annotations.BeforeTest;

import com.ms.ui.RestAssuredBase.RESTAssuredBase;
import com.ms.ui.utilities.ReadExcelData;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TC002_saveAll extends RESTAssuredBase {

	@BeforeTest
	public void setValues() {

		testCaseName = getClass().getName();
		testDescription = getClass().getName();
		nodes = getClass().getName();
		authors = "";
		category = "API";
		dataFileName = "OFIS-Children-Services";
		jsonRequestfilepath = ".//src/test/testdata/OFIS-Children-Services/saveAll.json";
		excelSheetName = "TC002_saveAll";

	}

	@Test 
	public void saveAll() throws IOException {

		String request = ReadExcelData.updateRequestData(dataFileName, excelSheetName, jsonRequestfilepath);
		Map<String, String> headers = new HashMap<String, String>();
		RestAssured.useRelaxedHTTPSValidation();
		headers.put("accept", "application/json");
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", OFI_KEYCLOAK_TOKEN);
		headers.put("app-id", "1");
		Response response = postWithBodyAndHeaderParam(headers, request, "ofischild/child/saveall");
		reportRequestInJson(response.prettyPrint());
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		verifyResponseCode(response, 200);

	}

}
