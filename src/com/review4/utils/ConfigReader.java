package com.review4.utils;

import java.io.*;
import java.util.*;

public class ConfigReader {

	// Reads a key=value text file
	private static Properties prop;

	public static void readProperties(String filePath) {
		if (prop != null) {
			return;
		}

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
}
