package com.ssts.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MAIN {

	public static void main(String[] args) throws MalformedURLException, IOException {
		String[] urlsToTest = new String[] { "https://prod-browsercloud-in.pcloudy.com", 
											"http://device.pcloudy.com/", 
											"http://google.com", 
											"http://qa1.myopkey.com" };

		for (String aUrl : urlsToTest) {
			try {
				testURL(aUrl);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	private static void testURL(String aUrl) throws MalformedURLException, IOException {
		log("==================================");
		log(aUrl);
		log("==================================");
		HttpURLConnection connection = (HttpURLConnection) new URL(aUrl).openConnection();
		connection.setRequestProperty("Accept-Charset", StandardCharsets.UTF_8.displayName());

		int status = connection.getResponseCode();
		log("Http ResponseCode: " + status);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
			reader.lines().forEach(aLine -> {
				log(aLine);
			});

		}

		log("");

	}

	private static void log(String msg) {
		log(msg, false);
	}

	private static void log(String msg, Boolean isError) {
		if (isError)
			System.err.println(msg);
		else
			System.out.println(msg);
	}

}
