package com.rbasystems.poc.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.Matchers.hasSize;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * This Integration test case is responsible for testing
 * 
 * @author Amar Deep Singh
 *
 */
public class EmployeeRestApiIT extends BaseIntegrationSetup {
	private static final String BUNNY = "Bunny";
	private static final String HONEY = "Honey";
	private static final String HONEY_BUNNY_EMAIL = "honey.bunny@funny.com";

	@BeforeClass
	public static void setup() {
		init();
		RestAssured.basePath = "employee";
	}

	@Test
	public void testEmptyResult() {
		given().when().get().then().statusCode(HttpStatus.OK.value());
	}

	@Test
	public void testCreateEmployeeTest() {
		Map<String, String> employee = new HashMap<>();
		employee.put("firstName", HONEY);
		employee.put("lastName", BUNNY);
		employee.put("emailId", HONEY_BUNNY_EMAIL);
		employee.put("dateOfBirth", "01-01-1978");
		employee.put("phoneNumber", "469-203-1686");

		given().contentType(ContentType.JSON).body(employee).when().post().then().statusCode(HttpStatus.CREATED.value())
				.assertThat();
	}
}
