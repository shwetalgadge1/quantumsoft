package com.Utils;


	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	import org.apache.commons.io.FileUtils;

	import java.io.File;
	import java.io.IOException;

	public class Screenshot {

	    public static void main(String[] args) {
	       
	    	 WebDriverManager.chromedriver().setup();

	       
	        WebDriver driver = new ChromeDriver();

	      
	        driver.get("https://www.facebook.com/");

	       
	        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	       
	        String screenshotPath = ("C:\\Users\\PC\\git\\repository2\\qs_01\\src\\test\\resources\\testdata\\screenshot");

	        
	        try {
	            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
	            System.out.println("Screenshot saved successfully at: " + screenshotPath);
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot: " + e.getMessage());
	        }

	       
	        driver.quit();
	    }
	}



