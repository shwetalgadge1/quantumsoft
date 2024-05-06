package com.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
    	  WebDriverManager.chromedriver().setup();
       
        driver = new ChromeDriver();
        
        driver.get("https://www.facebook.com/");
    }

    @Test(priority =1)
    public void loginTest() {
      
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("shwetal@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.sendKeys("shwetal");

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

       
    }

    @Test(priority = 2)
    
    public void createNewAccountTest() {
       
        WebElement createAccountLink = driver.findElement(By.linkText("Create New Account"));
        createAccountLink.click();

       
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        lastNameInput.sendKeys("Merry");

        WebElement emailInput = driver.findElement(By.name("reg_email__"));
        emailInput.sendKeys("johnmerry@example.com");

        WebElement confirmEmailInput = driver.findElement(By.name("reg_email_confirmation__"));
        confirmEmailInput.sendKeys("johnmerry@example.com");

        WebElement passwordInput = driver.findElement(By.name("reg_passwd__"));
        passwordInput.sendKeys("password123");

        WebElement birthDaySelect = driver.findElement(By.name("birthday_day"));
        birthDaySelect.sendKeys("1");

        WebElement birthMonthSelect = driver.findElement(By.name("birthday_month"));
        birthMonthSelect.sendKeys("Jan");

        WebElement birthYearSelect = driver.findElement(By.name("birthday_year"));
        birthYearSelect.sendKeys("1990");

        WebElement genderRadioButton = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
        genderRadioButton.click();

        
        WebElement signUpButton = driver.findElement(By.name("websubmit"));
        signUpButton.click();

       
    }

    @AfterClass
    public void tearDown() {
       
        if (driver != null) {
            driver.quit();
        }
    }
}
