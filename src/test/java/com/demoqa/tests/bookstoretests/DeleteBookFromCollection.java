package com.demoqa.tests.bookstoretests;

import com.demoqa.pages.LoginPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.ProfilePage;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBookFromCollection extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).goToBookStore();
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
