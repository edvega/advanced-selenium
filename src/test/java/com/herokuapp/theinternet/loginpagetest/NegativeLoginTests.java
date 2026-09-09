package com.herokuapp.theinternet.loginpagetest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({ "username", "password", "expectedMessage" })
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting negativeTest");
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        loginPage.negativelogIn(username, password);
        loginPage.waitForErrorMessage();
        Assert.assertTrue(loginPage.getErrorMessageText().contains(expectedErrorMessage));
    }
}