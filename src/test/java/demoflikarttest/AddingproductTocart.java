package demoflikarttest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddingproductTocart {
	
	public WebDriver driver;
   @Test
	public void productAdditionToCart()
	{
	
	driver=new ChromeDriver();
	driver.navigate().to("https://www.flipkart.com/");
	driver.manage().window().maximize();
	WebElement  searchfield=driver.findElement(By.xpath("//input[contains(@title,'Search for Products, Brands and More')]"));
	searchfield.sendKeys("Iphone");
	WebElement searchbutton=driver.findElement(By.xpath("//button[contains(@title,'Search for Products, Brands and More')]"));
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click()",searchbutton);
	WebElement iphone=driver.findElement(By.xpath("//div[text()='Apple iPhone 15 (Black, 128 GB)']"));
	iphone.click();
	String parent=driver.getWindowHandle();//current window handle address
	Set<String> s=driver.getWindowHandles();//to get all window handle addresss
	Iterator<String>i1=s.iterator();
	while(i1.hasNext()) {  //i1 compartment  set tab is there any value          
	String childWindow=i1.next();//child window address store
	if(!parent.equals(childWindow))//verify child window/parent window address same
	{
	driver.switchTo().window(childWindow);	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, 500)");
    WebElement addtoCart=driver.findElement(By.xpath("//button[contains(@class,'QqFHMw vslbG+ In9uk2')]"));
	addtoCart.click();
	

	
	}
	
	
	/*
	WebElement filters=driver.findElement(By.xpath("//span[text()='Filters']"));
	String actualResult=filters.getText();
	String expectedresult="Filters";
	Assert.assertEquals(actualResult,expectedresult);
	*/
	}
	
	driver.switchTo().window(parent);
	driver.navigate().refresh();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
	
	WebElement filters=driver.findElement(By.xpath("//span[text()='Filters']"));
	String actualResult=filters.getText();
	String expectedresult="Filters";
	AssertJUnit.assertEquals(actualResult,expectedresult);
	}
/*
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[contains(@class,'b5rp0W')])[1]"))));
	
	WebElement price=driver.findElement(By.xpath("(//span[contains(@class,'b5rp0W')])[1]"));
	String actualResult=price.getText();
	String expectedresult="₹69,900";
	Assert.assertEquals(actualResult,expectedresult);
*/	
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	


