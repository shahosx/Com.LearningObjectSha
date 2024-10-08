package com.LO.TestBase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
    
    public WebDriver driver;
    String url = "https://demoqa.com/registration";
    String browser = "chrome"; // You can make this configurable

    public void init () {
        selectBrowser(browser);
        getUrl(url);
    }

    public void selectBrowser (String browser){
        if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe"); // Ensure this path is correct
            driver = new InternetExplorerDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/LO/Test/chromedriver.exe"); // Ensure this path is correct
            driver = new ChromeDriver();
        }	 
        else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe"); // Ensure this path is correct
            driver = new FirefoxDriver();
        }
        else {
            throw new IllegalArgumentException("Browser \"" + browser + "\" not recognized.");
        }
    }

    public void getUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void closingBrowser() {
        if (driver != null) {
            driver.quit(); // It's better to use quit() to close all browser windows and safely end the session
        }
    }
}
