package com.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReport {
	
	public static ExtentReports report;																									//THIS WILL CREATE AN INSTANCE OF THE EXTENTREPORTS CLASS
	
	public static ExtentReports getReportInstance() {
		
		if (report == null) {
			
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\pawan\\eclipse-workspace\\AxisBankProject\\Report\\ExtentReport.html");	//THIS WILL CREATE A NEW OBJECT OF HTMLREPORTER CLASS AT THE SPECIFIED FILEPATH
			report = new ExtentReports();																								//THIS WILL CREATE A NEW REPORT
			report.attachReporter(htmlReporter);																						//THIS WILL ATTACH THE GENERATED REPORT TO THE REPORTER AT THE GIVEN FILEPATH
		}
		
		return report;
	}
}
