package com.demoqa.helpers;

import com.demoqa.pages.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JsExecutor extends PageBase {

    JavascriptExecutor js;

    public JsExecutor(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "submit")
    WebElement submitBtn;

    public JsExecutor typeNameEmailWithExecutor(String name, String email) {
        if (name != null && email != null) {
            js.executeScript("document.getElementById('userName').value='" + name + "';"); //заполняет поле в формате js
            js.executeScript("document.getElementById('userName').style.border='1px solid red';");
            js.executeScript("document.getElementById('userEmail').value='" + email + "';");
            System.out.println(userName.getText() + "By text");
            System.out.println(userName.getAttribute("value ") + "By value");
        }
        return this;
    }

    public JsExecutor clickOnSubmitJsE() {
        js.executeScript("document.querySelector('#submit').style.backgroundColor='Red';");
        js.executeScript("document.querySelector('footer').style.display='none';");
        js.executeScript("document.getElementById('submit').click();");
        return this;
    }

    public JsExecutor refreshBrowserJsE() {
        js.executeScript("history.go(0)");
        return this;
    }

    public JsExecutor checkBoxJsE() {
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=true;");
        return this;
    }

    public JsExecutor alertWithJs() {
        js.executeScript("alert('hello world!');");
        return this;
    }

    public JsExecutor scrollWithJse() {
        js.executeScript("window.scrollBy(0,100)");
        return this;
    }

    public JsExecutor getTitlePageJsE() {
        String text = js.executeScript("return document.title;").toString();
        System.out.println("*********************" + "\n" + text);
        return this;
    }

    public JsExecutor getUrlPageJsE() {
        String text = js.executeScript("return document.URL;").toString();
        System.out.println("*********************" + "\n" + "URL--> " + text);
        return this;
    }
}
