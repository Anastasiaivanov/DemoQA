package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SelectMenuPage;
import com.demoqa.pages.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToWindowWidgets();
        new SidePanelPage(driver).selectSelectMenu();
    }

    @Test
    public void clickOnOldStyleTest() {
        new SelectMenuPage(driver).clickOnOldStyle("Blue");
    }

    @Test
    public void clickOnMultiSelectDropTest(){
        new SelectMenuPage(driver).clickOnOptions("Red");
    }

    @Test
    public void multiSelectDropDownTest(){
        new SelectMenuPage(driver).clickMultiSelectDroDown("Red");
    }

    @Test
    public void clickMultiSelect(){
        new SelectMenuPage(driver).standardMultiSelect();
    }
}
