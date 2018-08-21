package testCases;

import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageHandler.Page;
import supportUtilities.PostGreSQLHandler;
import testListeners.SignUpAndSignInTestListener;

@Listeners(SignUpAndSignInTestListener.class)
public class SignUpAndSignInTest {
  
	@DataProvider(name = "Reg-Data")
	public String[][] registrationData() throws SQLException, ClassNotFoundException{
		
		PostGreSQLHandler.initialize();
		
		String[][] objArray = PostGreSQLHandler.dataForRegistration();
		
		return (objArray);
		
	}
	
	@BeforeTest
	public static void start() {
		
		Page.openBrowser();
		Page.openWebPage();
		
	}
	
	@Test(dataProvider = "Reg-Data", priority = 1)
	public void SignUp(String ...details) throws Exception {
	
		Page.registrationPage(details);
		
		
	}
	
	@Test(dataProvider = "Reg-Data", priority = 2)
	public void SignIn(String ...details) throws Exception {
		
		Page.logOut();
		Page.loginPage(details[10], details[11]);
		
	}
	
	@AfterTest
	public void cleanUp() {
		Page.quitBrowser();
	}
	
}
