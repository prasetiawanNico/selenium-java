import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='blinkingText'][1]")));
		
		driver.findElement(By.xpath("//a[@class='blinkingText'][1]")).click();
		
		// Dapetin dulu ID dari tiap-tiap tab/windows nya
		Set<String> tabs = driver.getWindowHandles();
		
		// Setelah itu iterate semua tabs/windows yang udah didapetin sebelumnya
		Iterator<String> tab = tabs.iterator();
		
		String parentTab = tab.next();
		String childTab = tab.next();
		
		driver.switchTo().window(childTab);
		String kalimat = driver.findElement(By.cssSelector("p.im-para.red")).getText();
		
		int start = kalimat.indexOf("at ") + 3;
		int end = kalimat.indexOf(" with");
		
		String email = kalimat.substring(start, end);
		
		driver.switchTo().window(parentTab);
		driver.findElement(By.id("username")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys("yayayaya");

	}

}
