package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePage {

    private static final String PAGE_URL = "http://the-internet.herokuapp.com/key_presses";
    private final By bodyLocator = By.xpath("//body");
    private final By resultTextLocator = By.id("result");

    public KeyPressesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open KeyPressesPage with it's url */
    public void openPage() {
        log.info("Opening page: {}", PAGE_URL);
        openUrl(PAGE_URL);
        log.info("Page opened!");
    }

    /** Press given key while on this page */
    public void pressKey(Keys key) {
        log.info("Pressing {}", key.name());
        pressKey(bodyLocator, key);
    }

    /** Get result text */
    public String getResultText() {
        String result = find(resultTextLocator).getText();
        log.info("Result text: {}", result);
        return result;
    }
}
