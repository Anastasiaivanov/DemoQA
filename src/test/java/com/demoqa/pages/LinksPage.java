package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class LinksPage extends PageBase {

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    @FindBy(tagName = "img")
    List<WebElement> images;

    public LinksPage checkBrokenImages() {
        System.out.println("We have " + images.size() + " images");
        for (int index = 0; index < images.size(); index++) {
            WebElement img = images.get(index);
            String imageURL = img.getAttribute("src");
            System.out.println("URL of image " + (index + 1) + " is: " + imageURL);
            verifyLinks(imageURL);
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);", img);
                if (imageDisplayed) {
                    System.out.println("Display - OK");
                    System.out.println("****************");
                } else {
                    System.out.println("Display - Broken");
                    System.out.println("****************");
                }
            } catch (Exception e) {
                System.out.println("Error occurred");
            }
        }
        return this;
    }

    public LinksPage checkAllURL() {
        String url = "";
        System.out.println("Total links on the WebPage " + allLinks.size());
        Iterator<WebElement> iterator = allLinks.iterator(); //перебирает элементы
        while (iterator.hasNext()) { //пока есть следующая, извлекай текст и иди дальше
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public LinksPage checkBrokenLinks() {
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpsURLConnection httpsURLConnect = (HttpsURLConnection) url.openConnection();
            httpsURLConnect.setConnectTimeout(5000);
            httpsURLConnect.connect();
            if (httpsURLConnect.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpsURLConnect.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(linkUrl + " - " + httpsURLConnect.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " is a broken link");
        }
    }
}
