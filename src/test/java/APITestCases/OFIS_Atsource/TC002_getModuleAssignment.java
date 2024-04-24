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

public class TC002_getModuleAssignment extends RESTAssuredBase{
	
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
			    public void getModuleAssignment() {
	    	        
		    	
		    	Map<String, String> headers = new HashMap<String, String>();
		        RestAssured.useRelaxedHTTPSValidation();
		        headers.put("Authorization", TOKEN);
		        headers.put("userscopes", "capture_response_atsource_survey");
		        Response response = getWithHeader(headers, "ofisatsource/atsource/assignments/moduleAssignments/2690");
		        reportRequestInJson(response.prettyPrint());
		        int statusCode = response.getStatusCode();
		        System.out.println(statusCode);
		        verifyResponseCode(response, 200);
	        
			        
			    }
	    
	  
	    }


			


