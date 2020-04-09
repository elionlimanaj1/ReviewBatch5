package com.review2.Maps;

import java.util.*;

public class ExcelDemo {

	public static void main(String[] args) {
		String excelPath = System.getProperty("user.dir") + "/extra/Data.xlsx";

		List<Map<String, String>> mapList = ExcelUtility.excelIntoListOfMaps(excelPath, "Student");
		System.out.println(mapList);

		// HW for Esra
		// Now that you have the List of Maps
		// Iterate it!!!

	}

}
