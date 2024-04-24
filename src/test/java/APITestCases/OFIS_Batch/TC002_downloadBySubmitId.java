package APITestCases.OFIS_Batch;


import org.testng.annotations.BeforeTest;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TC002_downloadBySubmitId extends RESTAssuredBase{
	
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
	    
			    public void downloadBySubmitId() {
	    	        
	    	
			        Map<String, String> headers = new HashMap<String, String>();
			        RestAssured.useRelaxedHTTPSValidation();
			        headers.put("accept", "application/json");
			        headers.put("Content-Type", "application/json");
			        headers.put("Authorization", TOKEN);
			        headers.put("app-id", "1");
			        Response response = getWithHeader(headers, "ofisbatch/batch/csv/downloadBySubmitId/23");
			        int statusCode = response.getStatusCode();
			        reportRequestInJson(response.prettyPrint());
			        System.out.println(statusCode);
			        verifyResponseCode(response, 200);
			    }
	  
	    }


			

