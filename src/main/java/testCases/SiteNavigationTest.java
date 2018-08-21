package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageHandler.Page;
import supportUtilities.TestReportFormatter;
import testListeners.NavigationTestListener;

@Listeners(NavigationTestListener.class)
public class SiteNavigationTest {
  
	@BeforeTest
	public void beginTest() {
		
		Page.loginPage("mercury", "mercury");
		
	}
	
	@Test(priority = 1)
	public void HomeLink() {
	
		Page.homePage();
		
	}
	
	@Test(priority = 2)
	public void FlightsLink() {
	
		Page.FlightsPage();
		
	}
	
	@Test(priority = 3)
	public void HotelsLink() {
	
		Page.HotelsPage();
		
	}
	
	@Test(priority = 4)
	public void CarRentalsLink() {
	
		Page.CarRentalsPage();
		
	}
	
	@Test(priority = 5)
	public void CruisesLink() {
	
		Page.CruisesPage();
		
	}
	
	@Test(priority = 6)
	public void DestinationsLink() {
	
		Page.DestinationsPage();
		
	}
	
	@Test(priority = 7)
	public void VacationsLink() {
	
		Page.VacationsPage();
		
	}
	
	@Test(priority = 8)
	public void RegistrationLink() {
	
		Page.homePage();
		Page.RegistrationPage();
		
	}
	
	@Test(priority = 9)
	public void SupportLink() {
		
		Page.SupportPage();
		
	}
	
	@Test(priority = 10)
	public void ContactLink() {
	
		Page.ContactPage();
		
	}
	
	@Test(priority = 11)
	public void ProfilePage() throws Exception {
		
		Page.ProfilePage();
		
	}
	
	@Test(priority = 12)
	public void ItineraryPage() throws Exception {
		
		Page.ItineraryPage();
		
	}
	
	@AfterTest
	public static void cleanUp() {
		
		Page.quitBrowser();
		
		String[][] report = TestReportFormatter.getFormattedReport();
		
		for(String[] row : report) {
			for(String element : row) System.out.println("Column : " + element);
			System.out.println("");
		}
		
	}
	
}
