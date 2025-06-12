import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GPay-User\\OneDrive - (G)Tech Digital\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().fullscreen();
		driver.navigate().to("https://www.facebook.com/");
		driver.navigate().back();		
		
		
	}

}
