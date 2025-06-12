import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceAppRefactor {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		List<String> pickedItems = Arrays.asList("Cucumber", "Beans", "Brinjal");

		int addCOunt = 0;
		for (int i = 0; i < products.size(); i++) {
			String productName = products.get(i).getText().split("-")[0].trim();

			if (pickedItems.contains(productName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				addCOunt++;

				if (addCOunt == pickedItems.size()) {
					break;
				}
				;
			}
		}

		Thread.sleep(2000);
		driver.quit();

	}

}
