package com.demoqa.tests;

import com.demoqa.pages.LoginPage;
import com.demoqa.pages.MainPage;
import com.demoqa.pages.ProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBookFromCollection extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new MainPage(driver).goToBookStore();
        new ProfilePage(driver).goToLoginForm();
        new LoginPage(driver).loginPositive("rusaldo", "Rusaldo12345!!");
    }

    @Test
    public void deleteBookFromCollectionTest() {
        String text = "Git";
        new ProfilePage(driver).findBook(text);
        new ProfilePage(driver).clickByFirstBookInTab()
                .addBookToCollection();
        new ProfilePage(driver).clickOnProfileBtn().clickOnTrashBin();
    }
}
