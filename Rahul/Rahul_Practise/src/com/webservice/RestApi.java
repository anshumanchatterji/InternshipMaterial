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

import com.rahul.log.Logger;
import com.webservice.okhttp.PrintingEventListener;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RestApi {

	public static String postUri = "https://qa3.stg.smartopkey.com/api/v1/agentrpc/RegisterSpockAgentClient";
	// public static String postUri = "https://gorest.co.in/public/v1/users";
	// static String baseURI = "https://google.com";
	static String authorizationHeader = "1AuthenticationWithAPI c2FjaGluLmJoYXRpYUBzc3RzaW5jLmNvbTpUNUM2VVVGTkVGQUQwNEVVT0U=";
	static String jsonRequestBody = "{\"ClientID\":\"d5c86db2-6ebc-11ec-90d6-0242ac120003\",\"ClientName\":\"Test1\",\"OS_Name\":\"Windows\",\"OS_Version\":\"10\"}";// gson.tojson() converts your

	//static HttpClient httpclient = HttpClients.createDefault();

	public static String doPostUsingApacheHttpClient(String s_uri) throws UnsupportedOperationException, IOException {
		 HttpClient httpclient = HttpClients.createDefault();

		HttpPost httppost = new HttpPost(s_uri);

		httppost.addHeader("Authorization", authorizationHeader);

		// Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();

		httppost.setEntity(new StringEntity(jsonRequestBody));
		httppost.setHeader("Content-type", "application/json");

		StringBuffer sb = new StringBuffer();

		if (entity != null) {
			try (InputStream instream = entity.getContent()) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(instream));

				// String line = reader.readLine();
				String line;
				while ((line = reader.readLine()) != null) {
					sb.append(line).append("\n");
				}
			}
		}

		return sb.toString();
	}

	public static String DoPostUsingURLConnection(String s_uri) throws Exception {
		try {
			URL uri = new URL(s_uri);
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			// Logger.log("Opened Connection");
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

			connection.setRequestProperty("Authorization", authorizationHeader);

			// Create the Request Body
			try (OutputStream os = connection.getOutputStream()) {
				byte[] input = jsonRequestBody.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			// Logger.log("Written Output Stream");

			int responseCode = connection.getResponseCode();
			InputStream is = null;
			if (responseCode == HttpURLConnection.HTTP_OK)
				is = connection.getInputStream();
			else
				is = connection.getErrorStream();

			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine).append("\n");
				;
			}
			in.close();

			return response.toString();

		} catch (Exception ex) {
			return ex.getMessage();
		} finally {
			// Logger.log("Got full response");
		}
	}

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	// static OkHttpClient client = new OkHttpClient();

	public static String DoPostUsingOkHttp(String s_uri) throws IOException {
		//OkHttpClient client = SSLUtilities.getUnsafeOkHttpClient();// new OkHttpClient();
		OkHttpClient client = new OkHttpClient.Builder().eventListenerFactory(PrintingEventListener.FACTORY).build();
		Logger.log("Created OKHttpClient");
		RequestBody formBody = RequestBody.create(jsonRequestBody, JSON);
		Request request = new Request.Builder().url(s_uri).addHeader("Authorization", authorizationHeader).post(formBody).build();
		Logger.log("Created Request Body");
		try {
			Response response = client.newCall(request).execute();
			return response.body().string(); // Do something with the response.
		} catch (IOException e) {
			return e.getMessage();
		}

		/*
		 * Request request = new Request.Builder().url("https://publicobject.com/helloworld.txt").build();
		 * 
		 * 
		 * System.out.println("REQUEST 1 (new connection)"); try (Response response = client.newCall(request).execute()) { // Consume and discard the response body. ByteString bs =
		 * response.body().source().readByteString(); return bs.string(Charset.forName("UTF8")); }
		 */

	}

}
