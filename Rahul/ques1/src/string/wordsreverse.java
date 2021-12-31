package string;

public class wordsreverse {

	public static void main(String[] args) {
    
		System.out.println(reverseWord("Rahul is a good boy"));    

	}
	public static String reverseWord(String input){  
	    String words[]=input.split("\\s");  
	    String reverseWord="";  
	    for(String w:words){  
	        StringBuilder sb=new StringBuilder(w);  
	        sb.reverse();  
	        reverseWord+=sb.toString()+" ";  
	    }  
	    return reverseWord.trim();  
	}  
	

}
