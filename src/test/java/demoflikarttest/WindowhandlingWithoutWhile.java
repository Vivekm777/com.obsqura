package demoflikarttest;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WindowhandlingWithoutWhile {
	public WebDriver driver;

	@Test
	public void productAdditionToCart() throws InterruptedException {

		driver = new ChromeDriver();
		driver.navigate().to("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebElement searchfield = driver.findElement(By.xpath("//input[contains(@title,'Search for Products, Brands and More')]"));
		searchfield.sendKeys("Iphone");
		WebElement searchbutton = driver.findElement(By.xpath("//button[contains(@title,'Search for Products, Brands and More')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", searchbutton);
		WebElement iphone = driver.findElement(By.xpath("//div[text()='Apple iPhone 15 (Black, 128 GB)']"));
		iphone.click();
		Set<String> windowhandle = driver.getWindowHandles();
		Iterator<String> i1 = windowhandle.iterator();
		String parentwindow = i1.next();
		String firstchildwindow = i1.next();
		driver.switchTo().window(firstchildwindow);
		executor.executeScript("window.scrollBy(0,500)");
		WebElement addtoCart = driver.findElement(By.xpath("//button[contains(@class,'QqFHMw vslbG+ In9uk2')]"));
		addtoCart.click();
		driver.switchTo().window(parentwindow);
		WebElement cart=driver.findElement(By.xpath("//a[@class='_9Wy27C']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cart));
		driver.navigate().refresh();
		
		

	}
}
