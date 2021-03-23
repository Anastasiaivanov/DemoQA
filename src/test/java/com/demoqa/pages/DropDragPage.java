package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DropDragPage extends PageBase {

    public DropDragPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DropDragPage actionDragMe() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe, dropHere).perform();
        String textTo = dropHere.getText();
        if (textTo.equals("Dropped!")) {
            System.out.println("Pass: source is dropped to target");
        } else {
            System.out.println("Fail: source couldn't be dropped");
        }
        return this;
    }

    public DropDragPage dragAndDropBy() {
        Actions actions = new Actions(driver);
        int xOffSet1 = dragMe.getLocation().getX();
        int yOffSet1 = dragMe.getLocation().getY();
        System.out.println("xOffSet1--> " + xOffSet1 + "yOffSet1--> " + yOffSet1);
        int xOffSet = dropHere.getLocation().getX();
        int yOffSet = dropHere.getLocation().getY();
        System.out.println("xOffSet--> " + xOffSet + "yOffSet--> " + yOffSet);
        xOffSet = (xOffSet-xOffSet1)+50;
        yOffSet = (yOffSet-yOffSet1)+100;
        pause(1000);
        actions.dragAndDropBy(dragMe,xOffSet,yOffSet).perform();
        String textTo = dropHere.getText();
        if (textTo.equals("Dropped!")) {
            System.out.println("Pass: source is dropped to target");
        } else {
            System.out.println("Fail: source couldn't be dropped");
        }
        return this;
    }

    public DropDragPage dragAndDropBy100(){
        Actions actions = new Actions(driver);
        pause(1000);
        actions.dragAndDropBy(dragMe,100,200).perform();
        return this;
    }
}
