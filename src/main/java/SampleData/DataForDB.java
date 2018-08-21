package SampleData;

public class DataForDB {
	
	public static String[] logInSampleData = {
			"INSERT INTO LOGIN VALUES( 'aravind', 'aravi', 'passwd1');",
			"INSERT INTO LOGIN VALUES( 'arun', 'arunmach', 'passwd2');",
			"INSERT INTO LOGIN VALUES( 'barath', 'barath20', 'passwd3');",
			"INSERT INTO LOGIN VALUES( 'shawn', 'shawn53', 'passwd4');",
			"INSERT INTO LOGIN VALUES( 'alexa', 'alexaAWS', 'passwd5');",
			"INSERT INTO LOGIN VALUES( 'natasha', 'natashaHike', 'passwd6');"
	};
	
	public static String[] registrationSampleData = {
		
			"INSERT INTO REGISTRATION VALUES( 'aravind', 'raj', '123456789', 'aravi', 'example addr1', 'example addr1', 'villupuram', 'TAMIL NADU', '605602', 'INDIA', 'aravinu19@gmail.com', 'passwd1');",
			"INSERT INTO REGISTRATION VALUES( 'arun', 'mach', '456123789', 'arunmach', 'example addr2', 'example addr2', 'Chennai', 'TAMIL NADU', '600002', 'INDIA', 'arunmach@gmail.com', 'passwd2');",
			"INSERT INTO REGISTRATION VALUES( 'barath', 'kumar', '789123456', 'barath20', 'example addr3', 'example addr3', 'New york', 'New york', '40007', 'United States', 'barath20@gmail.com', 'passwd3');",
			"INSERT INTO REGISTRATION VALUES( 'shawn', 'roger', '456789123', 'shawn53', 'example addr4', 'example addr4', 'Mountain View', 'California', '50008', 'united states', 'shawn53@gmail.com', 'passwd4');",
			"INSERT INTO REGISTRATION VALUES( 'alexa', 'aws', '912345678', 'alexaAWS', 'example addr5', 'example addr5', 'vegas', 'vegas', '60002', 'United states', 'alexaAWS@gmail.com', 'passwd5');",
			"INSERT INTO REGISTRATION VALUES( 'natasha', 'hike', '891234567', 'natashaHike', 'example addr6', 'example addr6', 'delhi', 'delhi', '607102', 'INDIA', 'natashaHike@gmail.com', 'passwd6');" 
			
	};
	
	public static String[] reservationSampleData = {
			
			"INSERT INTO FLIGHT_RESERVATION VALUES( 'one', '1', 'London', 'may', '20', 'new york', 'june', '15', 'economy', 'blue skies airlines', '271', '282', 'Aravind', 'RaJ', 'Hindu', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'American Express', '95555551221', '08', '2009', 'aravind', ' ', 'raj', 'example addr1', 'example addr1', 'villupuram', 'TAMIL NADU', '605602', 'INDIA', 'example addr1', 'example addr1', 'villupuram', 'TAMIL NADU', '605602', 'INDIA');",
			"INSERT INTO FLIGHT_RESERVATION VALUES( 'round', '2', 'new york', 'march', '21', 'london', 'april', '16', 'First', 'unified airlines', '270', '303', 'Aravind', 'RaJ', 'Hindu', 'barath', 'raj', 'Diabetic', NULL, NULL, NULL, NULL, NULL, NULL, 'MasterCard', '95666661221', '09', '2008', 'arun', 'mach', 'raj', 'example addr2', 'example addr2', 'Chennai', 'TAMIL NADU', '600002', 'INDIA', 'example addr2', 'example addr2', 'Chennai', 'TAMIL NADU', '600002', 'INDIA');",
			"INSERT INTO FLIGHT_RESERVATION VALUES( 'one', '3', 'paris', 'april', '22', 'new york', 'may', '18', 'Business', 'Pangea airlines', '274', '282', 'Aravind', 'RaJ', 'Hindu', 'arun', 'mach', 'Kosher', 'alexa', 'aws', 'Bland', NULL, NULL, NULL, 'Visa', '911111551221', '05', '2007', 'shawn', 'sho', 'roger', 'example addr3', 'example addr3', 'New york', 'New york', '40007', 'United States', 'example addr3', 'example addr3', 'New york', 'New york', '40007', 'United States');",
			"INSERT INTO FLIGHT_RESERVATION VALUES( 'round', '1', 'seattle', 'june', '10', 'new york', 'june', '12', 'economy', 'blue skies airlines', '281', '273', 'Aravind', 'RaJ', 'Hindu', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Discover', '75521151221', '06', '2006', 'barath', 'marvelo', 'raj', 'example addr4', 'example addr4', 'Mountain View', 'California', '50008', 'united states', 'example addr4', 'example addr4', 'Mountain View', 'California', '50008', 'united states');",
			"INSERT INTO FLIGHT_RESERVATION VALUES( 'one', '3', 'London', 'july', '25', 'seattle', 'august', '20', 'first', 'unified airlines', '271', '282', 'Aravind', 'RaJ', 'Hindu', 'arun', 'mach', 'Kosher', 'alexa', 'aws', 'Bland', NULL, NULL, NULL, 'Diners Club', '65512051221', '07', '2005', 'alexa', 'amazon', 'aws', 'example addr5', 'example addr5', 'vegas', 'vegas', '60002', 'United states', 'example addr5', 'example addr5', 'vegas', 'vegas', '60002', 'United states');",
			"INSERT INTO FLIGHT_RESERVATION VALUES( 'round', '4', 'seattle', 'november', '20', 'Frankfart', 'december', '10', 'Business', 'Pangea airlines', '274', '270', 'Aravind', 'RaJ', 'Hindu', 'barath', 'raj', 'Diabetic', 'arun', 'mach', 'Kosher', 'alexa', 'aws', 'Bland', 'Carte Blanche', '187745551221', '10', '2004', 'natasha', 'hike', 'indi', 'example addr6', 'example addr6', 'delhi', 'delhi', '607102', 'INDIA', 'example addr6', 'example addr6', 'delhi', 'delhi', '607102', 'INDIA');"
			
	};
	
	public static String[] profileSampleData = {
			
			"INSERT INTO UPDATE_PROFILE VALUES( 'aravind', 'raj', '123456789', 'aravinu19@gmail.com', 'example addr1', 'example addr1', 'villupuram', 'TAMIL NADU', '605602', 'INDIA');",
			"INSERT INTO UPDATE_PROFILE VALUES( 'arun', 'mach', '456123789', 'arunmach@gmail.com', 'example addr2', 'example addr2', 'Chennai', 'TAMIL NADU', '600002', 'INDIA');",
			"INSERT INTO UPDATE_PROFILE VALUES( 'barath', 'kumar', '789123456', 'barath20@gmail.com', 'example addr3', 'example addr3', 'New york', 'New york', '40007', 'United States');",
			"INSERT INTO UPDATE_PROFILE VALUES( 'shawn', 'roger', '456789123', 'shawn53@gmail.com', 'example addr4', 'example addr4', 'Mountain View', 'California', '50008', 'united states');",
			"INSERT INTO UPDATE_PROFILE VALUES( 'alexa', 'aws', '912345678', 'alexaAWS@gmail.com', 'example addr5', 'example addr5', 'vegas', 'vegas', '60002', 'United states');",
			"INSERT INTO UPDATE_PROFILE VALUES( 'natasha', 'hike', '891234567', 'natashaHike@gmail.com', 'example addr6', 'example addr6', 'delhi', 'delhi', '607102', 'INDIA'); "
			
	};

}
