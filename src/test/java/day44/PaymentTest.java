package day44;

import org.testng.annotations.Test;

public class PaymentTest {
	
	@Test(priority = 1,groups = {"sanity","regression","functional"})
	public void paymentbygooglepay() {
		
		System.out.println("payment with googlepay");
		
	}
	
	
	@Test(priority = 2,groups = {"sanity","regression","functional"})
	public void paymentbyamxzn() {
		
		System.out.println("payment with amazon");
		
	}
	
	@Test(priority = 3,groups= {"sanity","regression","functional"})
	public void paymentbypaytm() {
		
		System.out.println("payment with paytm");
		
	}

}

	


