import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GPay-User\\OneDrive - (G)Tech Digital\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		
		String password = getPass(driver);
		
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("inputUsername")).sendKeys("Nico");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/form/button")).click();
		
		driver.findElement(By.id("chkboxOne")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		String logedIn = driver.findElement(By.xpath("//p[normalize-space()='You are successfully logged in.']")).getText();
		System.out.println(logedIn);
		
		Assert.assertEquals(logedIn,"You are successfully logged in.");
		
//		Thread.sleep(2000);
		
		driver.close();
	}
	
	public static String getPass(WebDriver driver) {
		String errMessage = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		System.out.println(errMessage);
		
		String[] splitedMsg = errMessage.split("'");
		System.out.println(splitedMsg[1]);
		
		return splitedMsg[1];
	}

}
