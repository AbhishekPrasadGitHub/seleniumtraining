package powithpagefactory;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MyAccountPage extends LoadableComponent<MyAccountPage>{
	
	@FindBy (xpath = "//button[text()='Contact us!']")
	private WebElement contactUs;
	
	@FindBy (xpath = "//a[@href='home.html']")
	private WebElement signOut;
	
	@FindBy (xpath = "(//a[contains(text(),'Edit')])[1]")
	private WebElement editTableFirstRow;
	
	private WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
		
	}
	
	public MyAccountPage goToContactUs() {
		contactUs.click();	
		return this;
	}
	
	public STCTourism signOut() {
		signOut.click();
		return new STCTourism(driver);
	}
	
	public MyAccountPage editFirstRecord() {
		editTableFirstRow.click();
		driver.switchTo().alert().accept();
		return this;
	}
	
	public void closeBrowser() {
		driver.quit();
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(), "My account", "My account page not loaded");
	}

	@Override
	protected void load() {
		
		
	}

}
