package com.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class RestApi {

	public static String doPostUsingApacheHttpClient() throws UnsupportedOperationException, IOException {
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost("https://qa3.stg.smartopkey.com/api/v1/agentrpc/RegisterSpockAgentClient");

		// Request parameters and other properties.
		// List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		// params.add(new BasicNameValuePair("param-1", "12345"));
		// params.add(new BasicNameValuePair("param-2", "Hello!"));
		// httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		StringEntity postingString = new StringEntity("{\"ClientID\":\"d5c86db2-6ebc-11ec-90d6-0242ac120003\",\"ClientName\":\"Test1\",\"OS_Name\":\"Windows\",\"OS_Version\":\"10\"}");// gson.tojson()
																																														// converts your
																																														// pojo to json

		httppost.addHeader("Authorization", "AuthenticationWithAPI c2FjaGluLmJoYXRpYUBzc3RzaW5jLmNvbTpUNUM2VVVGTkVGQUQwNEVVT0U=00");

		// Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();

		httppost.setEntity(postingString);
		httppost.setHeader("Content-type", "application/json");

		StringBuffer sb = new StringBuffer();

		if (entity != null) {
			try (InputStream instream = entity.getContent()) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(instream));

				// String line = reader.readLine();
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
			}
		}

		return sb.toString();
	}

	public static String DoPostUsingURLConnection() throws Exception {
		
			String jsonRequestBody = "{\"ClientID\":\"d5c86db2-6ebc-11ec-90d6-0242ac120003\",\"ClientName\":\"Test1\",\"OS_Name\":\"Windows\",\"OS_Version\":\"10\"}";//gson.tojson() converts your pojo to json

			URL uri = new URL("https://qa3.stg.smartopkey.com/api/v1/agentrpc/RegisterSpockAgentClient");
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

			connection.setRequestProperty("Authorization","AuthenticationWithAPI c2FjaGluLmJoYXRpYUBzc3RzaW5jLmNvbTpUNUM2VVVGTkVGQUQwNEVVT0U=00");

			// Create the Request Body
			try (OutputStream os = connection.getOutputStream()) {
				byte[] input = jsonRequestBody.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				return response.toString();

			} else {
				throw new Exception("Command Response not sent.");
			}
	}
	
}
