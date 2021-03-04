package com.demoqa.pages;

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
}
