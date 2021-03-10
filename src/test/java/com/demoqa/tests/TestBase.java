package com.demoqa.tests;

import com.demoqa.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method m, Object[] p) {
        logger.info("Start test " + m.getName());
        if (p.length != 0) {
            logger.info("--> with data: " + Arrays.asList(p));
        }
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("Test result: Passed");
        } else {
            logger.error("Test result: Failed");
            String screen = "screenshots/screen-" + (System.currentTimeMillis() / 1000 % 3600) + ".png";
            new PageBase(driver).takeScreenshot(screen);
        }
        logger.info("Stop test: " + result.getMethod().getMethodName());
        logger.info("==============================================");
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
