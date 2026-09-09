package com.herokuapp.theinternet.loginpagetest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void logInTest() {
        log.info("Starting logIn test");
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(secureAreaPage.getPageUrl(), "http://the-internet.herokuapp.com/secure");
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible());
        Assert.assertTrue(secureAreaPage.getSuccessMessageText().contains("You logged into a secure area!"));
    }
}