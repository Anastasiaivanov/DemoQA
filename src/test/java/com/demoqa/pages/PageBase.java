package com.demoqa.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public abstract class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void takeScreenshotField(WebElement element) throws IOException {
        element.isSelected();
        File screenshotField = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotField,
                new File(System.getProperty("user.dir") + "/screenshots/" + new Random().nextInt() + ".png"));
    }

    public void scrollDownPage(){
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
    }
}
