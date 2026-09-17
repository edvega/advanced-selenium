package com.herokuapp.theinternet.horizontalslidertest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPage;

public class HorizontalSliderTests extends TestUtilities {

    @Test
    public void sliderTest() {
        log.info("Starting sliderTest");
        HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage(driver, log);
        horizontalSliderPage.openPage();
        String value = "3.5";
        horizontalSliderPage.setSliderTo(value);
        String sliderValue = horizontalSliderPage.getSliderValue();
        Assert.assertEquals(sliderValue, value, "Range is not correct. It is: " + sliderValue);
    }
}
