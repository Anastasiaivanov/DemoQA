package com.demoqa.tests.windowtests;

import com.demoqa.pages.AlertsPage;
import com.demoqa.pages.MainPage;
import com.demoqa.pages.SidePanelPage;
import com.demoqa.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new MainPage(driver).goToAlertPage();
        new SidePanelPage(driver).selectAlerts();
    }

    @Test
    public void alertWaitTest() {
        new AlertsPage(driver).clickAlertBtn2();
    }

    @Test
    public void alertCancelTest() {
        new AlertsPage(driver).clickAlertBtn3()
                .clickOnCancelBtn("Cancel");
        Assert.assertTrue(new AlertsPage(driver)
                .getConfirmResult().contains("Cancel"));
    }

    @Test
    public void alertPromtTest() {
        new AlertsPage(driver).clickAlertBtn4()
                .sendTextToAlert("Anastasia");
        Assert.assertTrue(new AlertsPage(driver)
                .getConfirmedLastResult().contains("Anastasia"));
    }

    @Test
    public void alertSimpleTest() {
        new AlertsPage(driver).clickAlertBtn1();
    }
}
