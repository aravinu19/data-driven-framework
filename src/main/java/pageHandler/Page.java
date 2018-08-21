package pageHandler;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import supportUtilities.SnapShot;

import org.openqa.selenium.edge.EdgeDriver;

public class Page {
	
	public static WebDriver EDriver;
	static boolean page_opened = false;
	static boolean browser_opened = false;
	static String url = "http://newtours.demoaut.com/";
	
	public static void openBrowser() {
		
		try {
			System.setProperty("webdriver.edge.driver", "driver\\MicrosoftWebDriver.exe");
			
			EDriver = new EdgeDriver();
			EDriver.manage().deleteAllCookies();
			EDriver.manage().window().maximize();
			
			EDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			EDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			browser_opened = true;
		} catch (Exception e) {
			System.out.println("Make Sure that No Edge Browser Windows (Instances) are running ! \n\n If Edge is Running , Then Close It And Run the test Again\n\n"); 
		}
		
	}
	
	public static void openWebPage() {
		
		try {
		
			EDriver.get(url);
			page_opened = true;
		
		}catch (Exception e) {
			System.out.println("\n\n Make Sure Network Connection is GOOD And Try Again \n\n" + e.getMessage());
		}
		
	}
	
	public static void loginPage(String userName, String password) {
		
		
			checkForRequirements();
			
			EDriver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")).click();
			
			EDriver.findElement(By.name("userName")).sendKeys(userName);
			EDriver.findElement(By.name("password")).sendKeys(password);
			
			EDriver.findElement(By.name("login")).click();
			
			Assert.assertTrue(EDriver.findElement(By.linkText("SIGN-OFF")).isDisplayed());
		
		
	}
	
	public static void logOut() throws Exception {
		
		try {
			EDriver.findElement(By.linkText("SIGN_OFF")).click();
		} catch (Exception e) {
			
			System.out.println("LogIn is not performed Before Testing LogOut \n\n Or Check For Network Issues \n\n Custom Exception : " + e.getMessage());
			SnapShot.takeSnap(EDriver);
		}
		
	}

	public static void registrationPage(String[] details) throws Exception {
		
		try {
			checkForRequirements();
			
			EDriver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
			
			EDriver.findElement(By.name("firstName")).sendKeys(details[0]);
			EDriver.findElement(By.name("lastName")).sendKeys(details[1]);
			EDriver.findElement(By.name("phone")).sendKeys(details[2]);
			EDriver.findElement(By.id("userName")).sendKeys(details[3]);
			EDriver.findElement(By.name("address1")).sendKeys(details[4]);
			EDriver.findElement(By.name("address2")).sendKeys(details[5]);
			EDriver.findElement(By.name("city")).sendKeys(details[6]);
			EDriver.findElement(By.name("state")).sendKeys(details[7]);
			EDriver.findElement(By.name("postalCode")).sendKeys(details[8]);
			EDriver.findElement(By.name("country")).sendKeys(details[9]);
			EDriver.findElement(By.name("country")).sendKeys(Keys.ENTER);
			EDriver.findElement(By.id("email")).sendKeys(details[10]);
			EDriver.findElement(By.name("password")).sendKeys(details[11]);
			EDriver.findElement(By.name("confirmPassword")).sendKeys(details[11]);
			
			EDriver.findElement(By.name("register")).click();
			
			Assert.assertTrue(EDriver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText().contains(details[10]));
			
			SignOut();
			
		} catch (Exception e) {
			
			System.out.println("Exception Handled : " + e.getMessage());
			SnapShot.takeSnap(EDriver);
			
		}
		
	}
	
