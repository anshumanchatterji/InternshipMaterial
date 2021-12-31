package string;
import java.util.*;

public class stringQues {

	public static void main(String[] args) {
		
         Scanner s = new Scanner(System.in);
         System.out.print("Enter:");
         String str = s.nextLine();
         
         int count = 0;
         
         
         for(int i = 0; i < str.length(); i++) {
             if(str.charAt(i)==' '){
                 count++;
             }
         }
         System.out.println("No. of spaces:"+count);
         
         
         System.out.println("Uppercase:");
         for (int i = 0; i< str.length(); i++ )
         {
              if (Character.isUpperCase(str.charAt(i)))
              {
                   System.out.println(str.charAt(i));
              }
         }
         
         
         System.out.println("Lowercase:");
         for (int i = 0; i< str.length(); i++ )
         {
              if (Character.isLowerCase(str.charAt(i)))
              {
                   System.out.println(str.charAt(i));
              }
              
         }
         
         System.out.println("Special:");
         for (int i = 0; i < str.length(); i++) 
         {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                 System.out.println(str.charAt(i));
             }
         }
         
         for (int i=0 ; i<str.length(); i++){
             char ch = str.charAt(i);
             if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){
                System.out.print("");
             }else if(ch != ' '){
                count++;
             }
          }
          System.out.println("No. of const:"+count);
          
          
         
       
    }
}



	


