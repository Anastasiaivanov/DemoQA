package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement user;

    @FindBy(id = "submit")
    WebElement logoutBtn;

    @FindBy(id = "login")
    WebElement loginBtn;

    @FindBy(id = "searchBox")
    WebElement searchBookField;

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement titleOfBook;

    @FindBy(id = "addNewRecordButton")
    WebElement addToCollectionBtn;

    @FindBy(css = ".text-right.button.di")
    WebElement deleteBookFromCollectionBtn;

    @FindBy(xpath = "//span[contains(text(),'Profile')]")
    WebElement goToProfileBtn;

    public ProfilePage verifyUsername(String username) {
        if (user.getText().equalsIgnoreCase(username)) {
            System.out.println("Correct username " + user.getText());
        } else {
            System.out.println("Incorrect username " + user.getText());
        }
        return this;
    }

    public LoginPage logout() {
        System.out.println("Let's go out from this profile");
        logoutBtn.click();
        return new LoginPage(driver);
    }

    public LoginPage goToLoginForm() {
        loginBtn.click();
        return new LoginPage(driver);
    }

    public ProfilePage findBook(String book) {
        type(searchBookField, book);
        return this;
    }

    public String takeNameOfBook() {
        pause(500);
        return driver.findElement(By.xpath("//span[@class='mr-2']/a")).getText();
    }

    public String verifyEmptyField() {
        pause(500);
        return driver.findElement
                (By.cssSelector(".rt-tr-group:nth-child(1) .rt-td:nth-child(2)")).getText();
    }

    public ProfilePage addBookToUsersCollection() {
        titleOfBook.click();
        pause(500);
        scrollDownPage();
        addToCollectionBtn.click();
        //driver.switchTo().alert().accept();
        return this;
    }

    public ProfilePage deleteBookFromUsersCollection() {
        scrollDownPage();
        goToProfileBtn.click();
        scrollDownPage();
        deleteBookFromCollectionBtn.click();
        return this;
    }
}
