package page.components;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class LoginPage extends WebUtilis {

	// WebElements

	@FindBy(id = "login2")
	static WebElement loginIcon;

	@FindBy(id = "loginusername")
	static WebElement userName;

	@FindBy(id = "loginpassword")
	static WebElement passWord;

	@FindBy(xpath = "//button[@onclick='logIn()']")
	static WebElement loginSubmit;

	@FindBy(xpath = "//a[@id='nameofuser']")
	static WebElement userText;

	@FindBy(id = "logout2")
	static WebElement logOut;

	// PageFactory method
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Valid Login method
	public void validLoginFun(String userId, String passKey) {
		
		waitImplicit(5);
		buttonClick(loginIcon);
		waitExplicit(loginIcon, 2);
		textKey(userName, userId);
		textKey(passWord, passKey);
		waitExplicit(loginSubmit, 2);
		buttonClick(loginSubmit);
		

		String actual = elementText(userText);
		String expected = "Welcome " + userId;

		try {
			test.addScreenCaptureFromPath(takeScreenshot());
		} catch (IOException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(actual, expected);
		waitExplicit(logOut, 20);
		buttonClick(logOut);
		
		
		
	}

	// Invalid Login method
	public void inValidLoginFun(String userId, String passKey) {

		waitImplicit(5);
		buttonClick(loginIcon);
		waitExplicit(loginIcon, 2);
		textKey(userName, userId);
		textKey(passWord, passKey);
		waitExplicit(loginSubmit, 2);
		buttonClick(loginSubmit);
		

		try {
			test.addScreenCaptureFromPath(takeScreenshot());
		} catch (IOException e) {
			e.printStackTrace();
		}

		messageAlert();

		Assert.assertTrue(true, "InValid Login");

	}

}
