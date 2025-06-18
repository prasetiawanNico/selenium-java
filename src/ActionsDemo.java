import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
		
		WebElement myEbay = driver.findElement(By.xpath("//span[contains(@class, 'gh-rvi-menu') and contains(text(), 'My eBay')]"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(myEbay));
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(myEbay).contextClick().build().perform();
		
		builder.moveToElement(driver.findElement(By.cssSelector("input#gh-ac"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		
		
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
