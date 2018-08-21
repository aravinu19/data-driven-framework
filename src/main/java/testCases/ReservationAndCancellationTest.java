package testCases;

import org.testng.annotations.Test;

import pageHandler.Page;
import supportUtilities.PostGreSQLHandler;
import testListeners.ReservationAndCancellationTestListener;

import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners(ReservationAndCancellationTestListener.class)
public class ReservationAndCancellationTest {
	
	@BeforeTest
	public static void testPreparations() {
		
		Page.openBrowser();
		Page.openWebPage();
		
	}
  
	@Test(dataProvider = "res-data")
	public void ReservationAndCancellation(String ...reservationData) throws Exception {
	
		Page.flightReservation(reservationData);
		Page.cancelReservation("mercury", "mercury");
	
	}

	@DataProvider(name = "res-data")
	public String[][] ReservationData() throws SQLException {
    
		String[][] reservationData = PostGreSQLHandler.dataForReservation();
	  
		return(reservationData);
	  
	}
  
	@AfterTest
	public static void cleanUp() {
		  
		Page.quitBrowser();
		  
	}
  
}
