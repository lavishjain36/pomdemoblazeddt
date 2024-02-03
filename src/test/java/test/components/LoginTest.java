package test.components;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.components.EngineClass;
import page.components.LoginPage;
import page.components.SignupPage;

public class LoginTest extends EngineClass {

	// Test case  for valid username and password
	@Test(groups = { "Smoke", "Regression" })
	public static void loginTc01() {

		test = report.createTest("loginTc01");
		LoginPage validLogin = new LoginPage();

		validLogin.validLoginFun(readingExcel("Input", 1, 0), readingExcel("Input", 1, 1));

		test.log(Status.PASS, "Login Successful");

	}
	
	//Test Case for valid SignUp
		@Test(groups = { "Smoke", "Regression" })
		public static void signUpTc01() {

			test = report.createTest("SignUpTc01");
			SignupPage validSignUp = new SignupPage();

			validSignUp.signupFn(readingExcel("SignInput", 1, 0), readingExcel("SignInput", 1, 1));

			test.log(Status.PASS, "SignUp Successful");

		}
	
	
}
