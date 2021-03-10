package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div/div/div/div/div/div[6]")
    //(xpath = "//div[@class='category-cards']/div[.='Book Store Application']")
    WebElement bookStoreBtn;

    @FindBy(xpath = "//body/div/div/div/div/div/div[1]")
    WebElement elementBtn;

    public ProfilePage goToBookStore() {
        bookStoreBtn.click();
        return new ProfilePage(driver);
    }

    public ElementsPage goToElementsPage() {
        elementBtn.click();
        return new ElementsPage(driver);
    }
}
