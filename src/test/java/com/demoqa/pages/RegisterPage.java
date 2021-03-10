package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "newUser")
    WebElement addNewUserBtn;

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

    public RegisterPage goToRegisterPage(){
        addNewUserBtn.click();
        return new RegisterPage(driver);
    }

    public RegisterPage fillNewUserFields(String firstname, String lastname,String username,String password){
        type(firstNameField, firstname);
        type(lastNameField, lastname);
        type(userNameField, username);
        type(passwordField, password);
        clickWithActionJava(registerNewUserBtn, 0,300);
        return this;
    }
}