	public static void flightReservation(String[] reservationDetails) throws Exception {
		
		try {
			loginPage("mercury", "mercury");
			
			EDriver.findElement(By.linkText("Cruises")).click();
			EDriver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/p[3]/a/img")).click();
			
			List<WebElement> elements = EDriver.findElements(By.name("tripType"));
			if(reservationDetails[0].contains("round")) {
				
				elements.get(0).click();
				
			}else {
				
				elements.get(1).click();
				
			}
			
			EDriver.findElement(By.name("passCount")).sendKeys(reservationDetails[1]);
			WebElement element = EDriver.findElement(By.name("fromPort"));
			element.click();
			element.sendKeys(reservationDetails[2]);
			
			element = EDriver.findElement(By.name("fromMonth"));
			element.click();
			element.sendKeys(reservationDetails[3]);
			
			element = EDriver.findElement(By.name("fromDay"));
			element.click();
			element.sendKeys(reservationDetails[4]);
			
			element = EDriver.findElement(By.name("toPort"));
			element.click();
			element.sendKeys(reservationDetails[5]);
			
			element = EDriver.findElement(By.name("toMonth"));
			element.click();
			element.sendKeys(reservationDetails[6]);
			
			element = EDriver.findElement(By.name("toDay"));
			element.click();
			element.sendKeys(reservationDetails[7]);
			
			elements = EDriver.findElements(By.name("servClass"));
			
			if(reservationDetails[8].contains("economy")) {
				
				elements.get(0).click();
				
			}else if(reservationDetails[8].contains("business")) {
				
				elements.get(1).click();
				
			}else {
				
				elements.get(2).click();
				
			}
			
			element = EDriver.findElement(By.name("airline"));
			element.click();
			element.sendKeys(reservationDetails[9]);
			element.sendKeys(Keys.ENTER);
			
			EDriver.findElement(By.name("findFlights")).click();
			
			//SnapShot.takeSnap(EDriver);
			Assert.assertTrue(EDriver.getTitle().contains("Select a Flight"));
			
			elements = EDriver.findElements(By.name("outFlight"));
			
			if(reservationDetails[10].contains("270")) {
				
				elements.get(0).click();
				
			}else if(reservationDetails[10].contains("271")) {
				
				elements.get(1).click();
				
			}else if(reservationDetails[10].contains("274")) {
				
				elements.get(2).click();
				
			}else {
				
				elements.get(3).click();
				
			}
			
			elements = EDriver.findElements(By.name("inFlight"));
			
			if(reservationDetails[11].contains("270")) {
				
				elements.get(0).click();
				
			}else if(reservationDetails[11].contains("273")) {
				
				elements.get(1).click();
				
			}else if(reservationDetails[11].contains("282")) {
				
				elements.get(2).click();
				
			}else {
				
				elements.get(3).click();
				
			}
			
			EDriver.findElement(By.name("reserveFlights")).click();
			
			Assert.assertTrue(EDriver.getTitle().contains("Book a Flight"));
			
			int passengerCount = Integer.parseInt(reservationDetails[1]);
			
			if(passengerCount >= 1) {
				
				EDriver.findElement(By.name("passFirst0")).sendKeys(reservationDetails[12]);
				EDriver.findElement(By.name("passLast0")).sendKeys(reservationDetails[13]);
				
				element = EDriver.findElement(By.name("pass.0.meal"));
				element.sendKeys(reservationDetails[14]);
				element.sendKeys(Keys.ENTER);
				
			}
			
			if(passengerCount >= 2) {
				
				EDriver.findElement(By.name("passFirst1")).sendKeys(reservationDetails[15]);
				EDriver.findElement(By.name("passLast1")).sendKeys(reservationDetails[16]);
				
				element = EDriver.findElement(By.name("pass.1.meal"));
				element.sendKeys(reservationDetails[17]);
				element.sendKeys(Keys.ENTER);
				
			}
			
			if(passengerCount >= 3) {
				
				EDriver.findElement(By.name("passFirst2")).sendKeys(reservationDetails[18]);
				EDriver.findElement(By.name("passLast2")).sendKeys(reservationDetails[19]);
				
				element = EDriver.findElement(By.name("pass.2.meal"));
				element.sendKeys(reservationDetails[20]);
				element.sendKeys(Keys.ENTER);
				
			}
			
			if(passengerCount == 4) {
				
				EDriver.findElement(By.name("passFirst3")).sendKeys(reservationDetails[21]);
				EDriver.findElement(By.name("passLast3")).sendKeys(reservationDetails[22]);
				
				element = EDriver.findElement(By.name("pass.3.meal"));
				element.sendKeys(reservationDetails[23]);
				element.sendKeys(Keys.ENTER);
				
			}
			
			element = EDriver.findElement(By.name("creditCard"));
			element.sendKeys(reservationDetails[24]);
			element.sendKeys(Keys.ENTER);
			
			EDriver.findElement(By.name("creditnumber")).sendKeys(reservationDetails[25]);
			
			element = EDriver.findElement(By.name("cc_exp_dt_mn"));
			element.sendKeys(reservationDetails[26]);
			element.sendKeys(Keys.ENTER);
			
			element = EDriver.findElement(By.name("cc_exp_dt_yr"));
			element.sendKeys(reservationDetails[27]);
			element.sendKeys(Keys.ENTER);
			
			EDriver.findElement(By.name("cc_frst_name")).sendKeys(reservationDetails[28]);
			EDriver.findElement(By.name("cc_mid_name")).sendKeys(reservationDetails[29]);
			EDriver.findElement(By.name("cc_last_name")).sendKeys(reservationDetails[30]);
			
			EDriver.findElement(By.name("ticketLess")).click();
			
			//TODO assert fo tick
			
			EDriver.findElement(By.name("ticketLess")).click();
			
			element = EDriver.findElement(By.name("billAddress1"));
			element.clear();
			element.sendKeys(reservationDetails[31]);
			
			EDriver.findElement(By.name("billAddress2")).sendKeys(reservationDetails[32]);
			
			element = EDriver.findElement(By.name("billCity"));
			element.clear();
			element.sendKeys(reservationDetails[33]);
			
			element = EDriver.findElement(By.name("billZip"));
			element.clear();
			element.sendKeys(reservationDetails[34]);
			
			element = EDriver.findElement(By.name("billState"));
			element.clear();
			element.sendKeys(reservationDetails[35]);
			
			element = EDriver.findElement(By.name("billCountry"));
			element.sendKeys(reservationDetails[36]);
			element.sendKeys(Keys.ENTER);
			
			element = EDriver.findElement(By.name("delAddress1"));
			element.clear();
			element.sendKeys(reservationDetails[37]);
			
			EDriver.findElement(By.name("delAddress2")).sendKeys(reservationDetails[38]);
			
			element = EDriver.findElement(By.name("delCity"));
			element.clear();
			element.sendKeys(reservationDetails[39]);
			
			element = EDriver.findElement(By.name("delZip"));
			element.clear();
			element.sendKeys(reservationDetails[40]);
			
			element = EDriver.findElement(By.name("delState"));
			element.clear();
			element.sendKeys(reservationDetails[41]);
			
			element = EDriver.findElement(By.name("delCountry"));
			element.sendKeys(reservationDetails[42]);
			element.sendKeys(Keys.ENTER);
			
			EDriver.findElement(By.name("buyFlights")).click();
			
			Assert.assertTrue(EDriver.getTitle().contains("Flight Confirmation: Mercury Tours"));
			
		} catch (Exception e) {
			System.out.println("Exception Handled : " + e.getMessage());
			SnapShot.takeSnap(EDriver);
		}
		
	}
	
