package po;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestYourSetupPO {
    STCTourism myHomePage;

	@Test
	public void loginToNicheThyselfTourism() {
		myHomePage.login("stc123", "12345");
		String expectedValueTitle = "My account";
		String actualValueTitle = myHomePage.getTitleAfterLogin();
		assertEquals(actualValueTitle,expectedValueTitle);
		
	}

	@BeforeMethod
	public void setup() {
            myHomePage = new STCTourism();
	}
	
	@AfterMethod
	public void closeDriver() {
		myHomePage.closeBrowser();
	}

}
