package com.ms.ui.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ms.ui.RestAssuredBase.PreAndTest;

import java.io.IOException;
import java.util.HashMap;

public class ReadExcelData extends PreAndTest {

	public static Object[][] readData(String excelFileName) {
		try {
			XSSFWorkbook book = new XSSFWorkbook(".\\src\\test\\testdata\\" + excelFileName + ".xlsx");
			XSSFSheet sheet = book.getSheetAt(0);
			// Getting row count and column count for iteration
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();

			// Creating 2D array to return data to the @DataProvider
			Object[][] array = new Object[rowCount][colCount];

			// Iteration Part
			for (int i = 1; i <= rowCount; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < colCount; j++) {
					XSSFCell cell = row.getCell(j);
					String data = cell.getStringCellValue();
					array[i - 1][j] = data;
				}
			}
			book.close();
			return array;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object[][] readDataCred(String excelFileName) {
		try {
			XSSFWorkbook book = new XSSFWorkbook(".\\src\\test\\testdata\\" + excelFileName + ".xlsx");
			XSSFSheet sheet = book.getSheetAt(0);
			// Getting row count and column count for iteration
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();

			// Creating 2D array to return data to the @DataProvider
			Object[][] array = new Object[rowCount][colCount];

			// Iteration Part
			for (int i = 1; i <= rowCount; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < colCount; j++) {
					XSSFCell cell = row.getCell(j);
					String data = cell.getStringCellValue();
					array[i - 1][j] = data;
				}
			}
			book.close();
			return array;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String updateRequestData(String excelFileName, String sheetname,String filepath) {

		try {
			DataFormatter formatter = new DataFormatter();
			XSSFWorkbook book = new XSSFWorkbook(".\\src\\test\\testdata\\" + excelFileName + ".xlsx");
			XSSFSheet sheet = book.getSheet(sheetname);
			// Getting row count and column count for iteration
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();

			HashMap<String, String> map = new HashMap<String, String>();

			// Iteration Part
			for (int i = 1; i <= rowCount; i++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell key = row.getCell(1);
				String jsonpath = formatter.formatCellValue(key);
				XSSFCell value = row.getCell(2);
				String newValue = formatter.formatCellValue(value);
				map.put(jsonpath, newValue);

			}

			book.close();
			String requestString = JsonParser.updateRequestDataInJson(map, filepath);
			return requestString;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static HashMap<String, String> updateQueryParamsFromExcel(String excelFileName, String sheetname) {

		try {
			DataFormatter formatter = new DataFormatter();
			XSSFWorkbook book = new XSSFWorkbook(".\\src\\test\\testdata\\" + excelFileName + ".xlsx");
			XSSFSheet sheet = book.getSheet(sheetname);
			// Getting row count and column count for iteration
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();

			HashMap<String, String> map = new HashMap<String, String>();

			// Iteration Part
			for (int i = 1; i <= rowCount; i++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell key = row.getCell(3);
				String nameOfQueryParam = formatter.formatCellValue(key);
				XSSFCell value = row.getCell(4);
				String newValue = formatter.formatCellValue(value);
				map.put(nameOfQueryParam, newValue);

			}

			book.close();
			
			return map;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
