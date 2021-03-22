package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatePickerPage extends PageBase {

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "datePickerMonthYearInput")
    WebElement selectDateField;

    @FindBy(id = "dateAndTimePickerInput")
    WebElement selectDateAndTimeField;

    @FindBy(xpath = "//html")
    WebElement space;

    public DatePickerPage setDate(String text) {
        type(selectDateField, text);
        space.click();
        return this;
    }

    public DatePickerPage setDateAndTime(String dateAndTime) {
        type(selectDateAndTimeField, dateAndTime);
        space.click();
        return this;
    }
}

