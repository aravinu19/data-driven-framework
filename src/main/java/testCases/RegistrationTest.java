package testCases;

import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageHandler.Page;
import supportUtilities.PostGreSQLHandler;
import testListeners.RegistrationTestListener;

@Listeners(RegistrationTestListener.class)
public class RegistrationTest {
	
	@DataProvider(name = "reg-provider")
	public String[][] RegistrationDataProvider() throws SQLException{
		
		String[][] objArray = PostGreSQLHandler.dataForRegistration();
		
		return (objArray);
		
	}
  
	@Test(dataProvider = "reg-provider")
	public void Register(String ...details) throws Exception {
	  
	  Page.registrationPage(details);
	  
	}
	
}
