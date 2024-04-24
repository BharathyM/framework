package APITestCases.OFIS_Atsource;

	
	import org.testng.annotations.BeforeTest;
	import com.ms.ui.RestAssuredBase.RESTAssuredBase;

	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	import org.testng.annotations.Test;

	import java.io.File;
	import java.util.HashMap;
	import java.util.Map;

public class  TC015_getAllFarmerGroupsByKmId extends RESTAssuredBase{
		
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
				    public void getAllFarmerGroupsByKmId () {
		    	        
			    	
			    	Map<String, String> headers = new HashMap<String, String>();
			        RestAssured.useRelaxedHTTPSValidation();
			        headers.put("Authorization", TOKEN);
			        headers.put("app-id", "1");
			        Response response = getWithHeader(headers, "ofisatsource/atsource/reviews/getAllFarmerGroupsByKmId?kmId=KM-71&type=1");
			        reportRequestInJson(response.prettyPrint());
			        int statusCode = response.getStatusCode();
			        System.out.println(statusCode);
			        verifyResponseCode(response, 200);
		        
				        
				    }
		    
		  
		    }


