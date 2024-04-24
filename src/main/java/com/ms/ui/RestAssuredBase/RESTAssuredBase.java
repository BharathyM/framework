package com.ms.ui.RestAssuredBase;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import org.json.JSONObject;

import com.aventstack.extentreports.Status;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class RESTAssuredBase extends PreAndTest {

	public static RequestSpecification setLogs() {
		return RestAssured.given().log().all().contentType(getContentType());
	}

	public static RequestSpecification setLogsWithoutContentType() {
		return RestAssured.given().log().all();
	}

	public static Response get(String URL) {
		return setLogs().when().get(URL);
	}

	public static Response get() {
		return setLogs().get();
	}

	public static Response getWithHeader(Map<String, String> headers, String URL) {
		printRequestURL(RestAssured.baseURI + URL);
		 

		return setLogs().when().headers(headers).get(URL);
	}

	public static Response getWithHeaderAndQueryParam(Map<String, String> headers, String URL,
			Map<String, String> queryParams) {
		printRequestURL(RestAssured.baseURI + URL);
		// 

		return setLogs().queryParams(queryParams).when().headers(headers).get(URL);
	}

	public static Response getToken(String URL) {

		return setLogsWithoutContentType().when()
				.config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.encodeContentTypeAs("application/x-www-form-urlencoded", ContentType.URLENC)))
				.formParam("grant_type", "password").formParam("username", "ofi@gmail.com")
				.formParam("password", "Olam@123").formParam("client_id", "ofis-portal-sit")
				.formParam("client_secret", "7ae7828e-5802-49fe-aa40-1bf007fe7c38").post(URL);

	}

	public static Response getTokenForIndvidualCreds(String URL, String UserName, String Password, String client_id,
			String client_secret) {

		return setLogsWithoutContentType().when()
				.config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.encodeContentTypeAs("application/x-www-form-urlencoded", ContentType.URLENC)))
				.formParam("grant_type", "password").formParam("username", UserName).formParam("password", Password)
				.formParam("client_id", client_id).formParam("scope", "offline_access")
				.formParam("client_secret", client_secret).post(URL);

	}

	public static Response getTokenForIndvidualCreds(String URL, String UserName, String Password) {

		return setLogsWithoutContentType().when()
				.config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.encodeContentTypeAs("application/x-www-form-urlencoded", ContentType.URLENC)))
				.formParam("grant_type", "password").formParam("username", UserName).formParam("password", Password)
				.formParam("client_id", "od-vega-uat").formParam("scope", "offline_access")
				.formParam("client_secret", "c61923ad-fc26-4d37-8963-58c2ae31f065").post(URL);

	}

	public static Response post() {

		return setLogs().post();
	}

	public static Response post(String URL) {
		setLogs().post(URL).then().log().all();

		return setLogs().post(URL);
	}

	public static Response postWithBodyAsFile(File bodyFile) {

		return setLogs().body(bodyFile).post();
	}

	public static Response postWithBodyAsFileAndUrl(File bodyFile, String URL) {
		printRequestURL(RestAssured.baseURI + URL);

		return setLogs().body(bodyFile).post(URL);
	}

	public static Response postWithHeaderAndForm(Map<String, String> headers, JSONObject jsonObject, String URL) {
		printRequestURL(RestAssured.baseURI + URL);
		return setLogs().headers(headers).body(jsonObject).post(URL);
	}

	public static Response postWithJsonAsBody(String jsonObject, String URL) {
		printRequestURL(RestAssured.baseURI + URL);

		return setLogs().body(jsonObject).post(URL);
	}

	public static Response postWithHeaderAndJsonBody(Map<String, String> headers, String jsonObject, String URL) {

		return setLogs().when().headers(headers).body(jsonObject).post(URL);
	}

	public static Response postWithHeaderParam(Map<String, String> headers, String URL) {

		printRequestURL(RestAssured.baseURI + URL);
		 

		return setLogs().when().headers(headers).post(URL);
	}

	public static Response postWithBodyAndHeaderParam(Map<String, String> headers, File bodyFile, String URL) {

		printRequestURL(RestAssured.baseURI + URL);
		printRequestBody(bodyFile);
		printRequestHeader(headers);
		 

		return setLogs().when().headers(headers).body(bodyFile).post(URL);

	}

	public static Response postWithBodyAndHeaderParam(Map<String, String> headers, String JsonString, String URL) {
		
		printRequestHeader(headers);
		printRequestURL(RestAssured.baseURI + URL);
		printRequestBody(JsonString);
		 

		return setLogs().when().headers(headers).body(JsonString).post(URL);
	}

	public static Response postWithBodyAndHeaderAndQueryParam(Map<String, String> headers, String JsonString,
			String URL, Map<String, String> queryParams) {

		printRequestURL(RestAssured.baseURI + URL);
		printRequestBody(JsonString);
		 

		return setLogs().queryParams(queryParams).when().headers(headers).body(JsonString).post(URL);
	}

	public static Response delete(String URL) {
		return setLogs().when().delete(URL);
	}

	public static Response deleteWithHeaderAndPathParam(Map<String, String> headers, JSONObject jsonObject,
			String URL) {

		return setLogs().when().headers(headers).body(jsonObject).delete(URL);
	}

	public static Response deleteWithHeaderAndPathParamWithoutRequestBody(Map<String, String> headers, String URL)
			throws Exception {
		return setLogs().when().headers(headers).delete(URL);
	}

	public static Response putWithHeaderAndBodyParam(Map<String, String> headers, JSONObject jsonObject, String URL) {

		return RestAssured.given().headers(headers).contentType(getContentType()).request().body(jsonObject).when()
				.put(URL);
	}

	public static Response putWithHeaderAndBodyParam(Map<String, String> headers, File bodyfile, String URL) {
		printRequestURL(RestAssured.baseURI + URL);
		printRequestBody(bodyfile);
		printRequestHeader(headers);
		
		return RestAssured.given().headers(headers).contentType(getContentType()).request().body(bodyfile).when()
				.put(URL);
	}

	public static Response putWithHeader(Map<String, String> headers, String URL) {

		return RestAssured.given().headers(headers).contentType(getContentType()).when().put(URL);
	}

	public static ValidatableResponse enableResponseLog(Response response) {
		return response.then().log().all();
	}

	private static ContentType getContentType() {
		return ContentType.JSON;
	}

	public static void verifyContentType(Response response, String type) {
		if (response.getContentType().toLowerCase().contains(type.toLowerCase())) {
			reportRequest("The Content type " + type + " matches the expected content type", "PASS");
		} else {
			reportRequest("The Content type " + type + " does not match the expected content type "
					+ response.getContentType(), "FAIL");
		}
	}

	public static void verifyResponseCode(Response response, int code) {
		if (response.statusCode() == code) {
			reportRequest("The status code " + code + " matches the expected code", "PASS");
		} else {
			reportRequest("The status code " + code + " does not match the expected code" + response.statusCode(),
					"FAIL");
		}
	}

	public static void verifyResponseTime(Response response, long time) {
		if (response.time() <= time) {
			reportRequest("The time taken " + response.time() + " with in the expected time", "PASS");
		} else {
			reportRequest("The time taken " + response.time() + " is greater than expected SLA time " + time,
					"WARNING");
		}
	}

	public static void verifyContentWithKey(Response response, String key, String expVal) {
		if (response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			String actValue = jsonPath.get(key);
			if (actValue.equalsIgnoreCase(expVal)) {
				reportRequest("The JSON response has value " + expVal + " as expected. ", "PASS");
			} else {
				reportRequest(
						"The JSON response :" + actValue + " does not have the value " + expVal + " as expected. ",
						"FAIL");
			}
		}
	}

	public static void verifyContentsWithKey(Response response, String key, String expVal) {
		if (response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			List<String> actValue = jsonPath.getList(key);
			if (actValue.get(0).equalsIgnoreCase(expVal)) {
				reportRequest("The JSON response has value " + expVal + " as expected. ", "PASS");
			} else {
				reportRequest(
						"The JSON response :" + actValue + " does not have the value " + expVal + " as expected. ",
						"FAIL");
			}
		}
	}

	public static List<String> getContentsWithKey(Response response, String key) {
		if (response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			return jsonPath.getList(key);
		} else {
			return null;
		}
	}

	public static String getContentWithKey(Response response, String key) {
		if (response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			return (String) jsonPath.get(key);
		} else {
			return null;
		}
	}

	public static RequestSpecification contentTypeInForm() {
		return RestAssured.given().contentType("application/x-www-form-urlencoded; charset=utf-8");

	}

	public static String getToken() {

		Response withBodyURLENC = getToken(
				"https://digitalauthdev.olamnet.com/auth/realms/ofis-dse-manna-sit/protocol/openid-connect/token");
		int statusCode = withBodyURLENC.getStatusCode();
		JsonPath jsonPath = withBodyURLENC.jsonPath();
		String accessToken = jsonPath.get("access_token");
		return "Bearer " + accessToken;
	}

	public static String getTokenForIndvidualCreds() {

		Response withBodyURLENC = getTokenForIndvidualCreds(
				"https://digitalauthdev.olamnet.com/auth/realms/ofis-dse-manna-sit/protocol/openid-connect/token",
				"444778", "YLPMm", "ofi-ofis-mobile-sit", "e6e3d814-c600-4149-a240-54066cb0926a");
		int statusCode = withBodyURLENC.getStatusCode();
		JsonPath jsonPath = withBodyURLENC.jsonPath();
		String accessToken = jsonPath.get("access_token");
		return "Bearer " + accessToken;
	}

	public static void verifyListOfString(List<String> expected, List<String> actual) {
		if (expected.equals(actual)) {
			reportRequest("The objects expected ->" + expected + "and actual -> " + actual + "are same", "PASS");
		} else {
			reportRequest("The objects expected ->" + expected + "and actual -> " + actual + "are not same", "FAIL");
		}
	}

}
