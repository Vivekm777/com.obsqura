package day44;

import org.testng.annotations.Test;

public class LoginTest {

@Test(priority = 1,groups = {"sanity"})	
public void loginByGoogle()	{
	
System.out.println("login by google");	
	
	
}
	
@Test(priority = 2, groups = {"sanity"},enabled = false)	//enabled=false skip the testcase
public void loginByInstagram()	{
	
	
System.out.println("Login by instagram");	
	
}	
	
@Test(priority = 3,groups = { "sanity"})	
public void loginByFacebook()	{
	
	System.out.println("Login by facebook");
	
	
}	
	
@Test(priority = 4,groups = {"sanity"})		
public void loginByTwitter()	{
	
System.out.println("login by twittwer");	
	
	
}	
	
	
	
	
	
	
}
