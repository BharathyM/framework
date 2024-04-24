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

public class TC011_getDownloadfilesByUserId extends RESTAssuredBase{
	
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
			    public void getDownloadfilesByUserId() {
	    	
			        Map<String, String> headers = new HashMap<String, String>();
			        RestAssured.useRelaxedHTTPSValidation();
			        headers.put("Authorization", TOKEN);
			        Response response = getWithHeader(headers, "ofisbusinessdatapatch/polygonData/getDownloadfilesByUserId?userId=123459&pageNo=1298&size=50");
			        reportRequestInJson(response.prettyPrint());
			        int statusCode = response.getStatusCode();
			        System.out.println(statusCode);
			        verifyResponseCode(response, 200);
			        
			    }
	    
	  
	    }


			


