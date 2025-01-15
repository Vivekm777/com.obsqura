package demoflikarttest;

import org.testng.annotations.Test;

public class Palindromedemo {
    
	
    public static void main(String[] args) {
		
		
	int number=121;
	int reversednumber=0;
	int a=number;
	while(number!=0) {
	int temp=number%10;
	reversednumber=reversednumber*10+temp;
	number=number/10;
	}
	if(a==reversednumber) {
		
		
		System.out.println("number is palindrome");
	}
	else {
		
		System.out.println("number is not palindrome");
	}

	}

}
