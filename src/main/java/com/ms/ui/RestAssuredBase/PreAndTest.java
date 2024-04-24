package com.ms.ui.RestAssuredBase;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.ms.ui.utilities.HTMLReporter;
import com.ms.ui.utilities.ReadExcelData;
import io.restassured.RestAssured;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class PreAndTest extends HTMLReporter {

	public static Properties apiprop = new Properties();
	public String dataFileName, jsonRequestfilepath,excelSheetName;
	public static String TOKEN;
	public static String OFI_KEYCLOAK_TOKEN;
	public static String methodName;
	

	//public static String fileName = apiprop.getProperty("ExcelFileName");
	
	@BeforeSuite
	public void beforeSuite() throws IOException {
		startReport();
	

	}
	
	@BeforeTest
	public void beforeTest() {
		TOKEN= RESTAssuredBase.getToken();
		OFI_KEYCLOAK_TOKEN= RESTAssuredBase.getTokenForIndvidualCreds();
	}
	
	
	@BeforeClass
	public void beforeClass() throws IOException {
		startTestCase(testCaseName, testDescription);
	}
	
	
	@BeforeMethod
	public void beforeMethod(Method method) throws FileNotFoundException, IOException {
		//for reports

		methodName = method.getName();
		FileInputStream file = new FileInputStream("./config/ApiInfo.properties");
		apiprop.load(file);
		svcTest = startTestModule(nodes);
		svcTest.assignAuthor(authors);
		svcTest.assignCategory(category);
		//prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
		svcTest.info(method.getName());
		RestAssured.baseURI = apiprop.getProperty("Endpoint");
		//RestAssured.authentication = RestAssured.basic(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
	}
	
	@AfterTest
	public void afterTest() {
		
	}

	@AfterSuite
	public void afterSuite() {
		endResult();
	}

	/*@DataProvider(name="fetchData")
	public  Object[][] getData(){
		if(dataFileType.equalsIgnoreCase("Excel"))
			return DataInputProvider.getSheet(dataFileName);	
		else if(dataFileType.equalsIgnoreCase("JSON")){
			Object[][] data = new Object[1][1];
			data[0][0] = new File("./data/"+dataFileName+"."+dataFileType);
			System.out.println(data[0][0]);
			return data;
		}else {
			return null;
		}
			
	}*/

	@Override
	public long takeSnap() {
		return 0;
	}

	@DataProvider(name = "getDataCred")
	public  Object[][] readDataCred(){
		return ReadExcelData.readData(dataFileName);
	}
	
	
    
}
