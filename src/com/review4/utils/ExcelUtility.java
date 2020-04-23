package com.review4.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static Workbook wbook;
	private static Sheet sheet;
	
	public static void openExcel(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			wbook = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadSheet(String sheetName) {
		sheet = wbook.getSheet(sheetName);
	}
	
	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int colsCount(int row) {
		return sheet.getRow(row).getLastCellNum();
	}
	
	public static String getCellData(int rowIndex, int cellIndex) {
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
	}
	
	public static Object[][] excelIntoArray(String filePath, String sheetName) {

		openExcel(filePath);
		loadSheet(sheetName);

		Object[][] data = new Object[rowCount() - 1][colsCount(0)];

		for (int i = 1; i < rowCount(); i++) {
			for (int y = 0; y < colsCount(i); y++) {
				data[i - 1][y] = getCellData(i, y);
			}
		}
		return data;
	}

	public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName) {
		openExcel(filePath);
		loadSheet(sheetName);

		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();

		// for every row
		for (int row = 1; row < rowCount(); row++) {

			// create the map
			Map<String, String> rowMap = new LinkedHashMap<String, String>();

			// fill the map
			for (int col = 0; col < colsCount(row); col++) {
				String header = getCellData(0, col);
				String value = getCellData(row, col);
				rowMap.put(header, value);
			}
			// add the map into the list
			mapList.add(rowMap);

		}

		// return the list of maps
		return mapList;
	}
	
}
