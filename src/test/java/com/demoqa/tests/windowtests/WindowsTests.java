package com.demoqa.tests.windowtests;

import com.demoqa.pages.BrowserWindowPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanelPage;
import com.demoqa.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToAlertPage();
        new SidePanelPage(driver).selectBrowserWindows();
    }

    @Test
    public void newTabTest() {
        new BrowserWindowPage(driver).clickOnNewTab();
        Assert.assertTrue(new BrowserWindowPage(driver)
                .getTextFromNewTab().contains("sample"));
    }

    @Test
    public void newWindowTest() {
        new BrowserWindowPage(driver).clickOnNewWindow();
        Assert.assertTrue(new BrowserWindowPage(driver)
                .getTextFromNewTab().contains("sample"));
    }

    @Test
    public void newWindowMsgTest() {
        new BrowserWindowPage(driver).clickOnNewWindowMsg();
        Assert.assertTrue(new BrowserWindowPage(driver)
                .getTextFromNewWindow().contains("Knowledge"));
    }
}
