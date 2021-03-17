package com.demoqa.tests;

import com.demoqa.helpers.JsExecutor;
import com.demoqa.pages.AlertsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanelPage;
import org.testng.annotations.Test;

public class JsExecutorTests extends TestBase {

    @Test
    public void executorTest() {
        new HomePage(driver).goToElementsPage();
        new SidePanelPage(driver).selectTextBox();
        new JsExecutor(driver).typeNameEmailWithExecutor("Rusaldo Russ", "russ@mail.com")
                .scrollWithJse().clickOnSubmitJsE().refreshBrowserJsE();
    }

    @Test
    public void checkBoxJsETest() {
        new HomePage(driver).goToPracticeFormPage();
        new SidePanelPage(driver).selectPracticeForm();
        new JsExecutor(driver).checkBoxJsE().alertWithJs();
        new AlertsPage(driver).alertAccept();
        new JsExecutor(driver).getTitlePageJsE().getUrlPageJsE();
    }
}
