package com.demoqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends PageBase {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timeAlertBtn;

    @FindBy(id = "confirmButton")
    WebElement confirmAlertBtn;

    @FindBy(id = "promtButton") // xpath (//*[@class='col']//button)[last()]
    WebElement promtAlertBtn;

    @FindBy(id = "alertButton")
    WebElement alertBtn;

    public AlertsPage clickAlertBtn2() {
        timeAlertBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        myAlert.accept();
        return this;
    }

    public AlertsPage clickAlertBtn3() {
        confirmAlertBtn.click();
        return this;
    }

    public AlertsPage clickOnCancelBtn(String text) {
        if (text != null && text.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        } else if (text != null & text.equals("Ok")) {
            driver.switchTo().alert().accept();
        }
        return this;
    }

    public String getConfirmResult() {
        return driver.findElement(By.id("confirmResult")).getText();
    }

    public AlertsPage clickAlertBtn4() {
        promtAlertBtn.click();
        return this;
    }

    public AlertsPage sendTextToAlert(String text) {
        if (text != null) {
            driver.switchTo().alert().sendKeys(text);
        }
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        return this;
    }

    public String getConfirmedLastResult() {
        return driver.findElement(By.id("promptResult")).getText();
    }

    public AlertsPage clickAlertBtn1() {
        alertBtn.click();
        driver.switchTo().alert().accept();
        return this;
    }

    public AlertsPage alertAccept() {
        driver.switchTo().alert().accept();
        return this;
    }
}
