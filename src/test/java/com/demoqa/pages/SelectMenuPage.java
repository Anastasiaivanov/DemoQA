package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends PageBase{

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]")
    WebElement multiSelectDropDown;

    @FindBy(xpath = "//html")
    WebElement space;

    @FindBy(id = "react-select-4-input")
    WebElement dropDown;

    @FindBy(id = "cars")
    WebElement cars;

    public SelectMenuPage standardMultiSelect(){
        Select multi = new Select(cars);
        if(multi.isMultiple()){ //делает множественный выбор
            multi.selectByIndex(1);
            multi.selectByIndex(2);
            multi.selectByIndex(3);
        }
        List<WebElement> selectOpt = multi.getAllSelectedOptions();
        for (WebElement element:selectOpt) {
            System.out.println(element.getText()+"<----- Multi");
        }
        return this;
    }

    public SelectMenuPage clickMultiSelectDroDown(String text){
        hideFooter();
        dropDown.sendKeys(text);
        dropDown.sendKeys(Keys.ENTER);
        dropDown.sendKeys(Keys.ENTER);
        dropDown.sendKeys(Keys.ENTER);
        return this;
    }

    public SelectMenuPage clickOnOptions(String text){
        hideFooter();
        multiSelectDropDown.click();
        WebElement element  = driver.findElement(By.xpath(String.format("//div[text()='%s']",text))); //%s - любая строка, %d любое число
        element.click();
        space.click();
        return this;
    }

    public SelectMenuPage clickOnOldStyle(String text){
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(text);
        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText());
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
        return this;
    }
}
