package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    @FindBy(className = "react-datepicker__month-select")
    WebElement selectMonth;

    @FindBy(className = "react-datepicker__year-select")
    WebElement selectYear;

    @FindBy(css = ".react-datepicker__day")
    List<WebElement> selectDay;

    public DatePickerPage selectDateToInput(String month, String year, int day){
        selectDateField.click();
        pause(500);
        new Select(selectMonth).selectByVisibleText(month);
        new Select(selectYear).selectByVisibleText(year);
        selectDay.get(day).click();
        return this;
    }

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

