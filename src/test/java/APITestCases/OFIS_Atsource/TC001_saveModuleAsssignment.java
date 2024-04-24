package APITestCases.OFIS_Atsource;

import org.testng.annotations.BeforeTest;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TC001_saveModuleAsssignment extends RESTAssuredBase{
	
			
		 @BeforeTest
		    public void setValues() {
				
				
				  testCaseName = getClass().getName();
				  testDescription = getClass().getName();
				  nodes = getClass().getName();
				  authors = ""; 
				  category = "API"; 
				  dataFileName = "OFIS-Children-Services";
				 
		    } 
			 
	    
	 
	   
	    @Test(enabled = false)
			    public void saveModuleAsssignment() {
	    	        
	    	
	    			File file = new File(".//src/test/testdata/OFIS-Atsource-Service/saveModuleAsssignment.json");
			        Map<String, String> headers = new HashMap<String, String>();
			        RestAssured.useRelaxedHTTPSValidation();
			        headers.put("accept", "application/json");
			        headers.put("Content-Type", "application/json");
			        headers.put("Authorization", OFI_KEYCLOAK_TOKEN);
			        Response response = postWithBodyAndHeaderParam(headers, file, "ofisatsource/atsource/assignments/moduleAssignments/save");
			        int statusCode = response.getStatusCode();
			        reportRequestInJson(response.prettyPrint());
			        System.out.println(statusCode);
			        verifyResponseCode(response, 200);
			        
			    }
	    
	  
	    }


			


