package scripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverAssignments {

	//in dev branch
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
		
	
	}
	
	//OrangeHRM
//	@Test
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
	
	//Wikipedia
//	@Test
	public void wikipedia() throws InterruptedException {
		driver.get("https://www.wikipedia.org/");
		driver.findElement(By.xpath("//a[@id='js-link-box-en']")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Search Wikipedia'])[1]")).sendKeys("Selenium");
		driver.findElement(By.xpath("(//button[text()='Search'])[1]")).click();
		String Title = driver.getTitle();
		assertEquals(Title, "Selenium - Wikipedia");
		
	}
	
	//DemoQA site fill form
	@Test
	public void demoQA() throws InterruptedException {
		driver.get("https://demoqa.com/automation-practice-form");
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Abhishek");
		driver.findElement(By.cssSelector("#lastName")).sendKeys("Prasad");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("abhishek.jisce@gmail.com");
		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]")).click();
		driver.findElement(By.cssSelector("#userNumber")).sendKeys("9767957965");
		driver.findElement(By.cssSelector("#dateOfBirthInput")).click();
		WebElement monthSelector = driver.findElement(By.cssSelector(".react-datepicker__month-select"));
		Select month = new Select(monthSelector);
		month.selectByVisibleText("March");
		WebElement yearSelector = driver.findElement(By.cssSelector(".react-datepicker__year-select"));
		Select year = new Select(yearSelector);
		year.selectByVisibleText("1989");
		
		driver.findElement(By.xpath("(//div[@class='react-datepicker__week'])[3]//div[text()='15']")).click();
		
		WebElement subject = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
		subject.sendKeys("Computer Science");
		subject.sendKeys(Keys.ENTER);
		
		driver.findElement(By.cssSelector("#hobbies-checkbox-1")).click();
		driver.findElement(By.cssSelector("#hobbies-checkbox-3")).click();
		
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
//		driver.quit();
	}

}
