package rahulClass;

import java.util.Date;

public class Person {

	 private String firstName;
	    private String lastName;
	    private Date dob;

	    public Person(String a, String b,Date c) {
			
			this.firstName = a;
			this.lastName = b;
			this.dob = c;
			
			
		}

		public String getFirstName(){
	        return this.firstName;
	    }

	    public String getLastName(){
	        return this.lastName;
	    }

	    public Date getDob(){
	        return this.dob;
	    }
	   

	   
	    
}