package com.demoqa.tests.elementstests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.LinksPage;
import com.demoqa.pages.SidePanelPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksAndBrokenTests extends TestBase {

    @BeforeMethod
    public void preConditions() {
        new HomePage(driver).goToElementsPage();
    }

    @Test
    public void getAllLinksTest() {
        new SidePanelPage(driver).selectLinks();
        new LinksPage(driver).checkAllURL();
    }

    @Test
    public void getBrokenLinksTest() {
        new SidePanelPage(driver).selectLinks();
        new LinksPage(driver).checkBrokenLinks();
    }

    @Test
    public void getBrokenImagesTest(){
        new SidePanelPage(driver).selectBrokenLinks();
        new LinksPage(driver).checkBrokenImages();
    }
}
