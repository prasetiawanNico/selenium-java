import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SynchronizationAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		// to turn off ""password_manager_leak_detection"".
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		Map<String, Object> profile = new HashMap<String, Object>();
		profile.put("password_manager_leak_detection", false);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		
		fillData(driver, wait);
		signIn(driver, wait);
		addAllItemToCart(driver);
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void fillData(WebDriver driver, WebDriverWait wait) {
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//span[contains(text(), 'User')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-body")));
		driver.findElement(By.id("okayBtn")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.modal-body")));
		
		WebElement option = driver.findElement(By.cssSelector("select.form-control"));
		Select options = new Select(option);
		options.selectByValue("consult");
		
		driver.findElement(By.id("terms")).click();
		Assert.assertTrue(driver.findElement(By.id("terms")).isSelected());
		
	}
	
	
	public static void signIn(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("carouselExampleIndicators")));
	}
	
	public static void addAllItemToCart(WebDriver driver) {
		List<WebElement> allProducts = driver.findElements(By.cssSelector("button.btn"));
		
		for(int i=0; i<allProducts.size(); i++) {
			WebElement product = allProducts.get(i);
			product.click();
		}
	}
	
	

}
