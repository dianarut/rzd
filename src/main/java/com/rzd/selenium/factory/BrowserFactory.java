package com.rzd.selenium.factory;

import com.rzd.selenium.util.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    private static volatile BrowserFactory instance;
    private WebDriver driver;

    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    private BrowserFactory(){
        driver = getBrowser();
    }

    public static BrowserFactory getInstance(){
        BrowserFactory localInstance = instance;
        if (localInstance == null) {
            synchronized (BrowserFactory.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new BrowserFactory();
                }
            }
        }
        return localInstance;
    }

    public static WebDriver getBrowser() {
        WebDriver driver = null;
        String browserName = ConfigurationManager.getProperty("driver.default");

        switch (browserName) {
            case "Firefox":
                driver = drivers.get("Firefox");
                if (driver == null) {
                    System.setProperty(ConfigurationManager.getProperty("driver.geckodriver"), ConfigurationManager.getProperty("driver.firefox.path"));
                    driver = new FirefoxDriver();
                    drivers.put("Firefox", driver);
                }
                break;
            case "Chrome":
                driver = drivers.get("Chrome");
                if (driver == null) {
                    System.setProperty(ConfigurationManager.getProperty("driver.chrome"), ConfigurationManager.getProperty("driver.chrome.path"));
                    driver = new ChromeDriver();
                    drivers.put("Chrome", driver);
                }
                break;
        }

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationManager.getProperty("driver.start"));

        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver(){
        this.driver.quit();
    }
}
