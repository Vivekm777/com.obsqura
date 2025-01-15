package demoflikarttest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ThreeWindows {
	
	 public WebDriver driver;

	    @Test
	    public void addProductToCart() {

	        // Initialize driver and open website
	        driver = new ChromeDriver();
	        driver.navigate().to("https://www.flipkart.com/");
	        driver.manage().window().maximize();

	        // Search for iPhone
	        WebElement searchfield = driver.findElement(By.xpath("//input[contains(@title,'Search for Products, Brands and More')]"));
	        searchfield.sendKeys("Iphone");
	        WebElement searchbutton = driver.findElement(By.xpath("//button[contains(@title,'Search for Products, Brands and More')]"));
	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        executor.executeScript("arguments[0].click()", searchbutton);

	        // Select iPhone 15 Plus (Green, 128 GB) - First Product
	        WebElement iphone = driver.findElement(By.xpath("//div[contains(text(),'Apple iPhone 15 Plus (Green, 128 GB)')]"));
	        executor.executeScript("arguments[0].click()", iphone);

	        // Handle windows
	        String parent = driver.getWindowHandle(); // Get parent window handle
	        List<String> windows = new ArrayList<>(driver.getWindowHandles()); // Convert handles to List

	        // Switch to First Child Window
	        driver.switchTo().window(windows.get(1));
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        executor.executeScript("window.scrollBy(0,300)");
	        WebElement addToCart1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='col col-6-12 ']/button")));
	        addToCart1.click();

	        // Switch back to Parent Window
	        driver.switchTo().window(parent);
	        driver.navigate().refresh();

	        // Search for another product (Second Product)
	        WebElement iphone2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Apple iPhone 15 Plus (Pink, 128 GB)')]")));
	        executor.executeScript("arguments[0].click()", iphone2);

	        // Handle Third Window (Second Child Window)
	        windows = new ArrayList<>(driver.getWindowHandles()); // Refresh window handles
	        driver.switchTo().window(windows.get(2)); // Switch to third window
	        executor.executeScript("window.scrollBy(0,300)");
	        WebElement addToCart2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='col col-6-12 ']/button")));
	        addToCart2.click();

	        // Return to Parent Window and Refresh
	        driver.switchTo().window(parent);
	        driver.navigate().refresh();

	        // Close all child windows and quit the driver
	        for (String window : windows) {
	            if (!window.equals(parent)) {
	                driver.switchTo().window(window);
	                driver.close(); // Close child window
	            }
	        }
	        driver.switchTo().window(parent); // Switch back to parent
	        driver.quit(); // Close parent window
	    }
	}




