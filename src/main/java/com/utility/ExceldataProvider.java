package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExceldataProvider {

    public static void main(String[] args) throws IOException {
        
      
        
       
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); 
        WebDriver driver = new ChromeDriver(options);

       
        driver.get("https://www.facebook.com");

       
        FileInputStream fis = new FileInputStream("C:\\Users\\PC\\git\\repository2\\qs_01\\src\\test\\resources\\testdata\\testdata.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell usernameCell = row.getCell(0);
        Cell passwordCell = row.getCell(1);
        String username = usernameCell.getStringCellValue();
        String password = passwordCell.getStringCellValue();

        
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.name("login"));

       
        emailField.sendKeys(username);
        passwordField.sendKeys(password);

     
        loginButton.click();

     
     

       
        if (driver.getCurrentUrl().contains("facebook.com")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

      
        driver.quit();
        workbook.close();
        fis.close();
    }

	
}
