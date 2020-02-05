package br.com.rsinet.appium.tdd.report;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.appium.tdd.utilitarios.ScreenchotUtilitarios;

public class report {

	public static ExtentHtmlReporter ExtentHtmlReporter;
	public static ExtentReports extentReports;
	public static ExtentTest ExtentTest;

	public static void Report() {
		ExtentHtmlReporter = new ExtentHtmlReporter(".target/reports.html");
		ExtentHtmlReporter.config().setDocumentTitle("Report");
		ExtentHtmlReporter.config().setReportName("Report");

		extentReports = new ExtentReports();

		extentReports.attachReporter(ExtentHtmlReporter);
	}

	public static ExtentTest createTest(String testName) {
		ExtentTest = extentReports.createTest(testName);
		return ExtentTest;
	}

	public static void statusReported(ExtentTest test, ITestResult result, WebDriver driver) throws IOException {

		String screenPath = ScreenchotUtilitarios.getScreenshot(driver);

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Caso de teste FAILED: " + result.getName());
			test.log(Status.FAIL, "Caso de teste FAILED: " + result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Caso de teste SKIPPED: " + result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Caso de teste PASSED: " + result.getName());
		}
		
		test.addScreenCaptureFromPath(screenPath);
	}

	/* fechando */
	public static void quitExtent() {
		extentReports.flush();
	}
}
