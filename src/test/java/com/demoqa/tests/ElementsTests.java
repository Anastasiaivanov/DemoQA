package com.demoqa.tests;

import com.demoqa.pages.ElementsPage;
import com.demoqa.pages.MainPage;
import com.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsTests extends TestBase {

    @Test
    public void textFormTest() {
        new MainPage(driver).goToElementsPage();
        new SidePanelPage(driver).goToTextBox();
        new ElementsPage(driver).fillTextBoxFields("Rusaldo", "russ@mail.com", "Berlin", "Brandenburg");
        System.out.println(new ElementsPage(driver).getNameFromConfirmTable());
        Assert.assertTrue(new ElementsPage(driver).getNameFromConfirmTable().contains("Name:Rusaldo"));
        Assert.assertTrue(new ElementsPage(driver).getEmailFromConfirmTable().contains("Email:russ@mail.com"));
    }
}
