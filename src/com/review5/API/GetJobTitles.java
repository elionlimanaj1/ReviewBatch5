package com.review5.API;

import static com.review4.utils.ReadWriteTextFile.readText;
import static com.review4.utils.ReadWriteTextFile.writeText;
import static com.review5.API.APIContants.BASE_URL;
import static com.review5.API.APIContants.GET_JOB_TITLES_URL;
import static com.review5.API.APIContants.reportPath;
import static com.review5.API.APIContants.tokenPath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetJobTitles {

	private static RequestSpecification request;
	private static Response response;

	public static void main(String[] args) {
		// request
		provideHeader();
//		provideBody();
		makeAPICall();

		// response
		assertStatusCode(200);
		assertResponseBody();
	}

	public static void provideHeader() {
		String token = readText(tokenPath);
		request = given().header("Authorization", token);
	}

	public static void makeAPICall() {
		response = request.when().get(BASE_URL + GET_JOB_TITLES_URL);
	}

	public static void assertStatusCode(int expectedStatusCode) {
		// 1st way, Rest Assured Assertion
		try {
			response.then().assertThat().statusCode(expectedStatusCode);
			// Write into report file passed
			writeText(reportPath, "Status code passed: " + expectedStatusCode);
		} catch (AssertionError e) {
			// Write into report file failed
			writeText(reportPath, "Status code failed!!!");
		}

		// 2nd way, JUnit Assertion
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(expectedStatusCode, actualStatusCode);
	}

	public static void assertResponseBody() {
		String body = response.asString();
		System.out.println(body);

		String expected = "Cloud Architect";
		// 1st way, using hamcrest.Matchers (part of Rest Assured)
		// Assertion is done by hamcrest.Matchers
		response.then().body("'Job Title List'[0]", equalTo(expected));

		// 2nd way, JsonPath (part of Rest Assured)
		// Assertion by using JUnit
		JsonPath jsonPath = response.jsonPath();

		// Get the whole list, and assert the first element
		List<String> jobTitleList = jsonPath.getList("'Job Title List'");
		Assert.assertEquals(expected, jobTitleList.get(0));

		String jsonPathString = jsonPath.getString("'Job Title List'[0]");
		Assert.assertEquals(expected, jsonPathString);
		System.out.println(jsonPathString);

		// 3rd way, JSONObject (NOT part of Rest Assured)
		// Assertion by using JUnit
		JSONObject jsonObject = new JSONObject(response.asString());
		JSONArray jobTitleArray = jsonObject.getJSONArray("Job Title List");
		String jobTitle1 = jobTitleArray.getString(0);
		Assert.assertEquals(expected, jobTitle1);
		System.out.println(jobTitle1);

		int size = jobTitleArray.length();
		System.out.println("How many job titles? " + size);
	}
}
