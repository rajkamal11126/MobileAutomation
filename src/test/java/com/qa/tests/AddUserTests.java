package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.AddUser;
import com.qa.pages.LoginPage;
import com.qa.pages.SlotChecking;
import com.qa.reports.ExtentReport;
import com.qa.utils.TestUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.lang.reflect.Method;

public class AddUserTests extends BaseTest {

    LoginPage loginPage;
    SlotChecking productsPage;
    AddUser addUser;
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
    public void loginForAddUsers(Method m) throws InterruptedException {
        loginPage = new LoginPage();
        utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
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

//    @Test(priority = 2)
//    public void mpinLogin() throws InterruptedException {
//        loginPage.enterPasswordOne(loginUsers.getJSONObject("validUser").getString("passwordOne"));
//        loginPage.enterPasswordTwo(loginUsers.getJSONObject("validUser").getString("passwordTwo"));
//        loginPage.enterPasswordThree(loginUsers.getJSONObject("validUser").getString("passwordThree"));
//        loginPage.enterPasswordFour(loginUsers.getJSONObject("validUser").getString("passwordFour"));
//        utils.log().info("Entered Password");
//        ExtentReport.getTest().info("Entered Password");
//        loginPage.clickVerifyOTP();
//        utils.log().info("Clicked on Verify OTP button");
//        ExtentReport.getTest().info("Clicked on Verify OTP button");
//        loginPage.enterMPINOne(loginUsers.getJSONObject("MPIN").getString("passwordMPINOne"));
//        loginPage.enterMPINTwo(loginUsers.getJSONObject("MPIN").getString("passwordMPINTwo"));
//        loginPage.enterMPINThree(loginUsers.getJSONObject("MPIN").getString("passwordMPINThree"));
//        loginPage.enterMPINFour(loginUsers.getJSONObject("MPIN").getString("passwordMPINFour"));
//        utils.log().info("Entered MPIN Password");
//        ExtentReport.getTest().info("Entered MPIN Password");
//        loginPage.enterConfirmMPINOne(loginUsers.getJSONObject("MPIN").getString("passwordMPINOne"));
//        loginPage.enterConfirmMPINTwo(loginUsers.getJSONObject("MPIN").getString("passwordMPINTwo"));
//        loginPage.enterConfirmMPINThree(loginUsers.getJSONObject("MPIN").getString("passwordMPINThree"));
//        loginPage.enterConfirmMPINFour(loginUsers.getJSONObject("MPIN").getString("passwordMPINFour"));
//        utils.log().info("Entered MPIN Confirm Password");
//        ExtentReport.getTest().info("Entered MPIN Confirm Password");
//        loginPage.buttonConfirmMPIN();
//        utils.log().info("Clicked on Confirm MPIN button");
//        ExtentReport.getTest().info("Clicked on Confirm MPIN button");
//        loginPage.buttonContinue();
//        utils.log().info("Clicked on Continue button");
//        ExtentReport.getTest().info("Clicked on Continue button");
//        loginPage.skipButton();
//        ExtentReport.getTest().info("Clicked on Skip button");
//        utils.log().info("Clicked on Skip button");
//    }

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
        utils.log().info("Video consultant is selected");
        ExtentReport.getTest().info("Video consultant is selected");
        productsPage.selectDateOfAppointment();
        utils.log().info("Date is selected");
        ExtentReport.getTest().info("Date is selected");
        productsPage.selectDayOfAppointment();
        utils.log().info("Day is selected");
        ExtentReport.getTest().info("Day is selected");

    }

    @Test(priority = 3)
    public void addUserInAppointment() throws InterruptedException {

        addUser = new AddUser();
        productsPage.patientSelector();
        utils.log().info("Clicked Patient dropdown");
        ExtentReport.getTest().info("Clicked Patient dropdown");
        addUser.appointment("Add User");
        utils.log().info("Selected Add new user ");
        ExtentReport.getTest().info("Selected Add new user");
        addUser.noButtonClick();
        utils.log().info("Clicked No button in the popup");
        ExtentReport.getTest().info("Clicked No button in the popup");
        addUser.enterFirstName(loginUsers.getJSONObject("membersDetails").getString("firstName"));
        utils.log().info("First name is entered");
        ExtentReport.getTest().info("First name is entered");
        addUser.enterLastName(loginUsers.getJSONObject("membersDetails").getString("lastName"));
        utils.log().info("Last name is entered");
        ExtentReport.getTest().info("Last name is entered");
        addUser.enterMobileNumber(loginUsers.getJSONObject("membersDetails").getString("mobileNumber"));
        utils.log().info("Mobile number is entered");
        ExtentReport.getTest().info("Mobile number is entered");
        addUser.enterEmail(loginUsers.getJSONObject("membersDetails").getString("emailAddress"));
        utils.log().info("Email address is entered");
        ExtentReport.getTest().info("Email address is entered");
        addUser.enterGender();
        utils.log().info("Clicked on the gender dropdown");
        ExtentReport.getTest().info("Clicked on the gender dropdown");
        addUser.maleGender();
        utils.log().info("Selected male in the gender dropdown");
        ExtentReport.getTest().info("Selected male in the gender dropdown");
        addUser.select_Relationship();
        utils.log().info("Clicked on relationship dropdown");
        ExtentReport.getTest().info("Clicked on relationship dropdown");
        addUser.chooseMember();
        utils.log().info("Clicked on member");
        ExtentReport.getTest().info("Clicked on member");
        addUser.saveDetails();
        utils.log().info("Clicked on Save button");
        ExtentReport.getTest().info("Clicked on Save button");
    }
}
