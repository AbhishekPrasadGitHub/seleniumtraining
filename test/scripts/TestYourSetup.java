package scripts;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestYourSetup {

	WebDriver driver;
	WebElement element;

	@Test
	public void loginToNicheThyselfTourism() {
		driver.get("https://nichethyself.com/tourism/home.html");
		WebElement username = driver.findElement(By.name("username"));
		//'findElement' is a method of ChromeDriver, WebDriver Interface
		//'By' is a class, 
		//name is a static method of 'By' Class
		//findElement have 'By' class Object as parameter
		//'findElement' return type is WebElement
		
		username.sendKeys("stc123");
		driver.findElement(By.name("password")).sendKeys("12345");
        
		username.submit(); // submitting the form
		
		String expectedValueTitle = "My account";
		String actualValueTitle = driver.getTitle();
		assertEquals(actualValueTitle,expectedValueTitle);
		
		//stc123, 12345

		
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}

}
