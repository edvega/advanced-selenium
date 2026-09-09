package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

    private static final String PAGE_URL = "http://the-internet.herokuapp.com/";
    private final By formAuthenticatorLinkLocator = By.linkText("Form Authentication");

    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open Welcome Page with its url */
    public void openPage() {
        log.info("Opening page: {}", PAGE_URL);
        openUrl(PAGE_URL);
        log.info("Page opened!");
    }

    /** Open LoginPage by clicking on Form Authentication Link */
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication link on Welcome Page");
        click(formAuthenticatorLinkLocator);
        return new LoginPage(driver, log);
    }
}
