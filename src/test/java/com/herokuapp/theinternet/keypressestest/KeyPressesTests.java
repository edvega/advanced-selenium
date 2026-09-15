package com.herokuapp.theinternet.keypressestest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;

public class KeyPressesTests extends TestUtilities {

    @Test
    public void pressKeyTest() {
        log.info("Starting pressKeyTest");
        KeyPressesPage keyPressesPage = new KeyPressesPage(driver, log);
        keyPressesPage.openPage();
        keyPressesPage.pressKey(Keys.ENTER);
        String result = keyPressesPage.getResultText();
        Assert.assertEquals(result, "You entered: ENTER", "result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
    }

    @Test
    public void pressKeyWithActionsTest() {
        log.info("Starting pressKeyWithActionsTest");
        KeyPressesPage keyPressesPage = new KeyPressesPage(driver, log);
        keyPressesPage.openPage();
        keyPressesPage.pressKeyWithActions(Keys.SPACE);
        String result = keyPressesPage.getResultText();
        Assert.assertEquals(result, "You entered: SPACE", "result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
    }
}
