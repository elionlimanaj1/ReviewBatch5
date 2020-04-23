package com.review4.utils;

import java.util.*;

public class Test {
	private static final double PI = 3.14159;
	private static final String PROPERTIES_PATH = System.getProperty("user.dir") + "/extra/Configuration.properties";
	private static final String EXCEL_PATH = System.getProperty("user.dir") + "/extra/Data.xlsx";

	public static void main(String[] args) {
		// Why we need constant variables?
		// double radius = 2;
		// double area = PI * radius * radius;
		// double volume = (4.0 / 3.0) * PI * radius * radius * radius;
		// double perimeter = 2 * PI * radius;

		System.out.println("----------------ConfigReader----------------");
		ConfigReader.readProperties(PROPERTIES_PATH);
		String value = ConfigReader.getProperty("url");
		System.out.println(value);

		System.out.println("----------------ReadWriteTextFile----------------");
//		String text = ReadWriteTextFile.readText(PROPERTIES_PATH);
//		System.out.println(text);

//		boolean goodJob = ReadWriteTextFile.writeText(PROPERTIES_PATH, "\nBye again");
//		List<String> lines = ReadWriteTextFile.readLines(PROPERTIES_PATH);
//		for (String line : lines) {
//			System.out.println(line);
//		}

		System.out.println("----------------ExcelUtility----------------");
		List<Map<String, String>> mapList = ExcelUtility.excelIntoListOfMaps(EXCEL_PATH, "Student");
//		System.out.println(mapList);	
		for (Map<String, String> map :mapList) {
//			System.out.println(map);
			System.out.println(map.get("FirstName"));
		}

		System.out.println("----------------DatabaseUtility----------------");
//		ConfigReader.readProperties(PROPERTIES_PATH);
		DatabaseUtility.createConnection();
		List<Map<String, String>> maps = DatabaseUtility.readFromDB("select * from ohrm_nationality limit 3");
		System.out.println(maps);

		DatabaseUtility.closeConnection();

	}
}
