package string;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RahulDateAndTime {

	public static void printCurrentDate() {

		SimpleDateFormat myFormatObj = new SimpleDateFormat("dd-MMMM-yy HH:mm");
		String dateInMyFormat = myFormatObj.format(new Date());

		System.out.println("Current D&T: " + dateInMyFormat);

	}
}