	public static void updateProfile(String[] profileDetails) throws Exception {
		
		try {
			EDriver.findElement(By.name("firstName")).sendKeys(profileDetails[0]);
			EDriver.findElement(By.name("lastName")).sendKeys(profileDetails[1]);
			EDriver.findElement(By.name("phone")).sendKeys(profileDetails[2]);
			EDriver.findElement(By.name("email")).sendKeys(profileDetails[3]);
			EDriver.findElement(By.name("address1")).sendKeys(profileDetails[4]);
			EDriver.findElement(By.name("address2")).sendKeys(profileDetails[5]);
			EDriver.findElement(By.name("city")).sendKeys(profileDetails[6]);
			EDriver.findElement(By.name("state")).sendKeys(profileDetails[7]);
			EDriver.findElement(By.name("postalCode")).sendKeys(profileDetails[8]);
			
			WebElement element = EDriver.findElement(By.name("country"));
			element.sendKeys(profileDetails[9]);
			element.sendKeys(Keys.ENTER);
			
			EDriver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr[14]/td/a/img")).click();
			
			Assert.assertTrue(EDriver.getTitle().contains("Register") || EDriver.getTitle().contains("Profile"));
		} catch (Exception e) {
			System.out.println("Exception Handled : " + e.getMessage());
			SnapShot.takeSnap(EDriver);
		}
		
	}
	
