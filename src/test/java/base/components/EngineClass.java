package base.components;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.WebUtilis;

public class EngineClass extends WebUtilis{

	//open the browser and report
	@BeforeSuite(alwaysRun = true)
	public static void beforeSuite() {

		driver = new ChromeDriver();

		html = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport.html");
		report = new ExtentReports();
		report.attachReporter(html);

	}
	
	//maximize the browser
	@BeforeTest(alwaysRun = true)
	public static void beforeTest() {

		driver.manage().window().maximize();

	}

	//open the Url Link
	@BeforeClass(alwaysRun = true)
	public static void beforeClass() {

		driver.get(openURL("link"));
		
	}
	
	//after method report
	@AfterMethod(alwaysRun = true)
	public static void afterMethod() {
		report.flush();
		
	}
	

	//method to close the browser
	@AfterSuite(alwaysRun = true)
	public static void afterSuite() {

		driver.close();
	
	}
}
