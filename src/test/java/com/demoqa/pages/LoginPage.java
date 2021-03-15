package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement passWord;

    @FindBy(id = "login")
    WebElement loginBtn;

    @FindBy(id = "newUser")
    WebElement addNewUserBtn;

    public RegisterPage goToRegisterPage() {
        addNewUserBtn.click();
        return new RegisterPage(driver);
    }

    public ProfilePage loginPositive(String username, String password) {
        type(userName, username);
        type(passWord, password);
        loginBtn.click();
        return new ProfilePage(driver);
    }

    public LoginPage loginNegative(String username, String password) {
        type(userName, username);
        type(passWord, password);
        loginBtn.click();
        return this;
    }
}
