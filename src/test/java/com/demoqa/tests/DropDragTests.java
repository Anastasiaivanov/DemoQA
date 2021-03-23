package com.demoqa.tests;

import com.demoqa.pages.DropDragPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDragTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).goToInteractionsPage();
        new SidePanelPage(driver).selectDroppable();
    }

    @Test
    public void droppableSimpleTest(){
        new DropDragPage(driver).actionDragMe();
    }

    @Test
    public void dropAndDragByTest(){
        new DropDragPage(driver).dragAndDropBy();
    }

    @Test
    public void dropAnsDragBy100Test(){
        new DropDragPage(driver).dragAndDropBy100();
    }
}
