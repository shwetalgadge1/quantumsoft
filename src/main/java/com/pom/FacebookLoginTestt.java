package com.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class FacebookLoginTestt {
	public static void main(String[] args) {
       
        WebDriver driver = new ChromeDriver();
        
        WebDriverManager.chromedriver().setup();

       driver.get("https://www.facebook.com");

        FacebookLoginPage loginPage = new FacebookLoginPage(driver);
        
        loginPage.enterUsername("shwetal");
        
        loginPage.enterPassword("shwetal");


        loginPage.clickLogin();

        driver.quit();
    }
}


