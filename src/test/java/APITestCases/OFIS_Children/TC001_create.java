package APITestCases.OFIS_Children;

import org.testng.annotations.BeforeTest;
import com.jayway.jsonpath.JsonPath;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TC001_create extends RESTAssuredBase {

	@BeforeTest
	public void setValues() {

		testCaseName = getClass().getName();
		testDescription = getClass().getName();
		nodes = getClass().getName();
		authors = "";
		category = "API";
		dataFileName = "OFIS-Children-Services";
		jsonRequestfilepath = ".//src/test/testdata/OFIS-Children-Services/create.json";
		excelSheetName = "TC001_create";

	}

	@Test(enabled = true)
	public void create() throws IOException {

		File fileone = new File(".//src/test/testdata/OFIS-Children-Services/childResultsFilter.json");
		Map<String, String> headers = new HashMap<String, String>();
		RestAssured.useRelaxedHTTPSValidation();
		headers.put("accept", "application/json");
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", TOKEN);
		headers.put("app-id", "1");
		headers.put("Userscopes",
				"Bulk_Farmer_Activate/Deactivate,edit_survey_for_atsource,view_social_infra_points,edit_farmer_profile_data,download_portal_surveys_regional,edit_infrastructure,Download_Submitted_Module,view_training_pillar,atsource_survey_status,answer_diagnostic_module,view_farmer_management,analysis_tableau,edit_enumerators,create_edit_atsource_survey,edit_metadata,view_fg_overview,Manage_Farmers_Plot,CL_Statistics,edit_questions,configure_multi_stakeholder,view_results_diagnostic_module,send_messages,track_enumerator,Download_CLMRS_data,add_edit_training_pillar,bulk_gpx_upload,download_manual,edit_training_metadata,moderate_ofis_farmer,edit_training_for_atsource,View_Geo_Fence,View_CL_Evidence,Upload_Geo_Fence,view_CL_advanced_statistics,edit_dimensions,send_unapproved_messages,configure_unique_id_type,Bulk_Upload_Farmers,view_fmp,farmer_moderation,farmer_segmentation_analysis,view_transaction,bulk_approve_gpx_upload,local_unit_configuration,view_masked_data,origin_survey,edit_sms,download_portal_surveys_origin,capture_response_atsource_survey,region_survey,manage_enumerator_tasks,view_cl_farmer_profile,Manage_Agrolearn,add_edit_social_infra_points,configure_national_id,Bulk_FG_Sec_PP_Migration,view_national_id,download_enumerator_gps_data,download_polygon_data,CL_action_ticked,approve_messages,edit_gpx,edit_appdata,view_analysis,download_portal_surveys_atsource,view_farmer_overview,download_training_photos,coop_survey,manage_questionnaire,download_data,Download_training_data,edit farmer profile,fdp_settings,manage_diagnostic_module,CL_Management,download_portal_surveys_coop,view_templates_weighting_crop_calendar,edit_underreview,edit_users,manage_fmp,deactivate_farmer,edit_fmp,SAP_Audit_View,view_farmerprofiles,upload_manual,edit_templates_weighting_crop_calendar");
		Response response = postWithBodyAndHeaderParam(headers, fileone, "ofischild/filter/results?pageNo=1&size=50");
		response.prettyPrint();
		String childID = response.jsonPath().getString("content[0].childId");
		System.out.println(childID);

		File filetwo = new File(".//src/test/testdata/OFIS-Children-Services/create.json");
		String requestJsonForCreate = JsonPath.parse(filetwo).set("$.childId", childID).jsonString();
		System.out.println("requestJsonForCreate" + requestJsonForCreate);
		Map<String, String> actionTickHeaders = new HashMap<String, String>();
		RestAssured.useRelaxedHTTPSValidation();
		actionTickHeaders.put("accept", "application/json");
		actionTickHeaders.put("Content-Type", "application/json");
		actionTickHeaders.put("Authorization", TOKEN);
		Response responseForCreate = postWithBodyAndHeaderParam(actionTickHeaders, requestJsonForCreate,
				"ofischild/actiontick/create");
		int statusCode = responseForCreate.getStatusCode();
		reportRequestInJson(responseForCreate.prettyPrint());
		System.out.println(statusCode);
		verifyResponseCode(responseForCreate, 200);

	}

}
