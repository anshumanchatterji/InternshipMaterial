package rahulClass;

import java.util.Date;

import string.RahulDateAndTime;

public class Main {

	public static void main(String[] args) {
		Person p = new Person("Rahul", "Singh", new Date(90, 05, 24));

		System.out.println(p.getFirstName());
		System.out.println(p.getLastName());
		System.out.println(p.getDob());

		RahulDateAndTime.printCurrentDate();
	}

}
