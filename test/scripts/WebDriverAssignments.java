package scripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverAssignments {

	WebDriver driver;

	//Google Link print
//	@Test
	public void googleLinksCheck() {
		driver.get("https://google.com");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println("Number of links on google.com home page: " + allLinks.size());

		for (WebElement oneElement : allLinks) {
			System.out.println(oneElement.getText() + " - " + oneElement.getDomAttribute("href"));
		}
		assertEquals(1,1);
		
	
	}
	
	@Test
	public void openSourceDemo() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
//		driver.switchTo().alert().accept();
		String Dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		assertEquals(Dashboard, "Dashboard");
		
	}

	@BeforeClass
	public void setupDB() {
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().getCookies();
	}

	@AfterClass
	public void closeDriver() {
		// driver.quit();
	}

}
