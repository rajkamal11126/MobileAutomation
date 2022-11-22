package com.qa.pages;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SlotChecking extends BaseTest {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/labelHello")
    private static MobileElement productTitleTxt;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/button_send_otp")
    private MobileElement clickOnOtpButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView")
    private MobileElement departmentCardiology;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.cardview.widget.CardView/android.view.ViewGroup")
    private MobileElement selectDoctor;


    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/actionHvButton")
    private MobileElement selectVideoConsultation;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView[1]/androidx.cardview.widget.CardView[2]/android.view.ViewGroup")
    private MobileElement selectDate;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.TextView")
    private MobileElement selectDay;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[3]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView[3]/android.view.ViewGroup[1]/android.widget.TextView")
    private MobileElement selectTime;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/ivSpinnerArrowPatient")
    private MobileElement selectPatient;


    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/btnBookAppointment")
    private MobileElement appointmentBook;


    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/labelBookAnAppointment")
    private MobileElement bookAppointmentButton1;

    @AndroidFindBy(id = "com.manipal.manipalhospitals.test:id/cancel")
    private MobileElement cancelButton;


    public static String getTitle() {
        String title = getText(productTitleTxt, "product page title is - ");
        return title;
    }

    public SlotChecking bookAppointmentButton() throws InterruptedException {
        Thread.sleep(1000);
        click(bookAppointmentButton1);
        return this;
    }

    public SlotChecking clickOnOTP() {
        click(clickOnOtpButton);
        return this;
    }

    public SlotChecking selectDepartmentCardio() {
        click(departmentCardiology);
        return this;
    }

    public SlotChecking selectDoctor() {
        click(selectDoctor);
        return this;
    }

    public SlotChecking videoConsultation() {
        click(selectVideoConsultation);
        return this;
    }

    public SlotChecking selectDateOfAppointment() {
            click(selectDate);
            return this;
//        catch (Exception e) {
//            System.out.println("slots are not available");
//        }
//        return null;
    }

    public SlotChecking selectDayOfAppointment() {
        try {
            click(selectDay);
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Slots are not available");
        }
        return null;
    }

    public SlotChecking selectTimeOfAppointment() {
        try {
            click(selectTime);
        } catch (Exception e) {
            System.out.println("Slots are not available");
        }
        return this;
    }

    public AddUser patientSelector() {
        click(selectPatient);
        return new AddUser();
    }
}
