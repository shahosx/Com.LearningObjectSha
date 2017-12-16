package com.LO.TestBase;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	public WebDriver driver;
	String url = "http://demoqa.com/registration";
	String browser = "firefox";
	
	public void init () {
	selectBrowser(browser);
	getUrl(url);
	}
	
	public void selectBrowser (String browser){
		
		
		 if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.IE.driver", "C:\\InternetExploreDriver.exe");
				 driver = new InternetExplorerDriver();
		 			}
		 else if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
					driver = new ChromeDriver();
		 			}	 
			else if (browser.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
					
		}
		 }

	
	public void getUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	public void ClosingBrowser() {
			driver.close();
		
	
}}