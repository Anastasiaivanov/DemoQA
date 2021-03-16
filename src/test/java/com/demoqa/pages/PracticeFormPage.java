package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends PageBase {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement mobileNumber;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement mailGenderBtn;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femailGenderBtn;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherGenderBtn;

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirth;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sportHobby;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement readHobby;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement musicHobby;

    @FindBy(id = "subjectsInput")
    WebElement subjectInput;

    @FindBy(id = "react-select-2-option-0")
    WebElement selectSubjInput;

    @FindBy(id = "uploadPicture")
    WebElement chooseFile;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "state")
    WebElement userState;

    @FindBy(id = "city")
    WebElement userCity;

    @FindBy(id = "submit")
    WebElement submitBtn;

    public PracticeFormPage fillMainInfoUser(String fName, String lName, String email, String phone) {
        type(firstName, fName);
        type(lastName, lName);
        type(userEmail, email);
        type(mobileNumber, phone);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            mailGenderBtn.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            femailGenderBtn.click();
        } else {
            otherGenderBtn.click();
        }
        return this;
    }

    public PracticeFormPage typeBirthday(String birthday) {
        dateOfBirth.click();
        String os = System.getProperty("os.name");
        System.out.println(os);
        if (os.startsWith("Mac")) {
            dateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        dateOfBirth.sendKeys(birthday);
        dateOfBirth.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage selectHobby(String hobby) {
        if (hobby.equalsIgnoreCase("Sport")) {
            clickWithActionJava(sportHobby, 0, 300);
        } else if (hobby.equalsIgnoreCase("Reading")) {
            clickWithActionJava(readHobby, 0, 300);
        } else if (hobby.equalsIgnoreCase("Music")) {
            clickWithActionJava(musicHobby, 0, 300);
        }
        return this;
    }

    public PracticeFormPage addSubject(String subject) {
        type(subjectInput, subject);
        selectSubjInput.click();
        return this;
    }

    public PracticeFormPage uploadFile(String path) {
        chooseFile.sendKeys(path);
        pause(2000);
        return this;
    }

    public PracticeFormPage typeAddress(String address) {
        typeWithAction(currentAddress, 0, 300, address);
        return this;
    }

    public PracticeFormPage chooseStateAndCity(String state, String city) {
        clickWithActionJava(userState, 0, 300);
        if (state.equalsIgnoreCase("NCR")) {
            driver.findElement(By.id("react-select-3-option-0")).click();
            userCity.click();
            if (city.equalsIgnoreCase("Delhi")) {
                driver.findElement(By.id("react-select-4-option-0")).click();
            } else if (city.equalsIgnoreCase("Gurgaon")) {
                driver.findElement(By.id("react-select-4-option-1")).click();
            } else if (city.equalsIgnoreCase("Noida")) {
                driver.findElement(By.id("react-select-4-option-2")).click();
            }
        }
        return this;
    }

    public PracticeFormPage submit() {
        clickWithActionJava(submitBtn, 0, 300);
        return this;
    }

    public PracticeFormPage turnToConfirmTable() {
        driver.switchTo().activeElement();
        return this;
    }

    public String getTextFromConfirmTable() {
        return driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
    }
}
