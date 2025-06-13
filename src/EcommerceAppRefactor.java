import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceAppRefactor {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Running main method...");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		
		List<String> pickedItems = Arrays.asList("Cucumber", "Beans", "Brinjal");
		
		addToCart(driver, pickedItems);


		Thread.sleep(2000);
		driver.quit();

	}
	
	public static void addToCart(WebDriver driver, List<String> pickedItems) {
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
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
		
	}

}
