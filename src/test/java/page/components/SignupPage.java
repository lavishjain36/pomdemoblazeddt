package page.components;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class SignupPage extends WebUtilis {
	
	//Web Elements for Sign Up page
	@FindBy (xpath ="//a[@id='signin2']")
	static WebElement signupIcon;
	
	@FindBy (xpath ="//input[@id='sign-username']")
	static WebElement userName;
	
	@FindBy (xpath ="//input[@id='sign-password']")
	static WebElement passWord;
	
	@FindBy (xpath ="//button[@onclick='register()']")
	static WebElement signUpButton;
	
	//PageFactory method 
	public SignupPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Mehtod for Signup functionality
	public void signupFn(String userId, String passKey) {

		waitImplicit(5);
		waitExplicit(signupIcon, 5);
		buttonClick(signupIcon);
		waitExplicit(userName, 5);
		textKey(userName, userId);
		textKey(passWord, passKey);
		waitExplicit(signUpButton, 5);
		buttonClick(signUpButton);
		
		
		try {
			test.addScreenCaptureFromPath(takeScreenshot());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String actual = messageAlert();

		Assert.assertEquals(actual, "Sign up successful.");
		
	}

	//Method for invalid signup functionality
	public void userExists(String userId, String passKey) {

		waitImplicit(5);
		waitExplicit(signupIcon, 5);
		buttonClick(signupIcon);
		waitExplicit(userName, 5);
		textKey(userName, userId);
		textKey(passWord, passKey);
		waitExplicit(signUpButton, 5);
		buttonClick(signUpButton);
		
		
		try {
			test.addScreenCaptureFromPath(takeScreenshot());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String actual = messageAlert();

		Assert.assertNotEquals(actual, "Sign up successful.");
	}

}

