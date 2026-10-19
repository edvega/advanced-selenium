package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    Logger log;
    String testName;
    String testMethodName;

    @Override
    public void onTestStart(ITestResult result) {
        this.testMethodName = result.getMethod().getMethodName();
        log.info("[Starting {}]", testMethodName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("[Test {} passed]", testMethodName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("[Test {} failed]", testMethodName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        this.testName = context.getCurrentXmlTest().getName();
        this.log = LogManager.getLogger(testName);
        log.info("[TEST {} STARTED]", testName);
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("[ALL {} FINISHED]", testName);
    }
}
