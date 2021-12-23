package com.rahul.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MAIN {

	public static void main(String[] args) throws IOException {

		String input = "Rahul is a good boy and he's currently available at rahul@gmail.com. And he is very fond of maths + computers";

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

	}

}
