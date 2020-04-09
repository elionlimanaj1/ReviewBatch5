package com.review2.Maps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.*;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static Workbook wbook;
	private static Sheet sheet;

	/**
	 * This method will open xlfile and specified sheet
	 * 
	 * @param filePath
	 * @param sheetName
	 */
	public static void openExcel(String filePath, String sheetName) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			wbook = new XSSFWorkbook(fis);
			sheet = wbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will return number of rows
	 * 
	 * @return
	 */
	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	/**
	 * This method will return number of cols
	 * 
	 * @return
	 */
	public static int colsCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	/**
	 * This method will return data from specified row and column
	 * 
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 */
	public static String getCellData(int rowIndex, int cellIndex) {
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
	}

	/**
	 * This method will read any Excel file and return data in 2D array
	 * 
	 * @param filePath
	 * @param sheetName
	 * @return
	 */
	public static Object[][] excelIntoArray(String filePath, String sheetName) {

		openExcel(filePath, sheetName);

		Object[][] data = new Object[rowCount() - 1][colsCount()];

		for (int i = 1; i < rowCount(); i++) {
			for (int y = 0; y < colsCount(); y++) {
				data[i - 1][y] = getCellData(i, y);
			}
		}
		return data;
	}

	public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName) {
		openExcel(filePath, sheetName);

		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();

		// for every row
		for (int row = 1; row < rowCount(); row++) {

			// create the map
			Map<String, String> rowMap = new LinkedHashMap<String, String>();

			// fill the map
			for (int col = 0; col < colsCount(); col++) {
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
