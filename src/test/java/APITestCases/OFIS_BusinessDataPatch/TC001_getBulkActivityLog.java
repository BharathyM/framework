package APITestCases.OFIS_BusinessDataPatch;

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

public class TC001_getBulkActivityLog extends RESTAssuredBase{
	
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
			    public void getBulkActivityLog () {
	    	        
	    	
	    			File file = new File(".//src/test/testdata/OFIS-BusinessDataPatch-Service/getBulkActivityLog.json");
			        Map<String, String> headers = new HashMap<String, String>();
			        RestAssured.useRelaxedHTTPSValidation();
			        headers.put("accept", "application/json");
			        headers.put("Content-Type", "application/json");
			        headers.put("Authorization", TOKEN);
			        headers.put("app-id", "1");
			        headers.put("cl-fetch-operatingunit", "OFI");
			        Response response = postWithBodyAndHeaderParam(headers, file, "ofisbusinessdatapatch/bulkupload/activitylog");
			        int statusCode = response.getStatusCode();
			        reportRequestInJson(response.prettyPrint());
			        System.out.println(statusCode);
			        verifyResponseCode(response, 200);
			        
			    }
	    
	  
	    }


			


