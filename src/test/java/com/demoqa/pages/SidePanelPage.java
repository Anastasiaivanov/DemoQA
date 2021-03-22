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

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBoxBtn;

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceFormBtn;

    @FindBy(xpath = "//span[.='Radio Button']")
    WebElement radioButtonBtn;

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinkBtn;

    @FindBy(xpath = "//span[.='Links']")
    WebElement linksBtn;

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenuBtn;

    @FindBy(xpath = "//span[.='Date Picker']")
    WebElement dataPickerBtn;

    public DatePickerPage selectDataPicker(){
        clickWithActionJava(dataPickerBtn,0,300);
        return new DatePickerPage(driver);
    }

    public ElementsPage selectLinks() {
        clickWithActionJava(linksBtn, 0, 300);
        return new ElementsPage(driver);
    }

    public ElementsPage selectBrokenLinks() {
        clickWithActionJava(brokenLinkBtn, 0, 300);
        return new ElementsPage(driver);
    }

    public ElementsPage selectRadioButton() {
        clickWithActionJava(radioButtonBtn, 0, 300);
        return new ElementsPage(driver);
    }

    public ElementsPage selectTextBox() {
        clickWithActionJava(textBoxBtn, 0, 300);
        return new ElementsPage(driver);
    }

    public BrowserWindowPage selectBrowserWindows() {
        clickWithActionJava(browserWindowBtn, 0, 300);
        return new BrowserWindowPage(driver);
    }

    public AlertsPage selectAlerts() {
        clickWithActionJava(alertsBtn, 0, 300);
        return new AlertsPage(driver);
    }

    public PracticeFormPage selectPracticeForm() {
        clickWithActionJava(practiceFormBtn, 0, 300);
        return new PracticeFormPage(driver);
    }

    public SelectMenuPage selectSelectMenu() {
        hideFooter();
        selectMenuBtn.click();
        //clickWithActionJava(selectMenuBtn,0,500);
        return new SelectMenuPage(driver);
    }
}
