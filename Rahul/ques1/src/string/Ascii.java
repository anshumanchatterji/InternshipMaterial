package string;
import java.util.Scanner;

public class Ascii {

	public static void main(String[] args) {
		
		System.out.print("enter: ");  
		Scanner s = new Scanner(System.in);  
		char ch = s.next().charAt(0);  
		int asciiValue = ch;  
		System.out.println("ASCII value of " +ch+ " is: "+asciiValue);  

	}

}
