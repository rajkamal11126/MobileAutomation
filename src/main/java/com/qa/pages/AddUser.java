package com.qa.pages;


import com.qa.BaseTest;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class AddUser extends BaseTest {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/btnPayValue")
    private MobileElement okButton;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/noId")
    private MobileElement noButton;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/first_name_edit_text")
    private MobileElement firstName;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/last_name_edit_text")
    private MobileElement lastName;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/ivSpinnerArrowPatient")
    private MobileElement selectPatient;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/layoutAddUser")
    private MobileElement selectAddMember;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/mobile_edit_text")
    private MobileElement mobileNumber;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/email_edit_text")
    private MobileElement emailID;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/spinnerView")
    private MobileElement gender;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    private MobileElement selectMale;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/relation_edit_text")
    private MobileElement selectRelationShip;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/buttonSaveChangesInScroll")
    private MobileElement saveButton;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[3]/android.widget.ImageView")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.ImageView")
    private MobileElement backButtonInSelectDoctor;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/back_btn")
    private MobileElement backButtonInSelectDepartment;


    public AddUser appointment(String elementName) {
        scrollToElement(elementName);
        click(selectAddMember);

        return this;
    }

    public AddUser noButtonClick() {
        click(noButton);
        return this;
    }


    public AddUser enterFirstName(String first_Name) {
//        clear(firstName);
        sendKeys(firstName, first_Name);
        return this;
    }

    public AddUser enterLastName(String last_Name) {
//        clear(lastName);
        sendKeys(lastName, last_Name);
        return this;
    }

    public AddUser enterMobileNumber(String mobileNo) {
//        clear(mobileNumber);
        sendKeys(mobileNumber, mobileNo);
        return this;
    }

    public AddUser enterEmail(String email) {
//        clear(emailID);
        sendKeys(emailID, email);
        return this;
    }

    public AddUser enterGender() {
        click(gender);
        return this;
    }

    public AddUser maleGender() {
        click(selectMale);
        return this;
    }

    public AddUser select_Relationship() {
        click(selectRelationShip);
        return this;
    }

    public AddUser chooseMember() throws InterruptedException {
        Thread.sleep(2000);
        TouchAction touchAction = new TouchAction(driver.get());
        touchAction.tap(PointOption.point(200, 348)).perform();
        Thread.sleep(2000);
        return this;
    }

    public AddUser saveDetails() {
        click(saveButton);
        return this;
    }

    public AddUser back() {
            click(backButton);
            return this;
    }

    public AddUser backButtonOfSelectDoctorScreen(){
        click(backButtonInSelectDoctor);
        return this;
    }

    public AddUser backButtonOfSelectDepartmentScreen(){
        click(backButtonInSelectDepartment);
        return this;
    }
}
