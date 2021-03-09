package com.demoqa.tests;

import com.demoqa.pages.LoginPage;
import com.demoqa.pages.MainPage;
import com.demoqa.pages.ProfilePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchBookTests extends TestBase {

    @BeforeMethod
    public void preConditions() {
        new MainPage(driver).goToProfilePage();
        new ProfilePage(driver).goToLoginForm();
        new LoginPage(driver).loginPositive("rusaldo", "Rusaldo12345!!")
                .verifyUsername("rusaldo");
    }

    @Test
    public void searchBookPositiveTest() throws IOException {
        String text = "Git";
        new ProfilePage(driver).findBook(text).takeNameOfBook();
        Assert.assertTrue(new ProfilePage(driver).takeNameOfBook().contains(text));
        new ProfilePage(driver).takeScreenshotField(driver.findElement(By.xpath("//span[@class='mr-2']/a")));
    }

    @Test
    public void verifyEmptyFieldTest() {
        new ProfilePage(driver).findBook("  ").verifyEmptyField();
        Assert.assertTrue(new ProfilePage(driver).verifyEmptyField().contains(""));
    }

    @Test
    public void addAnDeleteBooksToCollection() {
        String text = "Git";
        new ProfilePage(driver).findBook(text).takeNameOfBook();
        Assert.assertTrue(new ProfilePage(driver).takeNameOfBook().contains(text));
        new ProfilePage(driver).addBookToUsersCollection();
        new ProfilePage(driver).deleteBookFromUsersCollection();
    }
}
