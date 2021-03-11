package com.demoqa.tests.bookstoretests;

import com.demoqa.pages.LoginPage;
import com.demoqa.pages.MainPage;
import com.demoqa.pages.ProfilePage;
import com.demoqa.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookToCollection extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new MainPage(driver).goToBookStore();
        new ProfilePage(driver).goToLoginForm();
        new LoginPage(driver).loginPositive("rusaldo", "Rusaldo12345!!");
    }

    @Test
    public void addBookToCollectionTest() {
        String text = "Git";
        new ProfilePage(driver).findBook(text);
        new ProfilePage(driver).clickByFirstBookInTab()
                .addBookToCollection().clickOnProfileBtn();
        Assert.assertTrue(new ProfilePage(driver).takeNameOfBook().contains(text));

    }
}
