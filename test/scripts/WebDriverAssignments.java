package scripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Main Branch changes
public class WebDriverAssignments {

	// in dev branch
	WebDriver driver;
	WebDriverWait wait;

	// Google Link print
//	@Test
	public void googleLinksCheck() {
		driver.get("https://google.com");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println("Number of links on google.com home page: " + allLinks.size());

		for (WebElement oneElement : allLinks) {
			System.out.println(oneElement.getText() + " - " + oneElement.getDomAttribute("href"));
		}

	}

	// OrangeHRM
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

	// Wikipedia
//	@Test
	public void wikipedia() throws InterruptedException {
		driver.get("https://www.wikipedia.org/");
		driver.findElement(By.xpath("//a[@id='js-link-box-en']")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Search Wikipedia'])[1]")).sendKeys("Selenium");
		driver.findElement(By.xpath("(//button[text()='Search'])[1]")).click();
		String Title = driver.getTitle();
		assertEquals(Title, "Selenium - Wikipedia");

	}

	// DemoQA site fill form
//	@Test
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

		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[4]")).click();
		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[6]")).click();

		boolean drodpdownCheck = driver.findElement(By.xpath("//div[@id='city']")).isSelected();
		assertEquals(drodpdownCheck, false);

	}

	// herokuapp
//	@Test
	public void herokuappDropdown() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dropdown");
		WebElement dropdownList = driver.findElement(By.xpath("//select[@id = 'dropdown']"));
		Select dropdown = new Select(dropdownList);
		dropdown.selectByVisibleText("Option 1");
		dropdown.selectByVisibleText("Option 2");
	}

	// goibibo assignment
	@Test
	public void goibibo() throws InterruptedException {
		driver.get("https://www.goibibo.com/");
		// driver.findElement(By.xpath("//div[@data-id='auth-flow-section']//span[contains(@class,
		// 'icClose')]")).click();

		WebElement loginInPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(
				(By.xpath("//div[@data-id='auth-flow-section']//span[contains(@class, 'icClose')]"))));
		loginInPopUp.click();
		WebElement FromInputField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[text()='Enter city or airport'])[1]")));
		FromInputField.click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Pun");
		driver.findElement(By.xpath("//span[contains(text(),'Pune')]")).click();
		driver.findElement(By.xpath("(//span[text()='To'])[2]/following::input[@type='text']")).sendKeys("Del");
		WebElement selectToCity = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@tabindex='0']")));
		selectToCity.click();
		driver.findElement(By.xpath("(//span[contains(@class, 'fswDownArrow')])[1]")).click();
		WebElement nextMonth = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='Next Month']")));
		nextMonth.click();
		WebElement FromDateSelect = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Fri Apr 04 2025']")));
		FromDateSelect.click();
		driver.findElement(By.xpath("//p[text()='Round-trip']")).click();
		driver.findElement(By.xpath("(//span[contains(@class, 'DownArrow')])[2]")).click();
		WebElement returnDateSelect = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Tue Apr 08 2025']")));
		returnDateSelect.click();
		driver.switchTo().frame("webpush-onsite");
		driver.findElement(By.xpath("//button[@id='deny']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//p[contains(text(),'1 Adult')]")).click();
		WebElement noOfAdultSelection = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(("(//span[contains(@class,'sc-12foipm-51 kZvHQU')])[2]"))));
		noOfAdultSelection.click();
		driver.findElement(By.xpath("//li[text()='business']")).click();
		WebElement done = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Done']")));
		done.click();

		WebElement searchFlights = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='SEARCH FLIGHTS']")));
		searchFlights.click();
		
//		driver.findElement(By.xpath("//div[contains(@class,'center')]//button")).click();
		
		WebElement book = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value = 'Book']")));
				book.click();
		
		WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = 'Next']")));
		next.click();
		
		String mainWindowHandle = driver.getWindowHandle();
		
		WebElement proceed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = 'Proceed']")));
		proceed.click();
		
		Set <String> ibiboWindowHandle = driver.getWindowHandles();
		
		for (String handle : ibiboWindowHandle) {
			if(!handle.equals(mainWindowHandle)) {
				
				driver.switchTo().window(handle);
				break;
			}
			
		}
		String reviewBookingText = driver.findElement(By.xpath("//div[contains(text(),'Review')]")).getText();
		
		assertEquals(reviewBookingText, "Review your booking");

	}

	@BeforeClass
	public void setupDB() {
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		driver.manage().getCookies();
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}

}
