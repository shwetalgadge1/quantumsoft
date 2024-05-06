package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fbresgistrationpage {

    WebDriver driver;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='reg_email__']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@name='reg_email_confirmation__']")
    WebElement confirmEmailInput;

    @FindBy(xpath = "//input[@name='reg_passwd__']")
    WebElement passwordInput;

    @FindBy(xpath = "//select[@id='day']")
    WebElement daySelect;

    @FindBy(xpath = "//select[@id='month']")
    WebElement monthSelect;

    @FindBy(xpath = "//select[@id='year']")
    WebElement yearSelect;

    @FindBy(xpath = "//input[@name='sex' and @value='2']")
    WebElement genderMaleRadio;

    @FindBy(xpath = "//button[@name='websubmit']")
    WebElement signUpButton;

    public fbresgistrationpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registerNewAccount(String firstName, String lastName, String email, String password, String day, String month, String year) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        confirmEmailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        daySelect.sendKeys(day);
        monthSelect.sendKeys(month);
        yearSelect.sendKeys(year);
        genderMaleRadio.click();
        signUpButton.click();
    }

    public static void main(String[] args) {
    	  WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        fbresgistrationpage registrationPage = new fbresgistrationpage(driver);

      
        registrationPage.registerNewAccount("John", "Doe", "johndoe@example.com", "password123", "1", "January", "1990");

        
        driver.quit();
    }
}
