package testpackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class orangeHRM {
	public String Url = "https://opensource-demo.orangehrmlive.com/";
	public String driverPath = "D://chromedriver.exe";
	public WebDriver driver;
	
	@DataProvider
    Object[][] testData() {
        return new Object[][]{
                {"Admin", "admin123"}
        };
    }
	
	@BeforeClass
	public void BeforeTest() {
		System.out.println("Before Test");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();				
	}
	
	@Test (priority = 0)
	public void TestNav() {
		driver.get(Url);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test (priority = 1, dataProvider = "testData")
	public void TestLogin(String username, String password) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement elementInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		elementInput.sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test (priority = 2)
	public void TestGetUsername() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String getUsername = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).getText();
		System.out.println(getUsername);		
		Assert.assertNotEquals(getUsername, "");
	}
	
	@Test (priority = 3)
	public void TestNavtoAdmin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Admin']")));
		String verifyAdminPage = driver.getCurrentUrl();
		System.out.println(verifyAdminPage);
		Assert.assertEquals(verifyAdminPage, "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");		
	}
	
	@AfterClass
	public void AfterTest() {
		driver.quit(); 
		System.out.println("After Test");
	}
	
}
