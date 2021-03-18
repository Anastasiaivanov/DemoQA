package com.demoqa.tests.elementstests;

import com.demoqa.pages.ElementsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanelPage;
import com.demoqa.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).goToElementsPage();
    }

    @Test
    public void textFormTest() {
        new SidePanelPage(driver).selectTextBox();
        new ElementsPage(driver).fillTextBoxFields("Rusaldo", "russ@mail.com", "Berlin", "Brandenburg");
        System.out.println(new ElementsPage(driver).getNameFromConfirmTable());
        Assert.assertTrue(new ElementsPage(driver).getNameFromConfirmTable().contains("Name:Rusaldo"));
        Assert.assertTrue(new ElementsPage(driver).getEmailFromConfirmTable().contains("Email:russ@mail.com"));
    }
}
