package com.herokuapp.theinternet.alertstest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class AlertTests extends TestUtilities {

    @Test
    public void jsAlertTest() {
        log.info("Starting jsAlertTest");
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
        alertsPage.openJSAlert();
        String alertMessage = alertsPage.getAlertText();
        alertsPage.acceptAlert();
        String result = alertsPage.getResultText();
        Assert.assertEquals(alertMessage, "I am a JS Alert", "Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");
        Assert.assertEquals(result, "You successfully clicked an alert", "result is not expected. \nShould be 'You successfuly clicked an alert', but it is '" + result + "'");
    }

    @Test
    public void jsDismissTest() {
        log.info("Starting jsDismissTest");
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
        alertsPage.openJSConfirm();
        String alertMessage = alertsPage.getAlertText();
        alertsPage.dismissAlert();
        String result = alertsPage.getResultText();
        Assert.assertEquals(alertMessage, "I am a JS Confirm", "Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");
        Assert.assertEquals(result, "You clicked: Cancel", "result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
    }

    @Test
    public void jsConfirmTest() {
        log.info("Starting jsConfirmTest");
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
        alertsPage.openJSConfirm();
        String alertMessage = alertsPage.getAlertText();
        alertsPage.acceptAlert();
        String result = alertsPage.getResultText();
        Assert.assertEquals(alertMessage, "I am a JS Confirm", "Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");
        Assert.assertEquals(result, "You clicked: Ok", "result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
    }

    @Test
    public void jsPromptTest() {
        log.info("Starting jsDismissTest");
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
        alertsPage.openJSPrompt();
        String alertMessage = alertsPage.getAlertText();
        alertsPage.typeTextIntoAlert("Hello Alert, it's Dmitry here");
        String result = alertsPage.getResultText();
        Assert.assertEquals(alertMessage, "I am a JS prompt", "Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");
        Assert.assertEquals(result, "You entered: Hello Alert, it's Dmitry here", "result is not expected. \nShould be 'You entered: Hello Alert, its Dmitry here', but it is '" + result);
    }
}