package demoflikarttest;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshotdemo {
	
	WebDriver driver;
	@Test
	public void performSlidingAction() {
	driver=new ChromeDriver();
	//driver.navigate().to("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/#google_vignette");
	driver.navigate().to("https://www.flipkart.com/");	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File sourceFile= ts.getScreenshotAs(OutputType.FILE);
	File targetFile=new File(System.getProperty("user.dir")+"\\Screenshots\\fullpage.png");
	sourceFile.renameTo(targetFile);
	
	
	
	
	
	
	
	
	
	
	}
}
