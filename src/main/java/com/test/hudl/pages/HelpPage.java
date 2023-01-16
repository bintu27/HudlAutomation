package com.test.hudl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.test.hudl.utils.CommonUtils.*;
import static com.test.hudl.pages.CommonPage.*;
import static com.test.hudl.utils.DriverUtils.getDriver;
import static com.test.hudl.utils.AssertionUtils.assertEquals;
import static com.test.hudl.utils.ConfigUtils.getPropertyByKey;
import static com.test.hudl.utils.WebElementUtils.waitForNotVisible;


public class HelpPage {
    public HelpPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "[data-qa-id ='login-help-headline']")
    private static WebElement loginHelpTitle;
    @FindBy(css = "[data-qa-id ='password-reset-input']")
    private WebElement pwdResetEmailField;
    @FindBy(css = "[data-qa-id ='password-reset-submit-btn']")
    private WebElement sendPwdResetBtn;
    @FindBy(css = "[data-qa-id ='password-reset-error-display']")
    private WebElement errorMsg;

    public void loginHelpPage() {
        verifyPageUrl("helpPage.URL");
        assertEquals(loginHelpTitle, getPropertyByKey("loginHelpPage.title"));
    }

    public void clickOnSendPasswordResetBtn() {
        clickOnElement(sendPwdResetBtn);
        waitForNotVisible(sendPwdResetBtn);
    }

    public void enterEmailToResetPwd(String emailInput) {
        sendKeysTo(pwdResetEmailField, getPropertyByKey(emailInput));
    }

    public void errorMessageOnHelpPage() {
        assertEquals(errorMsg, getPropertyByKey("resetPwd.errorMsg"));
    }
}
