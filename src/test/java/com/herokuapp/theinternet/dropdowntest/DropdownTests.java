package com.herokuapp.theinternet.dropdowntest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.annotations.Test;

public class DropdownTests extends TestUtilities {

    @Test
    public void optionTwoTest() {
        log.info("Starting optionTwoTest");
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();
        dropdownPage.selectOption(2);
    }
}
