package com.qa.pages;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BaseTest {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/mobile_edit_text")
    private MobileElement enterMobileNumber;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/button_send_otp")
    private MobileElement clickOnOtpButton;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/inputCodeDigitOne")
    private MobileElement oneDigit;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/inputCodeDigitTwo")
    private MobileElement twoDigit;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/inputCodeDigitThree")
    private MobileElement threeDigit;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/inputCodeDigitFour")
    private MobileElement fourDigit;


    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/btnVerifyOtp")
    private MobileElement verifyOTP;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/inputCodeDigitOne")
    private MobileElement oneMPIN;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/inputCodeDigitTwo")
    private MobileElement twoMPIN;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/inputCodeDigitThree")
    private MobileElement threeMPIN;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/inputCodeDigitFour")
    private MobileElement fourMPIN;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/inputConfirmCodeDigitOne")
    private MobileElement confirmOneMPIN;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/inputConfirmCodeDigitTwo")
    private MobileElement confirmTwoMPIN;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/inputConfirmCodeDigitThree")
    private MobileElement confirmThreeMPIN;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/inputConfirmCodeDigitFour")
    private MobileElement confirmFourMPIN;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/buttonConfirmMpin")
    private MobileElement buttonConfirmMPIN;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/buttonContinue")
    private MobileElement buttonContinue;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/buttonSkip")
    private MobileElement skipButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Account\"]/android.widget.ImageView")
    private MobileElement clickAccountButton;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/textLogout")
    private MobileElement logoutButton;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/btnLogout")
    private MobileElement logoutOnPopup;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement errTxt;

    public LoginPage enterUserName(String username) {
        clear(enterMobileNumber);
        sendKeys(enterMobileNumber, username, "Login with" + enterMobileNumber);
        return this;
    }

    public LoginPage enterPasswordOne(String passwordOne) throws InterruptedException {
        Thread.sleep(1000);
        clear(oneDigit);
        sendKeys(oneDigit, passwordOne);

        return this;
    }

    public LoginPage enterPasswordTwo(String passwordTwo) {
        clear(twoDigit);
        sendKeys(twoDigit, passwordTwo);

        return this;
    }

    public LoginPage enterPasswordThree(String passwordThree) {
        clear(threeDigit);
        sendKeys(threeDigit, passwordThree);

        return this;
    }

    public LoginPage enterPasswordFour(String passwordFour) {
        clear(fourDigit);
        sendKeys(fourDigit, passwordFour);
        return this;
    }

    public LoginPage clickVerifyOTP() {
        click(verifyOTP);
        return this;
    }


    public LoginPage enterMPINOne(String passwordMPINOne) throws InterruptedException {
        Thread.sleep(1000);
        clear(oneMPIN);
        sendKeys(oneMPIN, passwordMPINOne);
        return this;
    }

    public LoginPage enterMPINTwo(String passwordMPINTwo) {
        clear(twoMPIN);
        sendKeys(twoMPIN, passwordMPINTwo);
        return this;
    }

    public LoginPage enterMPINThree(String passwordMPINThree) {
        clear(threeMPIN);
        sendKeys(threeMPIN, passwordMPINThree);
        return this;
    }

    public LoginPage enterMPINFour(String passwordMPINFour) {
        clear(fourMPIN);
        sendKeys(fourMPIN, passwordMPINFour);
        return this;
    }


    public LoginPage enterConfirmMPINOne(String passwordMPINOne) {
        clear(confirmOneMPIN);
        sendKeys(confirmOneMPIN, passwordMPINOne);
        return this;
    }

    public LoginPage enterConfirmMPINTwo(String passwordMPINTwo) {
        clear(confirmTwoMPIN);
        sendKeys(confirmTwoMPIN, passwordMPINTwo);
        return this;
    }

    public LoginPage enterConfirmMPINThree(String passwordMPINThree) {
        clear(confirmThreeMPIN);
        sendKeys(confirmThreeMPIN, passwordMPINThree);
        return this;
    }

    public LoginPage enterConfirmMPINFour(String passwordMPINFour) {
        clear(confirmFourMPIN);
        sendKeys(confirmFourMPIN, passwordMPINFour);
        return this;
    }

    public LoginPage buttonConfirmMPIN() {
        click(buttonConfirmMPIN);
        return this;
    }

    public LoginPage buttonContinue() {
        click(buttonContinue);
        return this;
    }

    public LoginPage account() {
        click(clickAccountButton);
        return this;
    }

    public LoginPage logOut() {
        click(logoutButton);
        return this;
    }

    public LoginPage popupLogout() {
        click(logoutOnPopup);
        return this;
    }

    public void skipButton() throws InterruptedException {
        click(skipButton);
        Thread.sleep(1000);
    }

    public SlotChecking login(String username) throws InterruptedException {
        enterUserName(username);
        return new SlotChecking();
    }

    public String getErrTxt() {
        String err = getText(errTxt, "error text is - ");
        return err;
    }

    public LoginPage clickOnOTPButton() {
        click(clickOnOtpButton);
        return this;
    }
}
