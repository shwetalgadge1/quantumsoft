package com.Utils;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Listener.TestListener.class)
public class Listener {

    private static WebDriver driver;

    @BeforeClass
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
       
        driver = new ChromeDriver();
       
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void loginTest() {
        // Find the elements and perform actions
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("shwetal@gmail.com\r\n"+ "");

        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.sendKeys("shwetal");

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();
        
       
    }

    @AfterClass
    public void tearDown() {
       
        if (driver != null) {
            driver.quit();
        }
    }

    public static class TestListener implements ITestListener {
        @Override
        public void onTestStart(ITestResult result) {
            System.out.println("Test Started: " + result.getName());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println("Test Passed: " + result.getName());
        }

        @Override
        public void onTestFailure(ITestResult result) {
            System.out.println("Test Failed: " + result.getName());
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            System.out.println("Test Skipped: " + result.getName());
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            // 
        }

        @Override
        public void onStart(ITestContext context) {
           
        }

        @Override
        public void onFinish(ITestContext context) {
        	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

 	       
	        String screenshotPath = ("C:\\Users\\PC\\git\\repository2\\qs_01\\src\\test\\resources\\testdata");
	        
	        try {
	            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
	            System.out.println("Screenshot saved successfully at: " + screenshotPath);
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot: " + e.getMessage());
	        }

          
        }
    }
}
