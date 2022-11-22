package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.SlotChecking;
import com.qa.reports.ExtentReport;
import com.qa.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class LoginTests extends BaseTest{
	LoginPage loginPage;
	SlotChecking productsPage;
	JSONObject loginUsers;
	TestUtils utils = new TestUtils();
	
	  @BeforeClass
	  public void beforeClass() throws Exception {
			InputStream datais = null;
		  try {
			  String dataFileName = "data/loginUsers.json";
			  datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			  JSONTokener tokener = new JSONTokener(datais);
			  loginUsers = new JSONObject(tokener);
		  } catch(Exception e) {
			  e.printStackTrace();
			  throw e;
		  } finally {
			  if(datais != null) {
				  datais.close();
			  }
		  }
		  closeApp();
		  launchApp();
	  }

	  @AfterClass
	  public void afterClass() {
	  }
	  
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
		  loginPage = new LoginPage();
	  }

	  @AfterMethod
	  public void afterMethod() {		  
	  }


	  @Test
	  public void invalidPassword() throws InterruptedException {

		  loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
		  utils.log().info("Mobile number is entered");
		  ExtentReport.getTest().info("Mobile number is entered");
		  loginPage.clickOnOTPButton();
		  utils.log().info("Clicked on Sign In with OTP button");
		  ExtentReport.getTest().info("Clicked on Sign In with OTP button");
		  loginPage.enterPasswordOne(loginUsers.getJSONObject("validUser").getString("passwordOne"));
		  loginPage.enterPasswordTwo(loginUsers.getJSONObject("validUser").getString("passwordTwo"));
		  loginPage.enterPasswordThree(loginUsers.getJSONObject("validUser").getString("passwordThree"));
		  loginPage.enterPasswordFour(loginUsers.getJSONObject("validUser").getString("passwordFour"));
		  utils.log().info("OTP entered");
		  ExtentReport.getTest().info("OTP entered");
		  loginPage.clickVerifyOTP();
		  utils.log().info("Clicked on Verify OTP button");
		  ExtentReport.getTest().info("Clicked on Verify OTP button");
		  loginPage.enterMPINOne(loginUsers.getJSONObject("MPIN").getString("passwordMPINOne"));
		  loginPage.enterMPINTwo(loginUsers.getJSONObject("MPIN").getString("passwordMPINTwo"));
		  loginPage.enterMPINThree(loginUsers.getJSONObject("MPIN").getString("passwordMPINThree"));
		  loginPage.enterMPINFour(loginUsers.getJSONObject("MPIN").getString("passwordMPINFour"));
		  utils.log().info("Entered MPIN password");
		  ExtentReport.getTest().info("Entered MPIN password");
		  loginPage.enterConfirmMPINOne(loginUsers.getJSONObject("MPIN").getString("passwordMPINTwo"));
		  loginPage.enterConfirmMPINTwo(loginUsers.getJSONObject("MPIN").getString("passwordMPINTwo"));
		  loginPage.enterConfirmMPINThree(loginUsers.getJSONObject("MPIN").getString("passwordMPINThree"));
		  loginPage.enterConfirmMPINFour(loginUsers.getJSONObject("MPIN").getString("passwordMPINFour"));
		  utils.log().info("Entered Incorrect Confirm MPIN password");
		  ExtentReport.getTest().info("Entered Incorrect Confirm MPIN password");
		  loginPage.buttonConfirmMPIN();
		  utils.log().info("Clicked on Set Your MPIN button");
		  ExtentReport.getTest().info("Clicked on Set Your MPIN button");
		  String actualErrTxt = loginPage.getErrTxt();
		  String expectedErrTxt = "Confirm MPIN does not match";
		  Assert.assertEquals(actualErrTxt, expectedErrTxt);
		  utils.log().info("Validated MPIN password");
		  ExtentReport.getTest().info("Validated MPIN password");

	  }

	  @Test
	  public void successfulLogin() throws InterruptedException {
		  loginPage.enterConfirmMPINOne(loginUsers.getJSONObject("MPIN").getString("passwordMPINOne"));
		  loginPage.enterConfirmMPINTwo(loginUsers.getJSONObject("MPIN").getString("passwordMPINTwo"));
		  loginPage.enterConfirmMPINThree(loginUsers.getJSONObject("MPIN").getString("passwordMPINThree"));
		  loginPage.enterConfirmMPINFour(loginUsers.getJSONObject("MPIN").getString("passwordMPINFour"));
		  utils.log().info("Entered Correct Confirm MPIN Password");
		  ExtentReport.getTest().info("Entered Correct Confirm MPIN Password");
		  loginPage.buttonConfirmMPIN();
		  utils.log().info("Clicked on Confirm MPIN button");
		  ExtentReport.getTest().info("Clicked on Confirm MPIN button");
		  loginPage.buttonContinue();
		  utils.log().info("Clicked on Continue button");
		  ExtentReport.getTest().info("Clicked on Continue button");
		  loginPage.skipButton();
		  utils.log().info("Clicked on Skip button");
		  ExtentReport.getTest().info("Clicked on Skip button");
		  String actualProductTitle = SlotChecking.getTitle();
		  String expectedProductTitle = "Hello,";
		  Assert.assertEquals(actualProductTitle, expectedProductTitle);
		  utils.log().info("Validated Appointment page");
		  ExtentReport.getTest().info("Validated Appointment page");
		  loginPage.account();
		  utils.log().info("Clicked on Account Tab");
		  ExtentReport.getTest().info("Clicked on Account Tab");
		  loginPage.scrollToElement("Logout");
		  utils.log().info("Page is scrolled");
		  ExtentReport.getTest().info("Page is scrolled");
		  loginPage.logOut();
		  utils.log().info("Clicked on Logout button");
		  ExtentReport.getTest().info("Clicked on Logout button");
		  loginPage.popupLogout();
		  utils.log().info("Clicked on Logout button on Popup");
		  ExtentReport.getTest().info("Clicked on Logout button on Popup");


	  }
}
