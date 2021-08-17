package com.TestCases;

import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Utility.DriverSetup;
import com.Utility.ExtentReport;
import com.Utility.GetPrpoerty;
import com.Utility.TakeScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.functions.TestFunctions;

public class TestCase {
	
	public static WebDriver driver;	
	public static Properties prop = GetPrpoerty.getProperties();
	public static String browser;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public static ExtentReports report;
	public static ExtentTest test;	
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		browser = prop.getProperty("browser");
		driver = DriverSetup.getWebDriver(browser);
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		report = ExtentReport.getReportInstance();
	}
	
	@Test(priority=0)
	public void CustomerType_Senior_Citizen() {
		
		//TestFunctions.CloseAlertAndPopup(driver);
		//TestFunctions.ScrollDown(driver);
		TestFunctions.SelectSeniorCitizenRadioButton(driver);
		test = report.createTest("Landing Page");
		test.log(Status.INFO, "Select Customer Type");
		test.log(Status.PASS, "Senior citizen selected successfully");
	}
	
	@Test(priority=1)
	public void FixedDeposite_Monthly_Payout() {
		
		TestFunctions.SelectDepositeType(driver);
		test.log(Status.INFO, "Select type of Fixed Deposit");
		test.log(Status.PASS, "Monthly Payout selected successfully");
	}
	
	@Test(priority=2)
	public void Amount() throws Exception {
		
		TestFunctions.EnterAmount(driver);
		
		test.log(Status.INFO, "Enter Amount");
		test.log(Status.PASS, "Amount entered successfully");
	}
	
	@Test(priority=3)
	public void ClickAnyWhereOnScreen() {
		
		TestFunctions.EnterAnywhereonScreen(driver);
		
		test.log(Status.INFO, "Click anywhere on the screen");
		test.log(Status.PASS, "Clicked successfully");
	}
	@Test(priority=4)
	public void PrintRateofInterest() throws Exception {

		TestFunctions.PrintRateofInterest(driver);
		TakeScreenshot.screenshot(driver,"Interesr_Rate");
		
		test.log(Status.INFO, "Print Rate of Interest");
		test.log(Status.PASS, "Rate of Interest printed successfully");
	}
	
	@Test(priority=5)
	public void Takescreenshot() throws Exception {
		Thread.sleep(3000);
		TakeScreenshot.screenshot(driver,"Interesr_Rate");
		
		test.log(Status.INFO, "Take ScreeShot");
		test.log(Status.PASS, "Screenshot taken successfully");
	}
	
	@Test(priority=6)
	public void CloseBrowser() {
		
		DriverSetup.driverClose(driver);
		
		test.log(Status.INFO, "Close the browser");
		test.log(Status.PASS, "Browser closed successfully");
	}
}
