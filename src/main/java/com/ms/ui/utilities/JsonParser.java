package com.ms.ui.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonParser {

	public static DocumentContext setValue;
	public DocumentContext FinalsetValue;
	public static String jsonString;

	public static String updateRequestDataInJson(Map<String, String> map, String filename) throws IOException {

		File file = new File(filename);
		DocumentContext path = JsonPath.parse(file);
		map.forEach((key, value) -> {
			String jsonPathIntheRequest = key;
			String newValue = value;
			setValue = path.set(jsonPathIntheRequest, newValue);
		});

		return jsonString = setValue.jsonString();
	}

}
