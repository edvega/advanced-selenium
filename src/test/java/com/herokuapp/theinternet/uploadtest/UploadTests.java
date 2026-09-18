package com.herokuapp.theinternet.uploadtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;

public class UploadTests extends TestUtilities {

    @Test(dataProvider = "files")
    public void fileUploadTest(int number, String fileName) {
        log.info("Starting fileUploadTest #{} for {}", number, fileName);
        FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);
        fileUploaderPage.openPage();
        fileUploaderPage.selectFile(fileName);
        fileUploaderPage.pushUploadButton();
        String fileNames = fileUploaderPage.getUploadedFilesNames();
        Assert.assertTrue(fileNames.contains(fileName),
                "Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
    }
}
