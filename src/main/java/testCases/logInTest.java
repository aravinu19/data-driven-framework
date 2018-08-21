package testCases;

import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageHandler.Page;
import supportUtilities.PostGreSQLHandler;
import testListeners.logInTestListener;

@Listeners(logInTestListener.class)
public class logInTest {
	
	  @DataProvider(name = "login-data")
	  public static String[][] LoginData() throws SQLException {
		  
		  String[][] data = PostGreSQLHandler.dataForLogIn();
		  
		  return(data);
		  
	  }
	
	  @Test(dataProvider = "login-data")
	  public void logIn(String username, String password) {
		  
		  
		  Page.loginPage(username, password);
		  Page.SignOut();
		  
	  }
	  
	  @AfterTest
	  public void cleanUp() {
		  
		  Page.quitBrowser();
		  
	  }
  
  
}
