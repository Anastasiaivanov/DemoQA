package com.demoqa.tests.bookstoretests;

import com.demoqa.pages.LoginPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.ProfilePage;
import com.demoqa.pages.RegisterPage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterUserTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToBookStore();
        new ProfilePage(driver).goToLoginForm();
        new LoginPage(driver).goToRegisterPage();
    }

    @Test
    public void registerUserPositiveTest() {
        new RegisterPage(driver).fillNewUserFields
                ("Mable", "Pines", "Princess", "Dipper12345!")
                .clickOnCaptcha().clickOnRegisterBtn();
    }

    @Test
    public void registrationTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        String fName = "Mable" + i;
        String lName = "Pines" + i;
        String uName = "Princess" + i;
        String pwd = "Dipper!" + i;
        new RegisterPage(driver).fillNewUserFields(fName, lName, uName, pwd)
                .clickOnCaptcha();
    }
}
