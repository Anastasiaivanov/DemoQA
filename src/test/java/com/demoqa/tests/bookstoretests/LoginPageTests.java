package com.demoqa.tests.bookstoretests;

import com.demoqa.pages.LoginPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.ProfilePage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @Test
    public void loginTest() {
        new HomePage(driver).goToBookStore();
        new ProfilePage(driver).goToLoginForm();
        new LoginPage(driver).loginPositive("rusaldo", "Rusaldo12345!!")
                .verifyUsername("rusaldo").logout();
    }
}
