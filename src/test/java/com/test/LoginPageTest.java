package com.test;
import java.util.Scanner;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LoginPageTest{

	
	    public static void main(String[] args) {
	       
	        WebDriverManager.chromedriver().setup();

	        
	        
	        WebDriver driver = new ChromeDriver();
	        
	        
	        driver.get("https://www.facebook.com/");
	        
	        
	        WebElement usernameField = driver.findElement(By.id("email"));
	        WebElement passwordField = driver.findElement(By.id("pass"));
	        usernameField.sendKeys("shwetal");
	        passwordField.sendKeys("123456@");
	        WebElement clickable = driver.findElement(By.id("clickable"));
	        clickable.click();
	        
	        WebElement loginButton = driver.findElement(By.id("loginbutton"));
	        loginButton.click();
	        
	      
	        
	       
	        driver.quit();
	    }
	}





	