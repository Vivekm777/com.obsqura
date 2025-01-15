package demopack;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class logintest {
	WebDriver driver;
	@BeforeMethod
	public void loginin() {
	
	
	driver=new ChromeDriver();
	driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
		
	}
	
	
	@Test(priority =1,groups = {"sanity"})
	public void urlverification() {
		
	String url=	driver.getCurrentUrl(); 
	Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test( priority=2,     groups = {"regression"})
	public void gettitle(){
		String title=driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
		
		
	}
	
	

}
