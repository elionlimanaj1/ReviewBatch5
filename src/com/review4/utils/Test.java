package com.review4.utils;

import java.util.*;

public class Test {
	private static final double PI = 3.14159;
	private static final String PROPERTIES_PATH = System.getProperty("user.dir") + "/extra/Configuration.properties";

	public static void main(String[] args) {
		// Why we need constant variables?
		// double radius = 2;
		// double area = PI * radius * radius;
		// double volume = (4.0 / 3.0) * PI * radius * radius * radius;
		// double perimeter = 2 * PI * radius;

//		ConfigReader.readProperties(PROPERTIES_PATH);
//		String value = ConfigReader.getProperty("url");
//		System.out.println(value);

//		String text = ReadWriteTextFile.readText(PROPERTIES_PATH);
//		System.out.println(text);

		List<String> lines = ReadWriteTextFile.readLines(PROPERTIES_PATH);
		System.out.println(lines);
		for (String line : lines) {
			System.out.println(line);
		}
	}
}

//Break until 8:42
