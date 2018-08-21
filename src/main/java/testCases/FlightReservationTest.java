package testCases;

import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageHandler.Page;
import supportUtilities.PostGreSQLHandler;
import testListeners.FlightReservationTestListener;

@Listeners(FlightReservationTestListener.class)
public class FlightReservationTest {
	
	@DataProvider(name = "reserve-data")
	public String[][] reservationData() throws SQLException{
		
		String[][] objArray = PostGreSQLHandler.dataForReservation();
		
		return (objArray);
		
	}
  
	@Test(dataProvider = "reserve-data")
	public void Reservation(String ...reservationDetails) throws Exception {
	  
	  Page.flightReservation(reservationDetails);
	  
	}
	
}
