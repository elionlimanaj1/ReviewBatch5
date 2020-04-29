package com.review4.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ReadWriteTextFile {
	// Reads text from a file
	// Writes text into a file

	public static List<String> readLines(String filePath) {
		List<String> lines = new ArrayList<String>();
		try {
			Path path = Paths.get(filePath);
			lines = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lines;
	}

	public static String readText(String filePath) {
		String text = "";
		try {
			Path path = Paths.get(filePath);
			byte[] bytes = Files.readAllBytes(path);
			text = new String(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
	
	public static boolean writeText(String filePath, String text) {
		boolean flag = false;
		
		Path path = Paths.get(filePath);
		byte[] bytes = text.getBytes();
		try {
			Files.write(path, bytes, StandardOpenOption.TRUNCATE_EXISTING);
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
