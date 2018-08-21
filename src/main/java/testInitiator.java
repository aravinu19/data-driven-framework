import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class testInitiator {

	public static void main(String[] args) {
		// TODO Tests Starter
		
		List<String> testXMl = new ArrayList<>();
		testXMl.add("testng.xml");
		
		TestNG tng = new TestNG();
		tng.setTestSuites(testXMl);
		tng.run();

	}

}
