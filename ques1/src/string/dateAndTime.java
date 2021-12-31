package string;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;  

public class dateAndTime {
	
	public static void main(String[] args) {
	 
		     
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");  
		    
		    String formattedDate = dateTime.format(myFormatObj);  
		    System.out.println("Current D&T: " + formattedDate);  
		  
	
	}
}
