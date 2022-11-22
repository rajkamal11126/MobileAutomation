package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.SlotChecking;
import com.qa.reports.ExtentReport;
import com.qa.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.*;

import java.io.InputStream;
import java.lang.reflect.Method;

public class SlotTests extends BaseTest{
	LoginPage loginPage;
	LoginTests loginTests;
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

	  @Test(priority = 1)
	  public void loginForSlotBooking(Method m) throws InterruptedException {
		  utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
		  loginPage = new LoginPage();
		  loginPage.login(loginUsers.getJSONObject("validUser").getString("username"));
		  loginPage.clickOnOTPButton();
		  loginPage.enterPasswordOne(loginUsers.getJSONObject("validUser").getString("passwordOne"));
		  loginPage.enterPasswordTwo(loginUsers.getJSONObject("validUser").getString("passwordTwo"));
		  loginPage.enterPasswordThree(loginUsers.getJSONObject("validUser").getString("passwordThree"));
		  loginPage.enterPasswordFour(loginUsers.getJSONObject("validUser").getString("passwordFour"));
		  utils.log().info("Entered Password");
		  ExtentReport.getTest().info("Entered Password");
		  loginPage.clickVerifyOTP();
		  utils.log().info("Clicked on Verify OTP button");
		  ExtentReport.getTest().info("Clicked on Verify OTP button");
		  loginPage.enterMPINOne(loginUsers.getJSONObject("MPIN").getString("passwordMPINOne"));
		  loginPage.enterMPINTwo(loginUsers.getJSONObject("MPIN").getString("passwordMPINTwo"));
		  loginPage.enterMPINThree(loginUsers.getJSONObject("MPIN").getString("passwordMPINThree"));
		  loginPage.enterMPINFour(loginUsers.getJSONObject("MPIN").getString("passwordMPINFour"));
		  utils.log().info("Entered MPIN Password");
		  ExtentReport.getTest().info("Entered MPIN Password");
		  loginPage.enterConfirmMPINOne(loginUsers.getJSONObject("MPIN").getString("passwordMPINOne"));
		  loginPage.enterConfirmMPINTwo(loginUsers.getJSONObject("MPIN").getString("passwordMPINTwo"));
		  loginPage.enterConfirmMPINThree(loginUsers.getJSONObject("MPIN").getString("passwordMPINThree"));
		  loginPage.enterConfirmMPINFour(loginUsers.getJSONObject("MPIN").getString("passwordMPINFour"));
		  utils.log().info("Entered MPIN Confirm Password");
		  ExtentReport.getTest().info("Entered MPIN Confirm Password");
		  loginPage.buttonConfirmMPIN();
		  utils.log().info("Clicked on Confirm MPIN button");
		  ExtentReport.getTest().info("Clicked on Confirm MPIN button");
		  loginPage.buttonContinue();
		  utils.log().info("Clicked on Continue button");
		  ExtentReport.getTest().info("Clicked on Continue button");
		  loginPage.skipButton();
		  ExtentReport.getTest().info("Clicked on Skip button");
		  utils.log().info("Clicked on Skip button");

	  }

//	  @Test(priority = 2)
//	  public void mpinLogin() throws InterruptedException {
//		  loginPage.enterPasswordOne(loginUsers.getJSONObject("validUser").getString("passwordOne"));
//		  loginPage.enterPasswordTwo(loginUsers.getJSONObject("validUser").getString("passwordTwo"));
//		  loginPage.enterPasswordThree(loginUsers.getJSONObject("validUser").getString("passwordThree"));
//		  loginPage.enterPasswordFour(loginUsers.getJSONObject("validUser").getString("passwordFour"));
//		  utils.log().info("Entered Password");
//		  ExtentReport.getTest().info("Entered Password");
//		  loginPage.clickVerifyOTP();
//		  utils.log().info("Clicked on Verify OTP button");
//		  ExtentReport.getTest().info("Clicked on Verify OTP button");
//		  loginPage.enterMPINOne(loginUsers.getJSONObject("MPIN").getString("passwordMPINOne"));
//		  loginPage.enterMPINTwo(loginUsers.getJSONObject("MPIN").getString("passwordMPINTwo"));
//		  loginPage.enterMPINThree(loginUsers.getJSONObject("MPIN").getString("passwordMPINThree"));
//		  loginPage.enterMPINFour(loginUsers.getJSONObject("MPIN").getString("passwordMPINFour"));
//		  utils.log().info("Entered MPIN Password");
//		  ExtentReport.getTest().info("Entered MPIN Password");
//		  loginPage.enterConfirmMPINOne(loginUsers.getJSONObject("MPIN").getString("passwordMPINOne"));
//		  loginPage.enterConfirmMPINTwo(loginUsers.getJSONObject("MPIN").getString("passwordMPINTwo"));
//		  loginPage.enterConfirmMPINThree(loginUsers.getJSONObject("MPIN").getString("passwordMPINThree"));
//		  loginPage.enterConfirmMPINFour(loginUsers.getJSONObject("MPIN").getString("passwordMPINFour"));
//		  utils.log().info("Entered MPIN Confirm Password");
//		  ExtentReport.getTest().info("Entered MPIN Confirm Password");
//		  loginPage.buttonConfirmMPIN();
//		  utils.log().info("Clicked on Confirm MPIN button");
//		  ExtentReport.getTest().info("Clicked on Confirm MPIN button");
//		  loginPage.buttonContinue();
//		  utils.log().info("Clicked on Continue button");
//		  ExtentReport.getTest().info("Clicked on Continue button");
//		  loginPage.skipButton();
//		  ExtentReport.getTest().info("Clicked on Skip button");
//		  utils.log().info("Clicked on Skip button");
//	  }

	  @Test(priority = 2)
	  public void bookAppointmentPage() throws InterruptedException {
		  productsPage = new SlotChecking();
		  productsPage.bookAppointmentButton();
		  utils.log().info("Clicked on Book Appointment button");
		  ExtentReport.getTest().info("Clicked on Book Appointment button");
		  productsPage.selectDepartmentCardio();
		  utils.log().info("Department is selected");
		  ExtentReport.getTest().info("Department is selected");
		  productsPage.selectDoctor();
		  utils.log().info("Doctor is selected");
		  ExtentReport.getTest().info("Doctor is selected");
		  productsPage.videoConsultation();
		  utils.log().info("Consultant Type is selected");
		  ExtentReport.getTest().info("Consultant Type is selected");
		  productsPage.selectDateOfAppointment();
		  SlotChecking obj =  productsPage.selectDayOfAppointment();
		  if(obj !=null){
			  productsPage.selectTimeOfAppointment();
		  }
	  }
}
