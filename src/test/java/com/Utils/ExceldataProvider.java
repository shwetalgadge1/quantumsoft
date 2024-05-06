package com.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExceldataProvider {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
    	  WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        FileInputStream fis = new FileInputStream(new File("C://Users//PC//git//repository2//qs_01//src//test//resources//testdata//testdata.xlsx"));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                data[i-1][j] = cell.getStringCellValue();
            }
        }
        return data;
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
