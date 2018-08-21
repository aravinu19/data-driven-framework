import java.sql.SQLException;

import supportUtilities.PostGreSQLHandler;

public class DBInitializer {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		PostGreSQLHandler.createTables();
		PostGreSQLHandler.insertSampleDataForTest();
		
	}
	
}
