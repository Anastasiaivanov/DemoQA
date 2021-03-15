package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends PageBase {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement username;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submitBtn;

    public ElementsPage fillTextBoxFields(String fName, String email, String curAddress, String permAddress) {
        type(username, fName);
        type(userEmail, email);
        type(currentAddress, curAddress);
        scrollDownPage();
        type(permanentAddress, permAddress);
        submitBtn.click();
        return this;
    }

    public String getNameFromConfirmTable() {
        return driver.findElement(By.id("name")).getText();
    }

    public String getEmailFromConfirmTable() {
        return driver.findElement(By.id("email")).getText();
    }

    public String getCurAddFromConfirmTable() {
        return driver.findElement(By.id("currentAddress")).getText();
    }

    public String getPermAddFromConfirmTable() {
        return driver.findElement(By.id("permanentAddress")).getText();
    }
}
