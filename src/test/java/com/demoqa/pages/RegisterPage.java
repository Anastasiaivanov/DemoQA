package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    WebElement firstNameField;

    @FindBy(id = "lastname")
    WebElement lastNameField;

    @FindBy(id = "userName")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "register")
    WebElement registerNewUserBtn;

    @FindBy(id = "g-recaptcha")
    WebElement recaptcha;

    public RegisterPage fillNewUserFields(String firstname, String lastname, String username, String password) {
        type(firstNameField, firstname);
        type(lastNameField, lastname);
        type(userNameField, username);
        type(passwordField, password);
        return this;
    }

    public RegisterPage clickOnCaptcha() {
        clickWithActionJava(recaptcha, 0, 200);
        return this;
    }

    public RegisterPage clickOnRegisterBtn() {
        clickWithActionJava(registerNewUserBtn, 0, 200);
        return this;
    }
}
