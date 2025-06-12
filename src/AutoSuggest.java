import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutoSuggest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		
		List<WebElement> countries = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		//FOR-EACH LOOP
		for (WebElement country : countries) {
			System.out.println(country.getText());
			
			if(country.getText().equalsIgnoreCase("India")) {
				country.click();
			}
		}
		
		//FOR LOOP
//		for (int i=0; i<countries.size(); i++) {
//			
//			if(countries.get(i).getText().equalsIgnoreCase("India")) {
//				countries.get(i).click();
//			}
//		}
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id, 'SeniorCitizenDiscount')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id, 'SeniorCitizenDiscount')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id, 'SeniorCitizenDiscount')]")).isSelected());
		
		
		driver.findElement(By.xpath("//input[contains(@id, 'view_date1')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@class, 'ui-state-active')]")).click();
		
		Boolean styleAttr = driver.findElement(By.id("Div1")).getDomAttribute("style").contains("opacity: 0.5");
		System.out.println(styleAttr);
	}

}
