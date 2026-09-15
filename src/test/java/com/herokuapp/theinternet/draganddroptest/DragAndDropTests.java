package com.herokuapp.theinternet.draganddroptest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;

public class DragAndDropTests extends TestUtilities {

    @Test
    public void dragAToBTest() {
        log.info("Starting dragAToBTest");
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver, log);
        dragAndDropPage.openPage();
        dragAndDropPage.dragAtoB();
        String columnAText = dragAndDropPage.getColumnAText();
        Assert.assertEquals(columnAText, "B", "Column A header should be B, but it is: " + columnAText);
        String columnBText = dragAndDropPage.getColumnBText();
        Assert.assertEquals(columnBText, "A", "Column A header should be B, but it is: " + columnBText);
    }
}
