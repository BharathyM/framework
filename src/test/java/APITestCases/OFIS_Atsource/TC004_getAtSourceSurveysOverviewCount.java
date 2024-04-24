package APITestCases.OFIS_Atsource;

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

public class TC004_getAtSourceSurveysOverviewCount extends RESTAssuredBase{
	
	 @BeforeTest
	    public void setValues() {
			

		  testCaseName = getClass().getName();
		  testDescription = getClass().getName();
		  nodes = getClass().getName();
		  authors = ""; 
		  category = "API"; 
		  dataFileName = "OFIS-Children-Services";
			 
	    }
	 
	   
	    @Test
			    public void getAtSourceSurveysOverviewCount() {
	    	        
	    	
	    			File file = new File(".//src/test/testdata/OFIS-Atsource-Service/getAtSourceSurveysOverviewCount.json");
			        Map<String, String> headers = new HashMap<String, String>();
			        RestAssured.useRelaxedHTTPSValidation();
			        headers.put("accept", "application/json");
			        headers.put("Content-Type", "application/json");
			        headers.put("Authorization", TOKEN);
			        Response response = postWithBodyAndHeaderParam(headers, file, "ofisatsource/atsource/overview/getAllSurveysCount");
			        int statusCode = response.getStatusCode();
			        reportRequestInJson(response.prettyPrint());
			        System.out.println(statusCode);
			        verifyResponseCode(response, 200);
			        
			    }
	    
	  
	    }


			


