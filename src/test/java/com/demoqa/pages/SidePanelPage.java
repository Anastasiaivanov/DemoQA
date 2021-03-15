package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends PageBase {

    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindowBtn;

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alertsBtn;

    public BrowserWindowPage selectBrowserWindows() {
        clickWithActionJava(browserWindowBtn, 0, 300);
        return new BrowserWindowPage(driver);
    }

    public AlertsPage selectAlerts() {
        clickWithActionJava(alertsBtn, 0, 300);
        return new AlertsPage(driver);
    }
}
