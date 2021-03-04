package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div/div/div/div/div/div[6]")
    WebElement bookStoreBtn;

    public BookStorePage goToBookStorePage() {
        bookStoreBtn.click();
        return new BookStorePage(driver);
    }
}
