package powithpagefactory;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class STCTourism extends LoadableComponent<STCTourism> {

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//form[@name='loginform']//button")
	private WebElement submit;

	private WebDriver driver;

	public STCTourism() {
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		get();
	}

	public STCTourism(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		get();
	}

	public MyAccountPage login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
		MyAccountPage myAccPage = new MyAccountPage(driver);
		return myAccPage;
	}

	public String getTitleAfterLogin() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.quit();
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(), "STC Tourism", "STC Tourism page not loaded");

	}

	@Override
	protected void load() {
		driver.get("https://nichethyself.com/tourism/home.html");

	}
}
