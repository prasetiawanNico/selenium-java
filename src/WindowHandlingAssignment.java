import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlingAssignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a[href=\"/windows/new\"]")));
		
		driver.findElement(By.cssSelector("a[href=\"/windows/new\"]")).click();
		
		List<String> windows = new ArrayList<>(driver.getWindowHandles());
		
		String parentWindow = windows.get(0);
		String childWindow = windows.get(1);
		
		driver.switchTo().window(childWindow);	
		
		String targetedElement1 = driver.findElement(By.xpath("//h3[text()= 'New Window']")).getText();
		System.out.println(targetedElement1);
		
		driver.switchTo().window(parentWindow);
		String targetedElement2 = driver.findElement(By.cssSelector("h3")).getText();
		System.out.println(targetedElement2);
		

	}

}
