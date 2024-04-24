package APITestCases.OFIS_Children;

import org.testng.annotations.BeforeTest;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;
import com.ms.ui.utilities.ReadExcelData;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TC005_getDetailsByEnumaratorId extends RESTAssuredBase {

	@BeforeTest
	public void setValues() {

		testCaseName = getClass().getName();
		testDescription = getClass().getName();
		nodes = getClass().getName();
		authors = "";
		category = "API";
		dataFileName = "OFIS-Children-Services";
		excelSheetName = "TC005_getDetailsByEnumaratorId";
	}

	@Test
	public void getDetailsByEnumaratorId() {

		Map<String, String> headers = new HashMap<String, String>();
		RestAssured.useRelaxedHTTPSValidation();
		headers.put("Authorization", OFI_KEYCLOAK_TOKEN);
		headers.put("app-id", "1");
		Map<String, String> queryParams = ReadExcelData.updateQueryParamsFromExcel(dataFileName, excelSheetName);
		Response response = getWithHeaderAndQueryParam(headers, "ofischild/child/getdetailsbyenumaratorid",
				queryParams);
		reportRequestInJson(response.prettyPrint());
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		verifyResponseCode(response, 200);

	}
}
