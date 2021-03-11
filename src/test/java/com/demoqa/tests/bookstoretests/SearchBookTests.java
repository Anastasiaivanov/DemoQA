package com.demoqa.tests.bookstoretests;

import com.demoqa.pages.ProfilePage;
import com.demoqa.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchBookTests extends TestBase {

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
}
