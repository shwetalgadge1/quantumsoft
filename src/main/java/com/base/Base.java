
	package com.base;

	import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

			public class Base {
			public static void main(String[] args) {
			      
		
			        WebDriver driver = new ChromeDriver();
			        WebDriverManager.chromedriver().setup();
			        
			        driver.get("https://www.facebook.com/");
			        try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			        driver.quit();
			    }
		}
		
		
		
		
		
		
		
	
	


