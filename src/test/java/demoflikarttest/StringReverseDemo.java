package demoflikarttest;

public class StringReverseDemo {

	public static void main(String[] args) {
		
		
	String language="malayalam";
	String reverse="";
	int len=language.length();
	
	for(int i=len-1;i>=0;i--) {
		
	reverse=reverse+language.charAt(i);
		
		
	}
	System.out.println(reverse);
		if(language.equals(reverse)  ) {
			
			System.out.println("palindromic string");
		}
		else {
			
			System.out.println("invalid");
		}
	
		
		

	}

}
