import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EcommerceAppRefactor {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<String> pickedItems = Arrays.asList("Cucumber", "Beans", "Brinjal");

		addToCart(driver, pickedItems);
		
		checkout(driver, "rahulshettyacademy");

		endTest(driver);

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

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();

		List<WebElement> itemsInCart = driver.findElements(By.xpath("//div[@class='cart-preview active']//div[@class='product-info']"));
		for (int i = 0; i < itemsInCart.size(); i++) {
			
			String itemName = itemsInCart.get(i).getText().split("-")[0].trim();
			
			System.out.println(itemName + " is found in the cart");					
			
			if(!pickedItems.contains(itemName)) {
				
				System.out.println(itemName + " doesn't exist in the cart");
				
				Assert.assertTrue(false);
			}
		}

	}
	
	
	public static void checkout(WebDriver driver, String promoCode) {
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCOde")).sendKeys(promoCode);
	}

	public static void endTest(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
