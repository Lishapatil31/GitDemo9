package com.qa.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {
	public static ExtentReports extent;

	public static ExtentReports extentreprts() {

		String str = ".//Reports//";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(str);

		reporter.config().setDocumentTitle("Salesforce Service App report");

		reporter.config().setReportName("Service App Report");

		reporter.config().setTheme(Theme.DARK);

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Project Name", "Salesforce Service App");
		extent.setSystemInfo("Application URL", "https://www.login.salesforce.com/");
		extent.setSystemInfo("Testing Author", "Prasad Kusundal");
		extent.setSystemInfo("Employee Id", "CZ038");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("Environment", "Test Environment");

		

		return extent;
	}

}
