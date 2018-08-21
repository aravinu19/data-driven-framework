package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageHandler.Page;
import testListeners.CancellingReservationTestListener;

@Listeners(CancellingReservationTestListener.class)
public class CancellingReservationTest {
	
	@DataProvider(name = "Account-Data")
	public String[][] cancellationAccountData(){
		
		String[][] dataArray = {{"mercury","mercury"}}; //Due bug in Login page so provided Login is Used
		
		return (dataArray);
		
	}
  
	@Test(dataProvider = "Account-Data")
	public void Cancellation(String username, String password) throws Exception {
	
		Page.cancelReservation(username, password);
		
	}
	
	
}
