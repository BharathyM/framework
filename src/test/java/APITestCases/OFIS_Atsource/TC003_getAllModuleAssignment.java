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

public class TC003_getAllModuleAssignment extends RESTAssuredBase{
	
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
			    public void getAllModuleAssignment() {
			        
		    	
		    	Map<String, String> headers = new HashMap<String, String>();
		        RestAssured.useRelaxedHTTPSValidation();
		        headers.put("Authorization", TOKEN);
		        Response response = getWithHeader(headers, "ofisatsource/atsource/assignments/moduleassignments/all");
		        reportRequestInJson(response.prettyPrint());
		        int statusCode = response.getStatusCode();
		        System.out.println(statusCode);
		        verifyResponseCode(response, 200);
		    
			        
			    }
	    
	  
	    }


			


