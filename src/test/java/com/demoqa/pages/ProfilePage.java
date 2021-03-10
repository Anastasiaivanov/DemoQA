package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(css = ".text-right.fullButton")
    WebElement addToCollectionBtn;

    @FindBy(xpath = "//*[@id='delete-record-undefined']")
    List<WebElement> booklist;

    @FindBy(css = ".show #item-3")
    //xpath = "//span[contains(text(),'Profile')]"
    WebElement goToProfileBtn;

    @FindBy(id = "closeSmallModal-ok")
    WebElement okBtnToDelete;

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

    public ProfilePage clickByFirstBookInTab() {
        titleOfBook.click();
        return this;
    }

    public ProfilePage addBookToCollection() {
        clickWithActionJava(addToCollectionBtn, 0, 300);
        pause(300);
        driver.switchTo().alert().accept();
        return this;
    }

    public ProfilePage clickOnProfileBtn() {
        clickWithActionJava(goToProfileBtn, 0, 500);
        return this;
    }

    public ProfilePage clickOnTrashBin() {
        booklist.get(0).click();
        pause(500);
        okBtnToDelete.click();
        pause(500);
        driver.switchTo().alert().accept();
        return this;
    }
}
