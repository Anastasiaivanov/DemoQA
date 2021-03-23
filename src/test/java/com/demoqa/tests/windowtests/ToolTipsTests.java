package com.demoqa.tests.windowtests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanelPage;
import com.demoqa.pages.ToolTipsPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToWindowWidgets();
        new SidePanelPage(driver).selectToolTips();
    }

    @Test
    public void ToolTipTest() {
        new ToolTipsPage(driver).hoverInputToSee();
    }
}
