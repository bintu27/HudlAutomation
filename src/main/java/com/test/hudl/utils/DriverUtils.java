package com.test.hudl.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.test.hudl.utils.ConfigUtils.*;


public class DriverUtils {
    static WebDriver driver;

    public static void initDriver() {
        loadProperties();
        String deviceType;
        String browserName;

        if ((System.getProperty("browserName") != null)) {
            browserName = System.getProperty("browserName");
        } else {
            browserName = getPropertyByKey("browserName");
        }

        if ((System.getProperty("deviceType") != null)) {
            deviceType = System.getProperty("deviceType");
        } else {
            deviceType = getPropertyByKey("deviceType");
        }

        switch (browserName) {
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "Edge":
                System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver");
                driver = new EdgeDriver();
                break;
            case "Safari":
                driver = new SafariDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");

//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("headless");
//                driver = new ChromeDriver(options);

                driver = new ChromeDriver();
                break;
        }
        switch (deviceType) {
            case "Mobile":
                driver.manage().window().setSize(new Dimension(375, 667));
                break;
            case "Tablet":
                driver.manage().window().setSize(new Dimension(768, 1024));
                break;
            default:
                driver.manage().window().maximize();
                break;
        }
        driver.get(getPropertyByKey("loginPage.URL"));
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void tearDown() {
        driver.quit();
        driver = null;
    }
}
