package com.kaushik.drivermanager;

import com.kaushik.config.FrameWorkConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private WebDriver driver;
    private static DriverManager instance;
    private static Logger logger = LogManager.getLogger(FrameWorkConfig.class);

    private DriverManager(){
        init();
    }

    private void init(){
        if(FrameWorkConfig.getProperty("browser")==null)
        {
            logger.warn("Property browser is not set, defaulting it to CHROME");
            System.setProperty("webdriver.chrome.driver",FrameWorkConfig.getProperty("chrome.executables"));
            driver = new ChromeDriver();
        }
        else {
            logger.info("Initializing driver for browser type {}",FrameWorkConfig.getProperty("browser"));
            if(FrameWorkConfig.getProperty("browser").equals(BrowserType.CHROME.toString()))
            {
                System.setProperty("webdriver.chrome.driver",FrameWorkConfig.getProperty("chrome.executables"));
                driver = new ChromeDriver();
            }
            else if(FrameWorkConfig.getProperty("browser").equals(BrowserType.FIREFOX.toString()))
            {
                System.setProperty("webdriver.gecko.driver",FrameWorkConfig.getProperty("firefox.executables"));
                driver = new FirefoxDriver();
            }
            else
            {
                logger.warn("Browser {} does not match with configuration, defaulting it to CHROME",FrameWorkConfig.getProperty("browser"));
                System.setProperty("webdriver.chrome.driver",FrameWorkConfig.getProperty("chrome.executables"));
                driver = new ChromeDriver();
            }
        }
    }

    public static WebDriver getDriver(){
        if(instance == null)
        {
            instance = new DriverManager();
        }
        return instance.driver;
    }
}
