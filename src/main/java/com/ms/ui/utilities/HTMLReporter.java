package com.ms.ui.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

public abstract class HTMLReporter {

	public static ExtentReports extent;
	public static ExtentTest svcTest;
	public ExtentTest testSuite, test;
	public String testCaseName, testDescription, nodes, authors, category;

	public void startReport() throws IOException {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/result-" + createFileName() + "Spark.html");
		extent.attachReporter(spark);
		spark.loadXMLConfig("./Config/extent-config.xml");
	}

	public ExtentTest startTestCase(String testCaseName, String testDescription) {

		testSuite = extent.createTest(testCaseName, testDescription);
		return testSuite;
	}

	public ExtentTest startTestModule(String nodes) {
		test = testSuite.createNode(nodes);
		return test;
	}

	public void endResult() {
		extent.flush();
	}

	public abstract long takeSnap();

	public void reportStep(String desc, String status, boolean bSnap) throws IOException {
		Media img = null;
		if (bSnap && !status.equalsIgnoreCase("INFO")) {
			long snapNumber = 100000L;
			snapNumber = takeSnap();
			MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/" + snapNumber + ".png").build();
		}

		if (status.equalsIgnoreCase("PASS")) {
			test.pass(desc);
		} else if (status.equalsIgnoreCase("FAIL")) {
			test.fail(desc);
			throw new RuntimeException();
		} else if (status.equalsIgnoreCase("WARNING")) {
			test.warning(desc);
		} else {
			test.info(desc);
		}
	}

	public void reportStep(String desc, String status) throws IOException {
		reportStep(desc, status, true);
	}

	public static void reportRequestInJson(String desc) {
		if (desc.isEmpty() || desc.isBlank()) {
			svcTest.log(Status.WARNING, "The response is empty");
		} else {
			svcTest.log(Status.INFO, MarkupHelper.createCodeBlock(desc, CodeLanguage.JSON));
		}
	}

	public static void reportRequest(String desc, String status) {
		Media img = null;
		if (status.equalsIgnoreCase("PASS")) {
			svcTest.pass(desc);
		} else if (status.equalsIgnoreCase("FAIL")) {
			svcTest.fail(desc);
			throw new RuntimeException();
		} else if (status.equalsIgnoreCase("WARNING")) {
			svcTest.warning(desc);
		} else {
			svcTest.info(desc);
		}
	}

	public static String createFileName() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return format.format(date);
	}

	public static void printRequestURL(String URL) {
		svcTest.log(Status.INFO, URL);
	}

	public static void printRequestBody(File fileName) {

		try {
			String Requestbody = FileUtils.readFileToString((fileName), StandardCharsets.UTF_8);
			svcTest.log(Status.INFO, Requestbody);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void printRequestBody(String jsonString) {

		svcTest.log(Status.INFO, jsonString);
	}
	
	public static void printRequestHeader(Map<String ,String> headers) {

		String convertHeaderToString = headers.toString();
		svcTest.log(Status.INFO, convertHeaderToString);
	}

}