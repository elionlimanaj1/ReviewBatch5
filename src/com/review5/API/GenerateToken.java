package com.review5.API;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.junit.Assert;

import com.review4.utils.ReadWriteTextFile;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static com.review5.API.APIContants.*;

public class GenerateToken {

	public static void main(String[] args) {
		// 1. Provide the request header
		RequestSpecification request = given().header("Content-Type", "application/json");

		// 2. Provide the request body (when needed)
		String requestBody = ReadWriteTextFile.readText(generateTokenPath);
		request.body(requestBody);

		// 3. request Http Method 4. request URI
		Response response = request.when().post(BASE_URL + GENERATE_TOKEN_URL);

		////////////////////////////////
		// 1. Assert response Status Code
		// 1st way
		try {
			response.then().assertThat().statusCode(201);
		} catch (AssertionError e) {
			System.out.println("1. Status code was not correct!");
			// If Hatice wants, she can catch and then throw the exception
			// throw e;
		}

		// 2nd way
		int statusCode = response.getStatusCode();
		try {
			Assert.assertEquals(201, statusCode);
		} catch (AssertionError e) {
			System.out.println("2. Status code was not correct!");
		}

		System.out.println("Everything was fine");

		// 2. Assert response Header
		// Nothing

		// 3. Assert response Body
		String body1 = response.asString();
		String body2 = response.getBody().asString();
		String body3 = response.body().asString();

		System.out.println(body3);

		// 1st way, using JsonPath
		JsonPath jsonPath = response.jsonPath();
		String token = jsonPath.getString("token");
		System.out.println(token);
		ReadWriteTextFile.writeText(tokenPath, "Bearer " + token);

		// 2nd way, using JSONObject
		JSONObject json = new JSONObject(response.asString());
		String jsonObjectToken = json.getString("token");
		System.out.println(jsonObjectToken);
	}
}
