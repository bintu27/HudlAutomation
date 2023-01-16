package com.test.hudl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.test.hudl.pages.CommonPage.*;
import static com.test.hudl.utils.CommonUtils.*;
import static com.test.hudl.utils.DriverUtils.getDriver;
import static com.test.hudl.utils.AssertionUtils.assertEquals;
import static com.test.hudl.utils.ConfigUtils.getPropertyByKey;

public class SSOLoginPage {
    public SSOLoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "uniId_1")
    private WebElement orgEmail;
    @FindBy(css = "[data-qa-id='log-in-with-sso']")
    private WebElement loginWithSsoBtn;
    @FindBy(className = "uni-headline")
    private WebElement orgLoginMsg;

    public void orgLoginPage() {
        verifyPageUrl("sso.URL");
        assertEquals(orgLoginMsg, getPropertyByKey("orgPage.msg"));
    }

    public void ssoLogin() {
        sendKeysTo(orgEmail, getPropertyByKey("validEmail"));
        clickOnElement(loginWithSsoBtn);
    }

}
