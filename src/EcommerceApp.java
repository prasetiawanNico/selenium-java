import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceApp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));

		String[] pickedItems = { "Cauliflower", "Cucumber" };
		
		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			String product = products.get(i).getText().split("-")[0].trim();

			List<String> pickedItemsList = Arrays.asList(pickedItems);

			if (pickedItemsList.contains(product)) {
				System.out.println("Found " + product + " at index " + i);
				driver.findElements(By.xpath("(//div[@class='product-action']//button)")).get(i).click();
//				driver.findElement(By.xpath("(//button[text()= 'ADD TO CART'])[" + (i + 1) + "]")).click();
				
				if(j == pickedItems.length) {
					break;
				}
			}
			;
		}

		Thread.sleep(3000);
		driver.quit();

	}

}
