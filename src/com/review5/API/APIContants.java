package com.review5.API;

public class APIContants {
	public static final String generateTokenPath = System.getProperty("user.dir") + "/extra/generateToken.json";
	public static final String tokenPath = System.getProperty("user.dir") + "/extra/token.txt";
	public static final String reportPath = System.getProperty("user.dir") + "/extra/report.txt";

	public static final String BASE_URL = "http://166.62.36.207/syntaxapi/api";
	public static final String GENERATE_TOKEN_URL = "/generateToken.php";
	public static final String GET_JOB_TITLES_URL = "/jobTitle.php";
}
