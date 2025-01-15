package demoflikarttest;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenshotFullDemo {
	
	WebDriver driver;

	@Test
	public void takescreenshotofWebsite(){
	driver=new ChromeDriver();
	driver.navigate().to("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	TakesScreenshot ts=(TakesScreenshot)driver;
	File sourceFile= ts.getScreenshotAs(OutputType.FILE);
	File targetFile=new File(System.getProperty("user.dir")+"\\Screenshots\\testautomation.png");
	sourceFile.renameTo(targetFile);
	
	
	






	}














}
