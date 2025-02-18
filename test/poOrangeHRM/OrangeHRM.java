package poOrangeHRM;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRM extends LoadableComponent<OrangeHRM>{

	@FindBy (name = "username")
	private WebElement username;
	
	@FindBy (name = "password")
	private WebElement password;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement submit;
	
	@FindBy (xpath = "//h6[text()='Dashboard']")
	private WebElement DashboardLabel;

	private WebDriver driver;
	private WebDriverWait wait;

	public OrangeHRM() {
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		get();
	}
	
	public OrangeHRM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	public DashboardOrangeHRM login(String user, String pass) {
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
		wait.until(ExpectedConditions.visibilityOf(submit)).click();
		DashboardOrangeHRM myDashboard = new DashboardOrangeHRM(driver, wait);
		return myDashboard;

	}

	public String getDashboardLabelAfterLogin() {
		return wait.until(ExpectedConditions.visibilityOf(DashboardLabel)).getText();
	}

	public void closeBrowser() {
		driver.quit();
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(), "OrangeHRM", "Orange HRM page not loaded");

		
	}

	@Override
	protected void load() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
}
