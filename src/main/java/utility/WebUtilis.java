package utility;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class WebUtilis extends JavaUtilis {

	public static WebDriver driver = null;
	public static ExtentHtmlReporter html = null;
	public static ExtentReports report = null;
	public static ExtentTest test = null;

	//Method for clicking the element
	public static void buttonClick(WebElement element) {

		waitExplicit(element, 5);
		try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(true)", element);
			element.click();
			test.log(Status.INFO, "Element is Clicked");
		}
		catch(Exception e){
			
			e.printStackTrace();		
		}
		
	}

	//Method for sending Key to text box
	public static void textKey(WebElement element, String value) {

		element.sendKeys(value);

	}

	//Mehtod to take ScreenShot
	public static String takeScreenshot() {
		
		String location = System.getProperty("user.dir") + "/LoginPage.png";
		try {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File source = tss.getScreenshotAs(OutputType.FILE);
		File destination = new File(location);
		
			FileHandler.copy(source, destination);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return location;

	}
	
	//Method for Implicit wait
	public static void waitImplicit(int value) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));
	}

	//Method for getText
	public static String elementText(WebElement element) {

		waitExplicit(element, 5);
		String value = element.getText();
		return value;
	}

	//Mehtod to check the Url
	public static String getURL() {

		String value = driver.getCurrentUrl();

		return value;
	}

	//Method for Explicit wait
	public static void waitExplicit(WebElement element, int value) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	//Method for dropdown by value
	public static void dropDown(WebElement element, String value) {

		Select sel = new Select(element);

		sel.selectByValue(value);
	}

	//Method alert box
	public static String messageAlert() {

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String value = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return value;
	}
	
	

}
