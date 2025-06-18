import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		;

		int totalLink = driver.findElements(By.tagName("a")).size();
		System.out.println(totalLink);

		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		int footerLink = footerDriver.findElements(By.tagName("a")).size();
		System.out.println(footerLink);

		WebElement footerDiscountFooter = footerDriver.findElement(By.xpath("//table//tbody/tr/td[1]/ul"));
		int footerDiscountFooterLink = footerDiscountFooter.findElements(By.tagName("a")).size();
		System.out.println(footerDiscountFooterLink);

		for (int i = 1; i < footerDiscountFooterLink; i++) {

			String openInTheNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			footerDiscountFooter.findElements(By.tagName("a")).get(i).sendKeys(openInTheNewTab);

			Thread.sleep(2000);
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();

		while (window.hasNext()) {
			driver.switchTo().window(window.next());
			System.out.println(driver.getTitle());
		}

	}

}
