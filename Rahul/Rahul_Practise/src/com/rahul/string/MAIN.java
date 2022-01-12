package com.rahul.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import com.google.gson.Gson;
import com.ssts.opkey.models.ExecuteCommandResponse;
import com.webservice.RestApi;
import com.webservice.SSLUtilities;

public class MAIN {

	public static void main(String[] args) throws Exception {

		/*String input = "Rahul is a good boy and he's currently available at rahul@gmail.com. And he is very fond of maths + computers";

		try {
			RahulsFileReader rfr = new RahulsFileReader();
			input = rfr.readFullFile(new File("D:\\a.txt"));
			
		} catch (FileNotFoundException ex) {
			System.err.println("File was not found. Please check the path again.");
		}
		System.out.println("--------------------------------------------------------------------");
		
		
		StringUtils su = new StringUtils(input);

		System.out.println("LowerCase Chars: " + su.getAllLowerCaseCharacters());
		System.out.println("UpperCase Chars: " + su.getAllUpperCaseCharacters());

		System.out.println("Special Chars: " + su.getAllSpecialCharacters());
		System.out.println("Count of consonants: " + su.countOfConsonants());
		System.out.println("Count of spaces: " + su.countOfSpaces());

		System.out.println("Generate Random Password: " + su.generateRandomPassword(15));

		System.out.println("--------------------------------------------------------------------");
        
		RecursionPractice rp = new RecursionPractice();
		rp.printFibonacci();
		
		System.out.println("--------------------------------------------------------------------");
		
		FileSystemUtil fsu = new FileSystemUtil();
		fsu.printProperties();
		try {
			fsu.printAllFilesAndDirectoriesRecursively();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}*/
		
		Date startedOn = new Date();
		
		SSLUtilities.trustAllHosts();
		String str = RestApi.doPost();
		System.out.println(str);
		long millis = new Date().getTime() - startedOn.getTime();
		System.out.println("Seconds: " + millis/1000);
	}
}
