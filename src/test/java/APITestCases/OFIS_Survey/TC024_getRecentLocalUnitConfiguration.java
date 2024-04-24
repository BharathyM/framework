package APITestCases.OFIS_Survey;

import org.testng.annotations.BeforeTest;
import com.ms.ui.RestAssuredBase.RESTAssuredBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TC024_getRecentLocalUnitConfiguration extends RESTAssuredBase {

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

	public void getRecentLocalUnitConfiguration() {
         
		Map<String, String> headers = new HashMap<String, String>();
		RestAssured.useRelaxedHTTPSValidation();
		headers.put("accept", "application/json");
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", TOKEN);
		headers.put("userscopes", "approve_messages,manage_fmp,Bulk_FG_Sec_PP_Migration,edit_fmp,edit farmer profile,SAP_Audit_View,edit_questions,configure_multi_stakeholder,CL_Management,CL_Statistics,configure_national_id,add_edit_social_infra_points,view_farmer_management,Bulk_Farmer_Activate/Deactivate,edit_enumerators,moderate_ofis_farmer,View_Geo_Fence,View_CL_Evidence,create_edit_atsource_survey,edit_metadata,farmer_segmentation_analysis,view_CL_advanced_statistics,Download_training_data,download_manual,view_social_infra_points,edit_appdata,track_enumerator,add_edit_training_pillar,coop_survey,upload_manual,edit_users,view_training_pillar,view_fg_overview,download_data,edit_training_metadata,view_transaction,edit_farmer_profile_data,Download_Submitted_Module,edit_dimensions,view_fmp,view_cl_farmer_profile,Manage_Farmers_Plot,Manage_Agrolearn,edit_gpx,view_templates_weighting_crop_calendar,view_analysis,edit_training_for_atsource,configure_unique_id_type,edit_sms,edit_templates_weighting_crop_calendar,view_masked_data,send_messages,Upload_Geo_Fence,download_polygon_data,download_enumerator_gps_data,deactivate_farmer,fdp_settings,Download_CLMRS_data,manage_enumerator_tasks,view_farmer_overview,CL_action_ticked,send_unapproved_messages,edit_infrastructure,view_farmerprofiles,view_national_id,capture_response_atsource_survey,region_survey,edit_underreview,origin_survey,Bulk_Upload_Farmers,download_portal_surveys_atsource,download_portal_surveys_coop,download_portal_surveys_origin,download_portal_surveys_regional,atsource_survey_status,analysis_tableau,download_farmer_photos_signature,edit_survey_for_atsource,master_data_download_national_ID_Biomet,master_data_download_geographic_data,master_Data_download_FG_PPP,master_data_download_questionnaire_data,answer_diagnostic_module,manage_diagnostic_module,view_results_diagnostic_module,manage_questionnaire,bulk_gpx_upload,bulk_approve_gpx_upload,local_unit_configuration,bulk_farmer_data_download");
		Response response = getWithHeader(headers,"ofissurvey/survey/getRecentLocalUnitConfiguration");
		int statusCode = response.getStatusCode();
		reportRequestInJson(response.prettyPrint());
		System.out.println(statusCode);
		verifyResponseCode(response, 200);

	}
}
