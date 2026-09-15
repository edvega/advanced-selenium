package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePage {

    private static final String PAGE_URL = "http://the-internet.herokuapp.com/upload";
    private final By choseFileFieldLocator = By.id("file-upload");
    private final By uploadButtonLocator = By.id("file-submit");
    private final By uploadedFilesLocator = By.id("uploaded-files");

    public FileUploaderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open FileUploaderPage with it's url */
    public void openPage() {
        log.info("Opening page: {}", PAGE_URL);
        openUrl(PAGE_URL);
        log.info("Page opened!");
    }

    /** Push Upload button */
    public void pushUploadButton() {
        log.info("Clicking on upload button");
        click(uploadButtonLocator);
    }

    /** Push Upload button */
    public void selectFile(String fileName) {
        log.info("Selecting '{}' file from Files folder", fileName);
        // Selecting file
        String filePath = System.getProperty("user.dir") + "/src/main/resources/files/" + fileName;
        log.info("File path: {}", filePath);
        type(filePath, choseFileFieldLocator);
        log.info("File selected");
    }

    /** Get names of uploaded files */
    public String getUploadedFilesNames() {
        String names = find(uploadedFilesLocator).getText();
        log.info("Uploaded files: {}", names);
        return names;
    }
}
