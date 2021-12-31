package string;

import java.util.Scanner;

public class asciiEqual {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);  
		String str = s.nextLine();  
		
		// Declaring str as 'geeksforgeeks'
	

		manipulateString(str);	
	
}
	// Java program for Replace every character of a
	// string by a different character
	

		//Function to manipulate the string
		static void manipulateString(String str)
		{

			char[] str1 = str.toCharArray();
			
		// looping through each character of string
		for (int i = 0; i < str.length(); i++) {

			// storing integer ASCII value of
			// the character in 'asc'
			
			int asc = str1[i];
			
			// 'rem' contains coded value which
			// needs to be rounded to 26
			int rem = asc - (26 - (str1[i] - 97));

			// converting 'rem' character in range
			// 0-25 and storing in 'm'
			int m = rem % 26;
			
			// printing character by adding ascii value of 'a'
			// so that it becomes in the desired range i.e. a-z
			str1[i] = (char)(m + 'a');
				
		}
		
		String str2 = String.valueOf(str1);
		System.out.println(str2);
		
		}

	
		


}
