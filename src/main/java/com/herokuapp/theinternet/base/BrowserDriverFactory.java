package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final String browser;
    private final Logger log;

    public BrowserDriverFactory(String browser, Logger log) {
        this.browser = browser.toLowerCase();
        this.log = log;
    }

    public WebDriver createDriver() {
        // Create driver
        log.info("Create driver: {}", browser);
        switch (browser) {
            case "chrome":
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            default:
                log.warn("Do not know how to start: {}, starting chrome.", browser);
                driver.set(new ChromeDriver());
                break;
        }
        return driver.get();
    }

    public void cleanUpDriver() {
        driver.remove();
    }
}
