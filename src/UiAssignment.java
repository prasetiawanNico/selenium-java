import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UiAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("Joyco");
		driver.findElement(By.name("email")).sendKeys("joyco@email.com");
		
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("12345");
		
		driver.findElement(By.id("exampleCheck1")).click();
		Assert.assertTrue(driver.findElement(By.id("exampleCheck1")).isSelected());
		
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		
		WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(gender);
		dropdown.selectByVisibleText("Female");
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Female");
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		driver.findElement(By.name("bday")).sendKeys("28091993");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(1000);
		
		String txt = driver.findElement(By.xpath("//div[contains(@class, 'success alert')]")).getText();
		System.out.println(txt);
	}

}
