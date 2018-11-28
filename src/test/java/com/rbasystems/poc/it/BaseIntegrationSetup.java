package com.rbasystems.poc.it;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

import io.restassured.RestAssured;

/**
 * @author Amar Deep Singh
 *
 */
public class BaseIntegrationSetup {
	private static final String CONFIG_PROPERTIES = "pipeline/config.properties";
	private static final String TEST_SERVER_BASE_URL = "TEST_SERVER_BASE_URL";
	static String  baseUrl = "http://localhost:8080";

	@PostConstruct
	public static void init() {
		String serverAddress = System.getProperty(TEST_SERVER_BASE_URL) != null
				? System.getProperty(TEST_SERVER_BASE_URL)
				: getServerAddress();
				
		if (serverAddress != null) {
			baseUrl = serverAddress;
		}

		RestAssured.baseURI = baseUrl;
	}

	private static String getServerAddress() {
		Properties prop = new Properties();
		InputStream input = null;
		String serverAddress = null;

		try {
			input = new FileInputStream(CONFIG_PROPERTIES);

			// load a properties file
			prop.load(input);

			serverAddress = prop.getProperty(TEST_SERVER_BASE_URL);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return serverAddress;
	}

}
