package supportUtilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class TestReportFormatter {

	public enum TestCase { 
		SITE_NAVIAGTION, 
		SIGNIN_AND_SIGNUP, 
		RESERVATION_AND_CANCELLATION, 
		LOGIN, REGISTRATION, 
		FLIGHT_RESERVATION, 
		CANCELLING_RESERVATION 
	};
	
	public static boolean is_initialized = false;
	
	private static String path = "logs\\";
	private static File reportLog;
	private static BufferedWriter reportWriter;
	private static Timestamp timestamp;
	private static ArrayList<String> reportDB = new ArrayList<String>();
	
	public static void initialize(TestCase testName) throws IOException {
		
		is_initialized = true;
		
		if(testName == TestCase.SITE_NAVIAGTION) {
			
			timestamp = new Timestamp(System.currentTimeMillis());
			
			reportLog = new File(path + "SiteNavigationReportLog" + ".txt");
			reportLog.delete();
			reportWriter = new BufferedWriter(new FileWriter(reportLog));
			reportWriter.write("\tSite Navigation Report Log - " + timestamp.toString() + "\n\n");
			
		}else if(testName == TestCase.SIGNIN_AND_SIGNUP) {
			
			timestamp = new Timestamp(System.currentTimeMillis());
			
			reportLog = new File(path + "SignInAndSignUpReportLog" + ".txt");
			reportLog.delete();
			reportWriter = new BufferedWriter(new FileWriter(reportLog));
			reportWriter.write("\tSignIn and SignUp Report Log - " + timestamp.toString() + "\n\n");
			
		}else if(testName == TestCase.RESERVATION_AND_CANCELLATION) {
			
			timestamp = new Timestamp(System.currentTimeMillis());
			
			reportLog = new File(path + "ReservationAndCancellationReportLog" + ".txt");
			reportLog.delete();
			reportWriter = new BufferedWriter(new FileWriter(reportLog));
			reportWriter.write("\tReservation And Cancellation Report Log - " + timestamp.toString() + "\n\n");
			
		}else if(testName == TestCase.REGISTRATION) {
			
			timestamp = new Timestamp(System.currentTimeMillis());
			
			reportLog = new File(path + "RegistrationReportLog" + ".txt");
			reportLog.delete();
			reportWriter = new BufferedWriter(new FileWriter(reportLog));
			reportWriter.write("\tRegistration Report Log - " + timestamp.toString() + "\n\n");
			
		}else if(testName == TestCase.LOGIN) {
			
			timestamp = new Timestamp(System.currentTimeMillis());
			
			reportLog = new File(path + "LogInReportLog" + ".txt");
			reportLog.delete();
			reportWriter = new BufferedWriter(new FileWriter(reportLog));
			reportWriter.write("\tLogIn Report Log - " + timestamp.toString() + "\n\n");
			
		}else if(testName == TestCase.FLIGHT_RESERVATION) {
			
			timestamp = new Timestamp(System.currentTimeMillis());
			
			reportLog = new File(path + "flightReservationReportLog" + ".txt");
			reportLog.delete();
			reportWriter = new BufferedWriter(new FileWriter(reportLog));
			reportWriter.write("\t Flight Reservation Report Log - " + timestamp.toString() + "\n\n");
			
		}else if(testName == TestCase.CANCELLING_RESERVATION) {
			
			timestamp = new Timestamp(System.currentTimeMillis());
			
			reportLog = new File(path + "CancellingReservationReportLog" + ".txt");
			reportLog.delete();
			reportWriter = new BufferedWriter(new FileWriter(reportLog));
			reportWriter.write("\tCancelling Reservation Report Log - " + timestamp.toString() + "\n\n");
			
		}
		
	}
	
	public static void writeReport(String testName, String methods, String result, String error, TestCase testCase) throws IOException {
		
		if(!is_initialized) initialize(testCase);
		
		reportWriter.append("\nTest Name : " + testName);
		reportDB.add(testName);
		reportWriter.append("\nMethod Parameters : " + methods);
		reportDB.add(methods);
		reportWriter.append("\nTest Result : " + result);
		reportDB.add(result);
		
		if(error == null) error = "None";
		else {
			
			String[] simplifiedError = error.split("\n", 1);
			reportDB.add(simplifiedError[0]);
			
		}
		
		reportWriter.append("\nError : " + error + "\n\n");
		
		
	}
	
	public static void finilizeReport() throws IOException {
		
		timestamp = new Timestamp(System.currentTimeMillis());
		reportWriter.append("\n\n\t Log end at " + timestamp.toString());
		reportWriter.close();
		is_initialized = false;
		
	}
	
	public static String[][] getFormattedReport(){
		
		int rows = reportDB.size(), index3 = 0;
		rows /= 4;
		
		String[][] formattedReport = new String[rows][4];
		
		for(int index = 0; index < rows; index++) {
			for(int index2 = 0; index2 < 4; index2++) {
				formattedReport[index][index2] = reportDB.get(index3++);
			}
		}
		
		return(formattedReport);
		
	}
	
}
