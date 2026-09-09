package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.name("password");
    private final By loginButtonLocator = By.tagName("button");
    private final By errorMessageLocator = By.id("flash");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Execute login */
    public SecureAreaPage logIn(String username, String password) {
        log.info("Executing login with username [{}] and password [{}]", username, password);
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginButtonLocator);
        return new SecureAreaPage(driver, log);
    }

    /** Execute negative login */
    public void negativelogIn(String username, String password) {
        log.info("Executing negative login with username [{}] and password [{}]", username, password);
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginButtonLocator);
    }

    public void waitForErrorMessage() {
        waitForVisibilityOf(errorMessageLocator, Duration.ofSeconds(5));
    }

    public String getErrorMessageText() {
        return find(errorMessageLocator).getText();
    }
}
