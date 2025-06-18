import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scope2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");

			WebElement targetedFooterDriver = driver
					.findElement(By.xpath("//div[@id='gf-BIG']//table//tbody/tr/td[1]/ul"));

			List<WebElement> anchorLinks = targetedFooterDriver.findElements(By.tagName("a"));

			String openInTheNewTab;
			if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				openInTheNewTab = Keys.chord(Keys.COMMAND, Keys.RETURN);
			} else {
				openInTheNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			}

			// validate all the anchors started from index 1 can be opened and get the title
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			

			for (int i = 1; i < anchorLinks.size(); i++) {
				int initialWindowCount = driver.getWindowHandles().size();
				
				anchorLinks.get(i).sendKeys(openInTheNewTab);

				wait.until((WebDriver a) -> a.getWindowHandles().size() > initialWindowCount);
			}

			Set<String> windowHandles = driver.getWindowHandles();
//			Iterator<String> window = windowHandles.iterator();
//			while (window.hasNext()) {
//				driver.switchTo().window(window.next());
//				System.out.println(driver.getTitle());
//			}
			for (String handle : windowHandles) {
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
