package com.rahul.string;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	private String input = null;

	public StringUtils(String input) {
		this.input = input;
	}

	// Print all the lowercase characters
	// Print all upercase characters
	// print all special chacters
	// print count of consonants in it
	// print count of spaces in it

	public String getAllLowerCaseCharacters() {
		String lowerCaseChars = "";

		for (char c : input.toCharArray()) {
			if (Character.isLowerCase(c)) {
				lowerCaseChars += c;
			}
		}

		return lowerCaseChars;
	}

	public String getAllUpperCaseCharacters() {
		String upperCaseChars = "";

		for (char c : input.toCharArray()) {
			if (Character.isUpperCase(c)) {
				upperCaseChars += c;
			}
		}

		return upperCaseChars;
	}

	public String getAllSpecialCharacters() {
		String specialChars = "";

		Pattern p = Pattern.compile("[^A-Za-z0-9 ]");
		Matcher matcher = p.matcher(input);
		while (matcher.find()) {
			String aMatch = matcher.group();
			specialChars += aMatch;
		}

		return specialChars;
	}

	public int countOfConsonants() {
		int consonants = 0;
		Pattern p = Pattern.compile("[^aeiou!@#$$%^&*()]", Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(input);
		while (matcher.find()) {
			consonants++;
		}
		return consonants;
	}

	public int countOfSpaces() {
		/*
		 * Pattern p = Pattern.compile("\\s", Pattern.CASE_INSENSITIVE); Matcher matcher = p.matcher(input); return matcher.groupCount();
		 */

		int spaces = 0;
		for (char c : input.toCharArray()) {
			if (c == ' ')
				spaces++;
		}
		return spaces;
	}

	public String generateRandomPassword(int passwordLenght) {
		Random rnd = new Random();
		String randomPassword = "";
		for (int i = 0; i < passwordLenght; i++) {
			int aRandomAscii = rnd.nextInt(78) + 48;
			char aRandomChar = (char) aRandomAscii;
			randomPassword += aRandomChar;
		}
		return randomPassword;
	}
}
