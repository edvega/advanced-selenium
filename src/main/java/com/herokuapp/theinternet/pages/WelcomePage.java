package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

    private static final String PAGE_URL = "http://the-internet.herokuapp.com/";
    private final By formAuthenticatorLinkLocator = By.linkText("Form Authentication");
    private final By checkboxesLinkLocator = By.linkText("Checkboxes");
    private final By dropdownLinkLocator = By.linkText("Dropdown");

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

    /** Open CheckboxesPage by clicking on Checkboxes Link */
    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking Checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    /** Open DropdownPage by clicking on Dropdown Link */
    public DropdownPage clickDropdownLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }
}