	public static void cancelReservation(String username, String password) throws Exception{
		
		try {
			loginPage(username, password);
			
			EDriver.findElement(By.linkText("ITINERARY")).click();

			WebElement element = EDriver.findElement(By.xpath("//area[@shape='rect']"));
			JavascriptExecutor jsX = (JavascriptExecutor) EDriver;
			jsX.executeScript("arguments[0].click();", element);
			
			Assert.assertTrue(EDriver.getTitle().contains("Flight"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Handled : " + e.getMessage());
			SnapShot.takeSnap(EDriver);
		}
		
	}
	
	public static void homePage() {
		
		EDriver.findElement(By.linkText("Home")).click();
		
		Assert.assertTrue(EDriver.getTitle().contains("Welcome: Mercury Tours"));
	
	}
	
	public static void FlightsPage() {
	
		EDriver.findElement(By.linkText("Flights")).click();
		
		Assert.assertTrue(EDriver.getTitle().contains("Find a Flight: Mercury Tours: "));
	
	}
	
	public static void HotelsPage() {
		
		EDriver.findElement(By.linkText("Hotels")).click();
		
		Assert.assertTrue(!EDriver.getTitle().contains("Under Construction: Mercury Tours"));
	
	}
	
	public static void CarRentalsPage() {
		
		EDriver.findElement(By.linkText("Car Rentals")).click();
		
		Assert.assertTrue(!EDriver.getTitle().contains("Under Construction: Mercury Tours"));
	
	}
	
	public static void CruisesPage() {
		
		EDriver.findElement(By.linkText("Cruises")).click();
		
		Assert.assertTrue(!EDriver.getTitle().contains(""));
	
	}
	
	public static void DestinationsPage() {
		
		EDriver.findElement(By.linkText("Destinations")).click();
		
		Assert.assertTrue(!EDriver.getTitle().contains("Under Construction: Mercury Tours"));
	
	}
	
	public static void VacationsPage() {
		
		EDriver.findElement(By.linkText("Vacations")).click();
		
		Assert.assertTrue(!EDriver.getTitle().contains("Under Construction: Mercury Tours"));
	
	}
	
	public static void SignInPage() {
		
		try {
			logOut();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EDriver.findElement(By.linkText("SIGN-ON")).click();
	
	}
	
	public static void RegistrationPage() {
		
		EDriver.findElement(By.linkText("REGISTER"));
		
		Assert.assertTrue(EDriver.getTitle().contains("Register: Mercury Tours"));
		
	}
	
	public static void SupportPage() {
		
		EDriver.findElement(By.linkText("SUPPORT")).click();
		
		Assert.assertTrue(!EDriver.getTitle().contains("Under Construction: Mercury Tours"));
		
	}
	
	public static void ContactPage() {
		
		EDriver.findElement(By.linkText("CONTACT")).click();
		
		Assert.assertTrue(!EDriver.getTitle().contains("Under Construction: Mercury Tours"));
		
	}
	
	public static void ProfilePage() throws Exception {
		
		loginPage("mercury", "mercury");
		
		EDriver.findElement(By.linkText("PROFILE")).click();
		
	}
	
	public static void ItineraryPage() throws Exception {
		
		loginPage("mercury", "mercury");
		
		EDriver.findElement(By.linkText("ITINERARY")).click();
		
	}
	
	private static void checkForRequirements() {
		
		if(!browser_opened) openBrowser();
		
		if(!page_opened) openWebPage();
		
	}
	
	public static void quitBrowser() {
		
		if(browser_opened) {
			EDriver.quit();
		}
		
	}
	
	public static void SignOut() {
		
		if(EDriver.findElement(By.linkText("SIGN_OFF")).isDisplayed()) {
			EDriver.findElement(By.linkText("SIGN_OFF")).click();
		}
		
	}
	
	public static void checkLoginStatus() {
		
		if(EDriver.findElement(By.linkText("SIGN-OFF")) == null) {
			
			loginPage("mercury", "mercury");
			
		}
		
	}
	
	public static void ScreenShot(String testMethod) throws Exception {
		
		SnapShot.takeSnap(EDriver, testMethod);
		
	}
	
	public static void waitFor() throws InterruptedException {
		Thread.sleep(2000);
	}
	
}
