package supportUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.dom4j.DocumentException;

import SampleData.DataForDB;

public class PostGreSQLHandler {
	
	private static String username;
	private static String password;
	private static String host;
	private static String port;
	private static String DB_Name;
	
	private static ResultSet query_pointer;
	private static Statement stmt;
	private static boolean is_db_initialized = false;
	private static ArrayList<String> list;
	
	private static String config_file = "postgreDB_config.xml";
	
	public static enum DataBaseTable{
		SIGNUP_SIGNIN_REPORT, 
		RESERVATION_REPORT,
		CANCELLATION_REPORT,
		LOGIN_REPORT,
		CANCELLATION_RESERVATION_REPORT,
		REGISTRATION_REPORT,
		NAVIGATION_REPORT
		
	}
	
	public static void initialize() throws ClassNotFoundException, SQLException {
		
		try {
			
			getConfig();
			
			Class.forName("org.postgresql.Driver");
			Connection link = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + DB_Name, username, password);
			stmt = link.createStatement();
			
			is_db_initialized = true;
			
		} catch (ClassNotFoundException e) {
			System.out.println("Check For JDBC Connector Class in ClassPath \n Check 'POM.xml' file for Maven Dependency \n Exception Handled : " + e.getMessage());
			is_db_initialized = false;
		} catch (SQLException e) {
			System.out.println("Check the 'postgreDB_config.xml' file for correct configuration of your DB server and Run Again \n\n Exception HAndled : " + e.getMessage());
			is_db_initialized = false;
			//TODO add gui configurator
		} catch (DocumentException e) {
			System.out.println("Make Sure the \"postgreDB_config.xml\" is present in root of your project folder !\n\n");
			is_db_initialized = false;
		}
		
	}
	
	public static void getConfig() throws DocumentException {
		
		String[] configurations = XmlParser.readConfig(config_file);
		
		host = configurations[0];
		port = configurations[1];
		DB_Name = configurations[2];
		username = configurations[3];
		password = configurations[4];
		
	}
	
	public static void createTables() throws ClassNotFoundException, SQLException {
		
		if(!is_db_initialized) initialize();
		
		query_pointer = stmt.executeQuery("CREATE TABLE LOGIN( NAME varchar(150), USERNAME varchar(100), PASSWORD varchar(100));");
		query_pointer = stmt.executeQuery("CREATE TABLE REGISTRATION( FIRSTNAME varchar(150), LASTNAME varchar(150), PHONE varchar(15), USERNAME varchar(100), ADDRESS1 varchar(200), ADDRESS2 varchar(200), CITY varchar(150), STATE varchar(150), POSTALCODE varchar(6), COUNTRY varchar(150), EMAIL varchar(200), PASSWORD varchar(100));");
		
		query_pointer = stmt.executeQuery("CREATE TABLE FLIGHT_RESERVATION( \r\n" + 
				"		TRIP_TYPE varchar(50), \r\n" + 
				"		PASSENGER_COUNT varchar(2), \r\n" + 
				"		START_COUNTRY varchar(150), \r\n" + 
				"		START_MONTH varchar(15),\r\n" + 
				"		START_DAY varchar(2),\r\n" + 
				"		DESTINATION_COUNTRY varchar(150),\r\n" + 
				"		DESTINATION_MONTH varchar(15),\r\n" + 
				"		DESTINATION_DAY varchar(2),\r\n" + 
				"		SERVICE_CLASS varchar(100),\r\n" + 
				"		AIRLINE_PREFERENCE varchar(100),\r\n" + 
				"		PRICE1 varchar(6),\r\n" + 
				"		PRICE2 varchar(6),\r\n" + 
				"		PASSENGER1_FIRSTNAME varchar(150),\r\n" + 
				"		PASSENGER1_LASTNAME varchar(150),\r\n" + 
				"		PASSENGER1_MEAL varchar(100),\r\n" + 
				"		PASSENGER2_FIRSTNAME varchar(150) NULL,\r\n" + 
				"		PASSENGER2_LASTNAME varchar(150) NULL,\r\n" + 
				"		PASSENGER2_MEAL varchar(100) NULL,\r\n" + 
				"		PASSENGER3_FIRSTNAME varchar(150) NULL,\r\n" + 
				"		PASSENGER3_LASTNAME varchar(150) NULL,\r\n" + 
				"		PASSENGER3_MEAL varchar(100) NULL,\r\n" + 
				"		PASSENGER4_FIRSTNAME varchar(150) NULL,\r\n" + 
				"		PASSENGER4_LASTNAME varchar(150) NULL,\r\n" + 
				"		PASSENGER4_MEAL varchar(100) NULL,\r\n" + 
				"		CARD_TYPE varchar(100),\r\n" + 
				"		CARD_NUMBER varchar(16),\r\n" + 
				"		EXPIRY_MONTH varchar(2),\r\n" + 
				"		EXPIRY_YEAR varchar(4),\r\n" + 
				"		CC_FIRST_NAME varchar(150),\r\n" + 
				"		CC_MID_NAME varchar(150),\r\n" + 
				"		CC_LAST_NAME varchar(150),\r\n" + 
				"		BILL_ADDRESS1 varchar(200),\r\n" + 
				"		BILL_ADDRESS2 varchar(200),\r\n" + 
				"		BILL_CITY varchar(150),\r\n" + 
				"		BILL_STATE varchar(150),\r\n" + 
				"		BILL_ZIPCODE varchar(6),\r\n" + 
				"		BILL_COUNTRY varchar(150),\r\n" + 
				"		DEL_ADDRESS1 varchar(200),\r\n" + 
				"		DEL_ADDRESS2 varchar(200),\r\n" + 
				"		DEL_CITY varchar(150),\r\n" + 
				"		DEL_STATE varchar(150),\r\n" + 
				"		DEL_ZIPCODE varchar(6),\r\n" + 
				"		DEL_COUNTRY varchar(150)\r\n" + 
				"	);");
		
		query_pointer = stmt.executeQuery("CREATE TABLE UPDATE_PROFILE( \r\n" + 
				"		FIRSTNAME varchar(150), \r\n" + 
				"		LASTNAME varchar(150), \r\n" + 
				"		PHONE varchar(15), \r\n" + 
				"		EMAIL varchar(100), \r\n" + 
				"		ADDRESS1 varchar(200), \r\n" + 
				"		ADDRESS2 varchar(200), \r\n" + 
				"		CITY varchar(150), \r\n" + 
				"		STATE varchar(150), \r\n" + 
				"		POSTALCODE varchar(6), \r\n" + 
				"		COUNTRY varchar(150)\r\n" + 
				"	);");
		
		query_pointer = stmt.executeQuery("CREATE TABLE CANCELLATION_RESERVATION_REPORT( \r\n" + 
				"		TESTNAME varchar(150),\r\n" + 
				"		TESTMETHODS text,\r\n" + 
				"		RESULT varchar(50),\r\n" + 
				"		EXCEPTIONS text,\r\n" + 
				"		LOGFILE varchar(100)\r\n" + 
				"	);");
		
		query_pointer = stmt.executeQuery("CREATE TABLE NAVIGATION_REPORT( \r\n" + 
				"		TESTNAME varchar(150),\r\n" + 
				"		TESTMETHODS text,\r\n" + 
				"		RESULT varchar(50),\r\n" + 
				"		EXCEPTIONS text,\r\n" + 
				"		LOGFILE varchar(100)\r\n" + 
				"	);");
		
		query_pointer = stmt.executeQuery("CREATE TABLE REGISTRATION_REPORT( \r\n" + 
				"		TESTNAME varchar(150),\r\n" + 
				"		TESTMETHODS text,\r\n" + 
				"		RESULT varchar(50),\r\n" + 
				"		EXCEPTIONS text,\r\n" + 
				"		LOGFILE varchar(100)\r\n" + 
				"	);");
		
		query_pointer = stmt.executeQuery("CREATE TABLE LOGIN_REPORT( \r\n" + 
				"		TESTNAME varchar(150),\r\n" + 
				"		TESTMETHODS text,\r\n" + 
				"		RESULT varchar(50),\r\n" + 
				"		EXCEPTIONS text,\r\n" + 
				"		LOGFILE varchar(100)\r\n" + 
				"	);");
		
		query_pointer = stmt.executeQuery("CREATE TABLE CANCELLATION_REPORT( \r\n" + 
				"		TESTNAME varchar(150),\r\n" + 
				"		TESTMETHODS text,\r\n" + 
				"		RESULT varchar(50),\r\n" + 
				"		EXCEPTIONS text,\r\n" + 
				"		LOGFILE varchar(100)\r\n" + 
				"	);");
		
		query_pointer = stmt.executeQuery("CREATE TABLE RESERVATION_REPORT( \r\n" + 
				"		TESTNAME varchar(150),\r\n" + 
				"		TESTMETHODS text,\r\n" + 
				"		RESULT varchar(50),\r\n" + 
				"		EXCEPTIONS text,\r\n" + 
				"		LOGFILE varchar(100)\r\n" + 
				"	);");
		
		query_pointer = stmt.executeQuery("CREATE TABLE SIGNUP_SIGNIN_REPORT( \r\n" + 
				"		TESTNAME varchar(150),\r\n" + 
				"		TESTMETHODS text,\r\n" + 
				"		RESULT varchar(50),\r\n" + 
				"		EXCEPTIONS text,\r\n" + 
				"		LOGFILE varchar(100)\r\n" + 
				"	);");
		
	}
	
	public void insertDataToDB() {
		
		
		
	}
	
	public static void pushReportToDB(String[] reports, DataBaseTable table) throws SQLException {
		
		Connection link = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + DB_Name, username, password);
		stmt = link.createStatement();
		
		if(table == DataBaseTable.SIGNUP_SIGNIN_REPORT) {
			
			query_pointer = stmt.executeQuery("INSERT INTO SIGNUP_SIGNIN_REPORT VALUES('" + reports[0] +"'," + " '" + reports[1] +"', " + " '" + reports[2] +"', " + " '" + reports[3] +"', 'SignInAndSignUpReportLog.txt');" );
			
		}else if(table == DataBaseTable.CANCELLATION_REPORT) {
			
			query_pointer = stmt.executeQuery("INSERT INTO CANCELLATION_REPORT VALUES('" + reports[0] +"'," + " '" + reports[1] +"', " + " '" + reports[2] +"', " + " '" + reports[3] +"', 'CancellingReservationReportLog.txt');" );
			
		}else if(table == DataBaseTable.CANCELLATION_RESERVATION_REPORT) {
			
			query_pointer = stmt.executeQuery("INSERT INTO CANCELLATION_RESERVATION_REPORT VALUES('" + reports[0] +"'," + " '" + reports[1] +"', " + " '" + reports[2] +"', " + " '" + reports[3] +"', 'ReservationAndCancellationReportLog.txt');" );
			
		}else if(table == DataBaseTable.LOGIN_REPORT) {
			
			query_pointer = stmt.executeQuery("INSERT INTO LOGIN_REPORT VALUES('" + reports[0] +"'," + " '" + reports[1] +"', " + " '" + reports[2] +"', " + " '" + reports[3] +"', 'LogInReportLog.txt');" );
			
		}else if(table == DataBaseTable.REGISTRATION_REPORT) {
			
			query_pointer = stmt.executeQuery("INSERT INTO REGISTRATION_REPORT VALUES('" + reports[0] +"'," + " '" + reports[1] +"', " + " '" + reports[2] +"', " + " '" + reports[3] +"', 'RegistrationReportLog.txt');" );
			
		}else if(table == DataBaseTable.RESERVATION_REPORT) {
			
			query_pointer = stmt.executeQuery("INSERT INTO RESERVATION_REPORT VALUES('" + reports[0] +"'," + " '" + reports[1] +"', " + " '" + reports[2] +"', " + " '" + reports[3] +"', 'flightReservationReportLog.txt');" );
			
		}else if(table == DataBaseTable.NAVIGATION_REPORT) {
			
			query_pointer = stmt.executeQuery("INSERT INTO NAVIGATION_REPORT VALUES('" + reports[0] +"'," + " '" + reports[1] +"', " + " '" + reports[2] +"', " + " '" + reports[3] +"', 'SiteNavigationReportLog.txt');" );
			
		}
		
	}
	
	public static String[][] dataForLogIn() throws SQLException{
		
		query_pointer = stmt.executeQuery("SELECT USERNAME, PASSWORD FROM LOGIN");
		
		list = new ArrayList<String>();
		
		int rows = list.size()/2, index3 = 0;
		String[][] data = new String[rows][2];
		
		for(int index = 0; index < rows; index++) {
			for(int index2 = 0; index2 < 2; index2++) {
				data[index][index2] = list.get(index3++);
			}
		}
		
		return (data);
		
	}
	
	public static String[][] dataForRegistration() throws SQLException{
		
		query_pointer = stmt.executeQuery("SELECT * FROM REGISTRATION");
		
		list = new ArrayList<String>();
		
		while(query_pointer.next()) {
			
			list.add(query_pointer.getString(1));
			list.add(query_pointer.getString(2));
			list.add(query_pointer.getString(3));
			list.add(query_pointer.getString(4));
			list.add(query_pointer.getString(5));
			list.add(query_pointer.getString(6));
			list.add(query_pointer.getString(7));
			list.add(query_pointer.getString(8));
			list.add(query_pointer.getString(9));
			list.add(query_pointer.getString(10));
			list.add(query_pointer.getString(11));
			list.add(query_pointer.getString(12));
			
		}
		
		int rows = list.size()/12, index3 = 0;
		String[][] data = new String[rows][12];
		
		for(int index = 0; index < rows; index++) {
			for(int index2 = 0; index2 < 12; index2++) {
				data[index][index2] = list.get(index3++);
			}
		}
		
		return (data);
		
	}
	
	public static String[][] dataForReservation() throws SQLException{
		
		query_pointer = stmt.executeQuery("SELECT * FROM FLIGHT_RESERVATION");
		
		list = new ArrayList<String>();
		
		while(query_pointer.next()) {
			
			list.add(query_pointer.getString(1));
			list.add(query_pointer.getString(2));
			list.add(query_pointer.getString(3));
			list.add(query_pointer.getString(4));
			list.add(query_pointer.getString(5));
			list.add(query_pointer.getString(6));
			list.add(query_pointer.getString(7));
			list.add(query_pointer.getString(8));
			list.add(query_pointer.getString(9));
			list.add(query_pointer.getString(10));
			list.add(query_pointer.getString(11));
			list.add(query_pointer.getString(12));
			list.add(query_pointer.getString(13));
			list.add(query_pointer.getString(14));
			list.add(query_pointer.getString(15));
			list.add(query_pointer.getString(16));
			list.add(query_pointer.getString(17));
			list.add(query_pointer.getString(18));
			list.add(query_pointer.getString(19));
			list.add(query_pointer.getString(20));
			list.add(query_pointer.getString(21));
			list.add(query_pointer.getString(22));
			list.add(query_pointer.getString(23));
			list.add(query_pointer.getString(24));
			list.add(query_pointer.getString(25));
			list.add(query_pointer.getString(26));
			list.add(query_pointer.getString(27));
			list.add(query_pointer.getString(28));
			list.add(query_pointer.getString(29));
			list.add(query_pointer.getString(30));
			list.add(query_pointer.getString(31));
			list.add(query_pointer.getString(32));
			list.add(query_pointer.getString(33));
			list.add(query_pointer.getString(34));
			list.add(query_pointer.getString(35));
			list.add(query_pointer.getString(36));
			list.add(query_pointer.getString(37));
			list.add(query_pointer.getString(38));
			list.add(query_pointer.getString(39));
			list.add(query_pointer.getString(40));
			list.add(query_pointer.getString(41));
			list.add(query_pointer.getString(42));
			list.add(query_pointer.getString(43));
			
			
		}
		
		int rows = list.size()/43, index3 = 0;
		String[][] data = new String[rows][43];
		
		for(int index = 0; index < rows; index++) {
			for(int index2 = 0; index2 < 43; index2++) {
				data[index][index2] = list.get(index3++);
			}
		}
		
		return (data);
		
	}
	
	public static String[][] dataForProfileUpdate() throws SQLException{
		
		query_pointer = stmt.executeQuery("SELECT * FROM UPDATE_PROFILE");
		
		list = new ArrayList<String>();
		
		while(query_pointer.next()) {
			
			list.add(query_pointer.getString(1));
			list.add(query_pointer.getString(2));
			list.add(query_pointer.getString(3));
			list.add(query_pointer.getString(4));
			list.add(query_pointer.getString(5));
			list.add(query_pointer.getString(6));
			list.add(query_pointer.getString(7));
			list.add(query_pointer.getString(8));
			list.add(query_pointer.getString(9));
			list.add(query_pointer.getString(10));
			
		}
		
		int rows = list.size()/10, index3 = 0;
		String[][] data = new String[rows][10];
		
		for(int index = 0; index < rows; index++) {
			for(int index2 = 0; index2 < 10; index2++) {
				data[index][index2] = list.get(index3++);
			}
		}
		
		return (data);
		
	}
	
	public static void insertSampleDataForTest() throws SQLException {
		
		String[] data = DataForDB.logInSampleData;
		
		for(String query : data) {
			
			query_pointer = stmt.executeQuery(query);
			
		}
		
		System.out.println("Sample LogIn Data Inserted to DB");
		
		data = DataForDB.registrationSampleData;
		for(String query : data) {
			
			query_pointer = stmt.executeQuery(query);
			
		}
		
		System.out.println("Sample Registration Data Inserted to DB");
		
		data = DataForDB.profileSampleData;
		for(String query : data) {
			
			query_pointer = stmt.executeQuery(query);
			
		}
		
		System.out.println("Sample Profile Data Inserted to DB");
		
		data = DataForDB.reservationSampleData;
		for(String query : data) {
			
			query_pointer = stmt.executeQuery(query);
			
		}

		System.out.println("Sample Reservation Data Inserted to DB");
		
	}

}
