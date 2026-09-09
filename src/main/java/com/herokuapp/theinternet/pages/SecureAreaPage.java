package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    private static final String PAGE_URL = "http://the-internet.herokuapp.com/secure";
    private final By logOutButtonLocator = By.xpath("//a[@class='button secondary radius']");
    private final By messageLocator = By.id("flash-messages");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Get URL variable from PageObject */
    public String getPageUrl() {
        return PAGE_URL;
    }

    /** Verification if logOutButton is visible on the page */
    public boolean isLogOutButtonVisible() {
        return find(logOutButtonLocator).isDisplayed();
    }

    /** Return text from success message */
    public String getSuccessMessageText() {
        return find(messageLocator).getText();
    }
}
