package com.demoqa.tests;

import com.demoqa.pages.ElementsPage;
import com.demoqa.pages.MainPage;
import com.demoqa.pages.ProfilePage;
import org.testng.annotations.Test;

public class ElementsTests extends TestBase{

    @Test
    public void textFormTest() {
        new MainPage(driver).goToElementsPage();
        new ElementsPage(driver).goToTextBox()
                .fillTextBoxFields("Rusaldo", "russ@mail.com", "Berlin", "Brandenburg");
    }
}
