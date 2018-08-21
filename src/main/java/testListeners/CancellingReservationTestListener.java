package testListeners;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import guiUtils.TestLogWindow;
import pageHandler.Page;
import supportUtilities.PostGreSQLHandler;
import supportUtilities.TestReportFormatter;
import supportUtilities.PostGreSQLHandler.DataBaseTable;
import supportUtilities.TestReportFormatter.TestCase;

public class CancellingReservationTestListener implements ITestListener {

	private static String CurrentTestName = null;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		TestLogWindow.sendLog("Test Method Started : " + result.getName());
		TestLogWindow.showCurretProgress(CurrentTestName, result.getName());
		
		try {
			TestReportFormatter.writeReport(result.getName(), result.getParameters().toString(), "START", result.getThrowable().getMessage(), TestCase.CANCELLING_RESERVATION);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		TestLogWindow.sendLog("Test Method Finished Successfully : " + result.getName());
		TestLogWindow.showCurretProgress(CurrentTestName, result.getName());
		
		
			try {
				TestReportFormatter.writeReport(result.getName(), result.getParameters().toString(), "PASSED", result.getThrowable().getMessage(), TestCase.CANCELLING_RESERVATION);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		TestLogWindow.sendLog("Test Method Failed : " + result.getThrowable().getMessage());
		TestLogWindow.showCurretProgress(CurrentTestName, result.getName());
		
		try {
			
			TestReportFormatter.writeReport(result.getName(), result.getParameters().toString(), "FAILED", result.getThrowable().getMessage(), TestCase.CANCELLING_RESERVATION);
			Page.ScreenShot(CurrentTestName + "_" + result.getName().toString());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		TestLogWindow.sendLog("Test Skipped : " + result.getName());
		try {
			Page.ScreenShot(CurrentTestName + "_" + result.getName().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			TestReportFormatter.writeReport(result.getName(), result.getParameters().toString(), "SKIPPED", result.getThrowable().getMessage(), TestCase.CANCELLING_RESERVATION);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		try {
			TestReportFormatter.writeReport(result.getName(), result.getParameters().toString(), "FAILED", result.getThrowable().getMessage(), TestCase.CANCELLING_RESERVATION);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		CurrentTestName = context.getName();
		
		try {
			TestReportFormatter.initialize(TestCase.CANCELLING_RESERVATION);
			TestLogWindow.prepareGUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		String[][] report = TestReportFormatter.getFormattedReport();
		
		for(String[] reports : report) {
			try {
				PostGreSQLHandler.pushReportToDB(reports, DataBaseTable.CANCELLATION_REPORT);
				System.out.println("Data : " + reports[0] + reports[1] + reports[2] + reports[3] + reports[4]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		TestLogWindow.sendLog("Tests Failed : " + context.getFailedTests());
		try {
			TestReportFormatter.finilizeReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
