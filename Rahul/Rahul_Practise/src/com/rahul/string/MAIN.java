package com.rahul.string;

import java.util.Date;

import com.rahul.log.Logger;
import com.webservice.RestApi;
import com.webservice.SSLUtilities;

public class MAIN {

	public static void main(String[] args) throws Exception {

		/*
		 * String input = "Rahul is a good boy and he's currently available at rahul@gmail.com. And he is very fond of maths + computers";
		 * 
		 * try { RahulsFileReader rfr = new RahulsFileReader(); input = rfr.readFullFile(new File("D:\\a.txt"));
		 * 
		 * } catch (FileNotFoundException ex) { System.err.println("File was not found. Please check the path again."); }
		 * System.out.println("--------------------------------------------------------------------");
		 * 
		 * 
		 * StringUtils su = new StringUtils(input);
		 * 
		 * System.out.println("LowerCase Chars: " + su.getAllLowerCaseCharacters()); System.out.println("UpperCase Chars: " + su.getAllUpperCaseCharacters());
		 * 
		 * System.out.println("Special Chars: " + su.getAllSpecialCharacters()); System.out.println("Count of consonants: " + su.countOfConsonants()); System.out.println("Count of spaces: " +
		 * su.countOfSpaces());
		 * 
		 * System.out.println("Generate Random Password: " + su.generateRandomPassword(15));
		 * 
		 * System.out.println("--------------------------------------------------------------------");
		 * 
		 * RecursionPractice rp = new RecursionPractice(); rp.printFibonacci();
		 * 
		 * System.out.println("--------------------------------------------------------------------");
		 * 
		 * FileSystemUtil fsu = new FileSystemUtil(); fsu.printProperties(); try { fsu.printAllFilesAndDirectoriesRecursively(); } catch (Exception e) { System.err.println(e.getMessage()); }
		 */

		Logger.log("Staring...");

		// SSLUtilities.trustAllHosts();
		//Logger.log("Trust All Hosts Done");

	
		
		System.out.println(RestApi.DoPostUsingOkHttp(RestApi.postUri));
		Logger.log("====== Finished using OK Http");

		System.out.println("^^^^^^^^^^^^^^^^^^^^^^");


		System.out.println("^^^^^^^^^^^^^^^^^^^^^^");


	}
}
