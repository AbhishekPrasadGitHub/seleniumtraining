package powithpagefactory;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestYourSetupPOPageFactory {
    STCTourism myHomePage;
    MyAccountPage myAcc;

//	@Test
	public void loginToNicheThyselfTourism() {
		myHomePage.login("stc123", "12345");
		String expectedValueTitle = "My account";
		String actualValueTitle = myHomePage.getTitleAfterLogin();
		assertEquals(actualValueTitle,expectedValueTitle);
	}
	
	@Test
	public void loginAndGotoContactUsAndSignOut() throws InterruptedException {
		myHomePage.login("stc123", "12345")
		          .goToContactUs()
		          .editFirstRecord()
		          .signOut();
		
		Thread.sleep(3000);
		
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
