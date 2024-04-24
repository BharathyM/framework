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

public class TC006_getFarmerActiveDeactiveUploadTemplate extends RESTAssuredBase{
	
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
			    public void getFarmerActiveDeactiveUploadTemplate() {
	    	
			        Map<String, String> headers = new HashMap<String, String>();
			        RestAssured.useRelaxedHTTPSValidation();
			        headers.put("Authorization", TOKEN);
			        headers.put("app-id", "1");
			        Response response = getWithHeader(headers, "ofisbusinessdatapatch/bulkupload/farmer/template?activity=1123");
			        reportRequestInJson(response.prettyPrint());
			        int statusCode = response.getStatusCode();
			        System.out.println(statusCode);
			        verifyResponseCode(response, 200);
			        
			    }
	    
	  
	    }


			


