package com.demoqa.tests;

import com.demoqa.pages.DatePickerPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToWindowWidgets();
        new SidePanelPage(driver).selectDataPicker();
    }

    @Test
    public void setDateTest() {
        new DatePickerPage(driver).setDate("05/22/2021");
    }

    @Test
    public void setDateAndTimeTest() {
        new DatePickerPage(driver).setDateAndTime("May 21 2021 14:00");
    }
}
