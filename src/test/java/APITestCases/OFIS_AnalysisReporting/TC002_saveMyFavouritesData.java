package APITestCases.OFIS_AnalysisReporting;


import org.testng.annotations.BeforeTest;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TC002_saveMyFavouritesData extends RESTAssuredBase{
	
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
	    
			    public void saveMyFavouritesData() {
	    	        
	    	        File file = new File(".//src/test/testdata/OFIS-Analysis-Reporting/saveMyFavouritesData.json");
			        Map<String, String> headers = new HashMap<String, String>();
			        RestAssured.useRelaxedHTTPSValidation();
			        headers.put("accept", "application/json");
			        headers.put("Content-Type", "application/json");
			        headers.put("Authorization", TOKEN);
			        Response response = postWithBodyAndHeaderParam(headers, file, "ofisanalysisreporting/api/v1/reporting/saveMyFavourites");
			        int statusCode = response.getStatusCode();
			        reportRequestInJson(response.prettyPrint());
			        System.out.println(statusCode);
			        verifyResponseCode(response, 200);
			        
			    }
	    
	  
	    }


			

