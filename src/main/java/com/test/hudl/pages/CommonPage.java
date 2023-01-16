package com.test.hudl.pages;

import static com.test.hudl.utils.AssertionUtils.assertEquals;
import static com.test.hudl.utils.ConfigUtils.getPropertyByKey;
import static com.test.hudl.utils.DriverUtils.getDriver;

public class CommonPage {
    public static void verifyPageUrl(String pageName) {
        assertEquals(getDriver().getCurrentUrl(), getPropertyByKey(pageName));
    }
}