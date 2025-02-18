package poOrangeHRM;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestOrangeHRMPO {
    OrangeHRM myHomePage;
    DashboardOrangeHRM myDashboard;
    AdminPage myAdmin;

//	@Test
	public void loginToOrangeHRM() {
		myHomePage.login("Admin", "admin123");
		String expectedValueTitle = "Dashboard";
		String actualValueTitle = myHomePage.getDashboardLabelAfterLogin();
		assertEquals(actualValueTitle,expectedValueTitle);
		
	}

//	@Test
	public void loginAndgoToAdminAndLogout() {
		myDashboard = myHomePage.login("Admin", "admin123");
		String expectedValueTitle = "Dashboard";
		String actualValueTitle = myHomePage.getDashboardLabelAfterLogin();
		assertEquals(actualValueTitle,expectedValueTitle);
		myDashboard.goToAdmin();
	}
	
//	@Test
	public void editRecord() {
		myDashboard = myHomePage.login("Admin", "admin123");
		myAdmin = myDashboard.goToAdmin();
		myAdmin.editAdminRecord("bgujkkar456");

	}
	
	@Test
	public void deleteRecord() {
		myDashboard = myHomePage.login("Admin", "admin123");
		myAdmin = myDashboard.goToAdmin();
		myAdmin.deleteAdminRecord("David86");

	}
	
	
	@BeforeMethod
	public void setup() {
        myHomePage = new OrangeHRM();
	}
	
	@AfterMethod
	public void closeDriver() {
		myHomePage.closeBrowser();
	}

}
