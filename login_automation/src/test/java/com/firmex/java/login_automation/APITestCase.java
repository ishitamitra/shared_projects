package com.firmex.java.login_automation;
import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APITestCase {

	final static String ROOT_URI = "https://login.firmex.com";

	@Test
	public void postResponseTest() {
		RestAssured.baseURI = ROOT_URI;
		RestAssured.baseURI = ROOT_URI;
		RequestSpecification httpRequest = RestAssured.given().body(
				"{  \r\n" + "   \"email\":\"mitra.ishita89@gmail.com\",\r\n" + "   \"password\":\"1234567\"\r\n" + "}");
		Response response = httpRequest.post("/authenticate/global");

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();
		String responseBody = body.asString();

		if (responseBody.contains("AccessDenied")) {
			System.out.println("TC passed");
		} else {
			System.out.println("TC failed");
		}
	}

	
	@Test
	public void postStatusCodeTest() {
		RestAssured.baseURI = ROOT_URI;
		given().body(
				"{  \r\n" + "   \"email\":\"mitra.ishita89@gmail.com\",\r\n" + "   \"password\":\"1234567\"\r\n" + "}")
				.when().post("/authenticate/global").then().assertThat().statusCode(200);
	}

	
}