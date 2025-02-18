package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class STCTourism {

	private WebElement username;
	private WebElement password;
	private WebElement submit;
	private WebDriver driver;

	public STCTourism() {
		driver = new ChromeDriver();
		driver.get("https://nichethyself.com/tourism/home.html");

	}

	public void login(String user, String pass) {
		username = driver.findElement(By.name("username"));
		username.sendKeys(user);
		password = driver.findElement(By.name("password"));
		password.sendKeys(pass);
		submit = driver.findElement(By.xpath("//form[@name='loginform']//button"));
		submit.click();

	}

	public String getTitleAfterLogin() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.quit();
	}
}
