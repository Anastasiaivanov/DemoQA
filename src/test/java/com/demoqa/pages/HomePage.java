package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div/div/div/div/div/div[6]")
    //(xpath = "//div[@class='category-cards']/div[.='Book Store Application']")
    WebElement bookStoreElement;

    @FindBy(xpath = "//body/div/div/div/div/div/div[1]")
    WebElement elementsElement;

    @FindBy(xpath = "//div[@class='category-cards']/div[2]")
    WebElement formsElement;

    @FindBy(xpath = "//div/h5[.='Alerts, Frame & Windows']")
    WebElement alertFrameWindowsElement;

    @FindBy(xpath = "//div/h5[.='Widgets']")
    WebElement widgetsElement;

    public SidePanelPage goToBookStore() {
        clickWithActionJava(bookStoreElement,0,300);
        return new SidePanelPage(driver);
    }

    public SidePanelPage goToElementsPage() {
        clickWithActionJava(elementsElement, 0,300);
        return new SidePanelPage(driver);
    }

    public SidePanelPage goToAlertPage() {
        clickWithActionJava(alertFrameWindowsElement, 0, 200);
        return new SidePanelPage(driver);
    }

    public SidePanelPage goToPracticeFormPage(){
        clickWithActionJava(formsElement, 0, 300);
        return new SidePanelPage(driver);
    }

    public SidePanelPage goToWindowWidgets(){
        hideFooter();
        widgetsElement.click();
        //clickWithActionJava(widgetsElement,0,300);
        return new SidePanelPage(driver);
    }
}
