package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NewTest {
	public String Url = "https://www.javatpoint.com/";
	public String driverPath = "D://chromedriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	public void BeforeTest() {
		System.out.println("Before Test");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
	}
	
	@Test
	public void Test() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@AfterTest
	public void AfterTest() {
		System.out.println("After Test");
		driver.quit();
	}

}
