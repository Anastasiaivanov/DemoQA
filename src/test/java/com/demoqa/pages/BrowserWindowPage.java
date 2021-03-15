package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowPage extends PageBase {

    public BrowserWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement newTabBtn;

    @FindBy(id = "windowButton")
    WebElement newWindowBtn;

    @FindBy(id = "messageWindowButton")
    WebElement newWindowMsgBtn;

    public BrowserWindowPage clickOnNewTab() {
        newTabBtn.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public BrowserWindowPage clickOnNewWindow() {
        newWindowBtn.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public BrowserWindowPage clickOnNewWindowMsg() {
        newWindowMsgBtn.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public String getTextFromNewTab() {
        return driver.findElement(By.id("sampleHeading")).getText();
    }

    public String getTextFromNewWindow() {
        return driver.findElement(By.xpath("/html/body")).getText();
    }
}
