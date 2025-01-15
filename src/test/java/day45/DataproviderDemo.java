package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderDemo {
WebDriver driver;//instance
@BeforeClass
void setup() {
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}

@Test(dataProvider = "dp")
void testLogin(String username,String password) {
	driver=new ChromeDriver();
    driver.navigate().to("https://www.saucedemo.com/");
   // Dimension dimension=new Dimension(1500,900);
  //  driver.manage().window().setSize(dimension);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
	driver.findElement(By.id("user-name")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	WebElement loginbutton=driver.findElement(By.xpath("//div[@class='error-message-container']/following-sibling::input"));
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click()", loginbutton);
	WebElement swagLabs_logo=driver.findElement(By.xpath("//div[contains(text(),'Swag')]"));
	boolean isswagLabs_logodisplayed=swagLabs_logo.isDisplayed();
	if(isswagLabs_logodisplayed==true) {
		
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Assert.assertTrue(true);
	}
	else {
		
	Assert.fail();
	}
	
}

@AfterClass
void tearDown() {
		
	driver.close();	
}
@DataProvider(name = "dp")
Object loginTestData() {//creation of testdata and return testdata ,can be created in begining and at the end
	
	Object data[][]= {
			{"standard_user","secret_sau"},
	
			{"standard_use","secret_sau"},
			
			{"standard_use","secret_sauce"},
			{"standard_user","secret_sauce"},
	
	
	};
	//inside this we can pass mulltipleusername and password
	
	return data;   //return type of dataprovider is object[][](two dimensional object type of array)
	
}



}
