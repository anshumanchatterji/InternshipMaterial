package rahulClass;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Person p = new Person("Rahul" , "Singh" , new Date(90,05,24) );
		
		System.out.println(p.getFirstName()) ;
		System.out.println(p.getLastName()) ;
		System.out.println(p.getDob()) ;
		


	}

}
