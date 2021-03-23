package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class ToolTipsPage extends PageBase {

    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "toolTipTextField")
    WebElement hoverToMe;

    @FindBy(css = "#textFieldToolTip")
    WebElement toolTipContainer;

    public ToolTipsPage hoverInputToSee() {
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverToMe).perform();
        String toolTipText = toolTipContainer.getText();
        System.out.println("Tool tip text --> " + toolTipText);

        if(toolTipText.equalsIgnoreCase("You hovered over the text field")){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
        return this;
    }
}
