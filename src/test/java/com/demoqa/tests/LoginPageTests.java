package com.demoqa.tests;

import com.demoqa.pages.BookStorePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.pages.MainPage;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @Test
    public void loginTest() {
        new MainPage(driver).goToBookStorePage();
        new BookStorePage(driver).goToLoginForm();
        new LoginPage(driver).loginPositive("rusaldo", "Rusaldo12345!!")
                .verifyUsername("rusaldo").logout();
    }
}
