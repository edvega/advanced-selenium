package com.herokuapp.theinternet.editortest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class EditorTests extends TestUtilities {

    @Test
    public void defaultEditorValueTest() {
        log.info("Starting defaultEditorValueTest");
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        EditorPage editorPage = welcomePage.clickWYSIWYGEditorLink();
        String editorText = editorPage.getEditorText();
        Assert.assertEquals(editorText, "Your content goes here.", "Editor default text is not expected. It is: " + editorText);
    }
}