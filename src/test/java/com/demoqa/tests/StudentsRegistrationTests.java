package com.demoqa.tests;

import com.demoqa.pages.MainPage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentsRegistrationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new MainPage(driver).goToPracticeFormPage();
        new SidePanelPage(driver).selectPracticeForm();
    }

    @Test
    public void fillPracticeForm() {
        new PracticeFormPage(driver).fillMainInfoUser
                ("Rusaldo", "Russ", "rusik@mail.com", "1122334455")
                .selectGender("male").typeBirthday("18 мая 1989")
                .selectHobby("Reading")
                .addSubject("Maths").uploadFile("/Users/anastasiaivanova/Downloads/раскраска_01.jpg")
                .typeAddress("Sea").chooseStateAndCity2("NCR", "Delhi").submit();
        Assert.assertTrue(new PracticeFormPage(driver).turnToConfirmTable().getTextFromConfirmTable().contains("Thanks"));
    }
}
