package APITestCases.OFIS_EnumeratorGPSTracker;

import org.testng.annotations.BeforeTest;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TC003_getEnumeratorActivitiesById extends RESTAssuredBase {

	@BeforeTest
	public void setValues(){

		testCaseName = getClass().getName();
		testDescription = getClass().getName();
		nodes = getClass().getName();
		authors = "";
		category = "API";
		dataFileName = "";

	}

	@Test

	public void getEnumeratorActivitiesById(){

		File file = new File(".//src/test/testdata/OFIS-Enumerator-GPS-Tracker/getEnumeratorActivitiesById.json");
		Map<String, String> headers = new HashMap<String, String>();
		RestAssured.useRelaxedHTTPSValidation();
		headers.put("accept", "application/json");
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", TOKEN);
		headers.put("userscopes", "download_enumerator_gps_data");
		Response response = postWithBodyAndHeaderParam(headers,file,"ofisenumeratorgpstracker/gps-tracking/getEnumeratorLatLngById");
		int statusCode = response.getStatusCode();
		reportRequestInJson(response.prettyPrint());
		System.out.println(statusCode);
		verifyResponseCode(response, 200);

	}

}
