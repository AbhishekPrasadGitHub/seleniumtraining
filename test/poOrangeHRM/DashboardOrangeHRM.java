package poOrangeHRM;

import static org.testng.Assert.assertEquals;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardOrangeHRM extends LoadableComponent<DashboardOrangeHRM> {

	@FindBy(xpath = "//span[text()='Admin']")
	WebElement admin;

	@FindBy(xpath = "//h6[text()='User Management']")
	WebElement adminLabel;

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']//i")
	WebElement userOption;

	@FindBy(xpath = "//ul[@role='menu']//a[text()='Logout']")
	WebElement logout;

	WebDriver driver;
	WebDriverWait wait;

	public DashboardOrangeHRM(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		get();

	}

	public AdminPage goToAdmin() {
		wait.until(ExpectedConditions.visibilityOf(admin)).click();
		AdminPage myAdmin = new AdminPage(driver, wait);
		return myAdmin;

	}

	public OrangeHRM logout() {
		wait.until(ExpectedConditions.visibilityOf(userOption)).click();
		wait.until(ExpectedConditions.visibilityOf(logout)).click();
		return new OrangeHRM(driver);

	}
	
	public void closeBrowser() {
		driver.quit();
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(), "OrangeHRM", "Orange HRM dashboard page not loaded");

	}

	@Override
	protected void load() {
//		wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));

	}

}
