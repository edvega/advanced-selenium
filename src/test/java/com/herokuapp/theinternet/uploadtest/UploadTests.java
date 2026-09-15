package com.herokuapp.theinternet.uploadtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;

public class UploadTests extends TestUtilities {

    @Test
    public void imageUploadTest() {
        log.info("Starting imageUploadTest");
        FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);
        fileUploaderPage.openPage();
        String fileName = "text.txt";
        fileUploaderPage.selectFile(fileName);
        fileUploaderPage.pushUploadButton();
        String fileNames = fileUploaderPage.getUploadedFilesNames();
        Assert.assertTrue(fileNames.contains(fileName),
                "Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
    }
}
