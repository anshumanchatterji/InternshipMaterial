package smallPrograms;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Pattern {

	// * * * * *
	// * * *
	// *

	public static void main(String[] args) {
		pattern();
		String input = "rAHUL sINGH";
		String s = reverseString(input);
		System.out.println(s);

		System.out.println(invertCase(input));

		String encryptedText = encrypt("Rahul Singh ABC XYZ");
		System.out.println("Encrypted: " + encryptedText);

		String decryptedText = decrypt(encryptedText);
		System.out.println("Decrypted Text: " + decryptedText);

		System.out.println("===============================");
		try {
			List<byte[]> matchedPersons = storeNames();
			for (byte[] aPerson : matchedPersons) {
				//System.out.println(aPerson + " = " + decrypt(aPerson));
				System.out.println(aPerson + " = " + decodeFromBase64(aPerson));
			}
		} catch (Exception ex) {
			System.err.println("Error Found: " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	static void pattern() {
		for (int i = 5; i > 0; i = i - 2) {
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static String reverseString(String input) {
		String s = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			s = s + input.charAt(i);
		}
		return s;
	}

	static String invertCase(String input) {
		String s = "";
		for (int i = 0; i < input.length(); i++) {
			char aCharacter = input.charAt(i);
			if (isLowerCase(aCharacter)) {
				s = s + Character.toUpperCase(aCharacter);
			} else {
				s = s + Character.toLowerCase(aCharacter);
			}
		}
		return s;
	}

	static Boolean isLowerCase(char ch) {
		int keyCode = (int) ch;
		if (keyCode > 96 && keyCode < 123) {
			return true;
		} else
			return false;
	}

	static String encrypt(String input) {
		String output = "";
		for (char a : input.toCharArray()) {
			int newAscii = ((int) a) + 3;
			output += (char) newAscii;
		}
		return output;
	}

	static String decrypt(String encryptedText) {
		String output = "";
		for (char a : encryptedText.toCharArray()) {
			int newAscii = ((int) a) - 3;
			output += (char) newAscii;
		}
		return output;
	}

	static List<byte[]> storeNames() throws Exception {
		String p1 = "Rahul Singh";
		String p2 = "rohit sharma";
		String p3 = "Abhi tak to nahi thi";
		String p4 = " Nahi hai";
		String p5 = "Tony Stark";
		String p6 = " Anshuman Chatterjee ";

		String[] persons = new String[] { p1, p2, p3, p4, p5, p6 };

		persons = new String[] { "Anshuman Chatterjee", p1, p2, p3, p4, p5, p6 };

		List<byte[]> matchedPersons = new ArrayList<byte[]>();
		for (String aPerson : persons) {
			String trimmedPersonName = aPerson.trim();
			if (!trimmedPersonName.contains(" "))
				throw new Exception("Unable to find last name: " + trimmedPersonName);

			//matchedPersons.add(encrypt(trimmedPersonName));
			matchedPersons.add(encodeInBase64(trimmedPersonName));

		}
		return matchedPersons;

	}

	static byte[] encodeInBase64(String input) {
		byte[] base64 = Base64.getEncoder().encode(input.getBytes());
		return base64; //new String(base64, StandardCharsets.UTF_8);
	}

	static String decodeFromBase64(byte[] base64String) {
		//byte[] bytes = base64String.getBytes(StandardCharsets.UTF_8);
		byte[] decodedString = Base64.getDecoder().decode(base64String);
		return new String(decodedString, StandardCharsets.UTF_8);
	}

}
