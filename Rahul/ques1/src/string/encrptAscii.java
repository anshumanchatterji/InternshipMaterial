package string;

public class encrptAscii {

	public static void main(String[] args) {
		
		String str = "ABCXYZabcxyz";
		int n = 3;

		
		encrypt(str, a);
	}
				

	public static void encrypt(String s, int n) {

				
				String a = "";

				for (int i = 0; i < s.length(); i++) {
					int val = s.charAt(i);
					
					int temp = val + n;
					char k = (char)(temp + 'a' );
					
					
					
					

				
					
				}
				System.out.println(a);
			}

	
}
