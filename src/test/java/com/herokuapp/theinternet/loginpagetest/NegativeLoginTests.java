package com.herokuapp.theinternet.loginpagetest;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLoginTests extends TestUtilities {

    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void negativeLoginTest(Map<String, String> testData) {
        String no = testData.get("no");
        String username = testData.get("username");
        String password = testData.get("password");
        String expectedErrorMessage = testData.get("expectedMessage");
        String description = testData.get("description");
        log.info("Starting negativeLoginTest #{} for {}", no, description);
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        loginPage.negativelogIn(username, password);
        loginPage.waitForErrorMessage();
        Assert.assertTrue(loginPage.getErrorMessageText().contains(expectedErrorMessage));
    }
}