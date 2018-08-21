package supportUtilities;

import java.io.File;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SnapShot {

	public static void takeSnap(WebDriver driver) throws Exception {
		
		TakesScreenshot shot = ((TakesScreenshot) driver);
		
		File snapshot  = shot.getScreenshotAs(OutputType.FILE);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String fileName = timestamp.toString();
		fileName = fileName.replace(" ", "_");
		fileName = fileName.replace(":", "_");
		
		File dest = new File("screenshots\\" + fileName + ".png");
		
		FileUtils.copyFile(snapshot, dest);
		
	}
	
	public static void takeSnap(WebDriver driver, String methodName) throws Exception {
		
		TakesScreenshot shot = ((TakesScreenshot) driver);
		
		File snapshot  = shot.getScreenshotAs(OutputType.FILE);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String fileName = timestamp.toString();
		fileName = fileName.replace(" ", "_");
		fileName = fileName.replace(":", "_");
		
		File dest = new File("screenshots\\" + methodName + "_" + fileName + ".png");
		
		FileUtils.copyFile(snapshot, dest);
		
	}
	
}
