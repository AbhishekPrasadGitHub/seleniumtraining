package scripts;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverCommands {

	WebDriver driver;

	@Test
	public void loginToNicheThyselfTourism() {
		driver.get("https://nichethyself.com/tourism/home.html");
		driver.getCurrentUrl();
		driver.getTitle();
		String pagesource = driver.getPageSource();
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("http://google.com");
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		driver.manage().window().minimize();
		driver.manage().window().getPosition();
		driver.manage().window().setPosition(new Point(70, 70));
		driver.manage().window().getSize();
		driver.manage().window().setSize(new Dimension(500, 400));
		
		
		assertEquals(1,1);

	}

	@BeforeClass
	public void setupDB() {
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeDriver() {
//		driver.quit();
	}

}
