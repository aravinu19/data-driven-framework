package testListeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import guiUtils.TestLogWindow;
import pageHandler.Page;
import supportUtilities.TestReportFormatter;
import supportUtilities.TestReportFormatter.TestCase;

public class SignUpAndSignInTestListener implements ITestListener{

	private static String CurrentTestName = null;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		TestLogWindow.sendLog("Test Method Started : " + result.getName());
		TestLogWindow.showCurretProgress(CurrentTestName, result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		TestLogWindow.sendLog("Test Method Finished Successfully : " + result.getName());
		TestLogWindow.showCurretProgress(CurrentTestName, result.getName());
		
		try {
			TestReportFormatter.writeReport(result.getName(), result.getParameters().toString(), "PASSED", result.getThrowable().getMessage(), TestCase.SIGNIN_AND_SIGNUP);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		TestLogWindow.sendLog("Test Method Failed : " + result.getThrowable().getMessage());
		TestLogWindow.showCurretProgress(CurrentTestName, result.getName());
		
		try {
			
			TestReportFormatter.writeReport(result.getName(), result.getParameters().toString(), "FAILED", result.getThrowable().getMessage(), TestCase.SIGNIN_AND_SIGNUP);
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
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		CurrentTestName = context.getName();
		
		try {
			TestReportFormatter.initialize(TestCase.SIGNIN_AND_SIGNUP);
			TestLogWindow.prepareGUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
		TestLogWindow.sendLog("Tests Failed : " + context.getFailedTests());
		try {
			TestReportFormatter.finilizeReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
