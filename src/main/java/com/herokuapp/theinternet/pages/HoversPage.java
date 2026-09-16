package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoversPage extends BasePage {

    private static final String PAGE_URL = "http://the-internet.herokuapp.com/hovers";
    private final By avatarLocator = By.xpath("//div[@class='figure']");
    private final By viewProfileLinkLocator = By.xpath(".//a[contains(text(),'View profile')]");

    public HoversPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open HoversPage with it's url */
    public void openPage() {
        log.info("Opening page: {}", PAGE_URL);
        openUrl(PAGE_URL);
        log.info("Page opened!");
    }

    /** Open specified user profile */
    public void openUserProfile(int i) {
        List<WebElement> avatars = findAll(avatarLocator);
        WebElement specifiedUserAvatar = avatars.get(i - 1);
        hoverOverElement(specifiedUserAvatar);
        specifiedUserAvatar.findElement(viewProfileLinkLocator).click();
    }
}
