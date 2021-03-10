package com.demoqa.tests;

import com.demoqa.pages.MainPage;
import com.demoqa.pages.ProfilePage;
import com.demoqa.pages.RegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterUserTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new MainPage(driver).goToBookStore();
        new ProfilePage(driver).goToLoginForm();
    }

    @Test
    public void registerUserPositiveTest() {
        new RegisterPage(driver).goToRegisterPage();
        new RegisterPage(driver).fillNewUserFields
                ("Mable", "Pines", "Princess", "Dipper12345!");
    }
}
