package poOrangeHRM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends LoadableComponent<AdminPage> {

	@FindBy (xpath = "//button[text()=\" Save \"]")
	WebElement saveRecord;
	
	@FindBy (xpath = "//div[@id='oxd-toaster_1']//p[(text()='Success')]")
	WebElement saveRecordSuccessMessage;
	
	@FindBy (xpath = "//div[@role='document']//button[2]")
	WebElement deleteConfirm;

	WebDriver driver;
	WebDriverWait wait;

	public AdminPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		get();

	}

	public AdminPage editAdminRecord(String username) {
		
		String editRecordXpath = String.format("//div[text()='%s']/parent::div/parent::div//div[6]//button[2]", username);
		WebElement editRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editRecordXpath)));
		editRecord.click();
		wait.until(ExpectedConditions.visibilityOf(saveRecord)).click();
		String successMessage = wait.until(ExpectedConditions.visibilityOf(saveRecordSuccessMessage)).getText();
		assertEquals(successMessage, "Success");
		return this;

	}

	public AdminPage deleteAdminRecord(String username) {
		
		String deleteRecordXpath = String.format("//div[text()='%s']/parent::div/parent::div//div[6]//button", username);
		WebElement deleteRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteRecordXpath)));
		deleteRecord.click();
		
		wait.until(ExpectedConditions.visibilityOf(deleteConfirm)).click();
		String successMessage = wait.until(ExpectedConditions.visibilityOf(saveRecordSuccessMessage)).getText();
		assertEquals(successMessage, "Success");
		return this;

	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(), "OrangeHRM", "Orange HRM dashboard page not loaded");

	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}

}
