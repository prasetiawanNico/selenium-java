import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class SeleIntr {

	public static void main(String[] args) {
//		System.setProperty("webdriver.edge.driver", "C:/Users/GPay-User/OneDrive - (G)Tech Digital/Desktop/msedgedriver.exe");
//		
//		WebDriver driver = new EdgeDriver();
//		
//		driver.get("https://rahulshettyacademy.com/");
//		
//		String title = driver.getTitle();
//		String url = driver.getCurrentUrl();
//		
//		System.out.println("Title: " + title + ", URL: " + url);
//		
//		driver.close();
		
		
		int[] arr = {1,2,3,4,5};
		for (int i=0; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
		
		String[] name = {"nico", "Prasetiawan", "$IA17"}; 
		
		for (String n : name ) {
			System.out.println(n);
		}
		
		System.out.println("---------------------------------------");
		
		int[] arrs = {1,2,3,4,5,6,7,8,9,10};
		
		for (int i = 0; i < arrs.length; i++) {
			if (arrs[i] % 2 == 0) {
				System.out.println(arrs[i]);
			}
		}
		
		System.out.println("---------------------------------------");
		
	    int[] numbers = {1,2,3,4,5};
	    
	    System.out.println(numbers[0]);
	    System.out.println(numbers[4]);
	    
	    for (int i = numbers.length - 1; i >= 0; i--) {
	    	System.out.println(numbers[i]);
	    }
	    
	    System.out.println("---------------------------------------");
	    
	    
	    ArrayList<String> friends = new ArrayList<String>();
	    
	    Collections.addAll(friends, "Dhea", "Lafitri", "Prasetiawan");
	   
	    
	    String lastName = friends.get(2);
	    System.out.println(lastName + " " + arr[1] + " " + friends.size());
	    

	    SeleIntr dd = new SeleIntr();
	    dd.getData();
	    
	    Methods ee = new Methods();
	    String res = ee.getUserData();
	    System.out.println(res);

		
	}
	public void getData() {
		System.out.println("WHYYYYYYYYYY");
	}

}