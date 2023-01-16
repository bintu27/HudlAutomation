package com.test.hudl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.test.hudl.pages.CommonPage.*;
import static com.test.hudl.utils.AssertionUtils.assertEquals;
import static com.test.hudl.utils.ConfigUtils.getPropertyByKey;
import static com.test.hudl.utils.DriverUtils.getDriver;

public class CheckEmailPage {
    public CheckEmailPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(className = "uni-headline")
    private WebElement checkMailMsg;

    public void onCheckEmailPage() {
        verifyPageUrl("checkEmail.URL");
        assertEquals(checkMailMsg, getPropertyByKey("checkEmailPage.title"));
    }
}