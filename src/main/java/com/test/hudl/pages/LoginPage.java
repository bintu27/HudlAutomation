package com.test.hudl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.test.hudl.utils.AssertionUtils.*;
import static com.test.hudl.utils.CommonUtils.*;
import static com.test.hudl.utils.DriverUtils.getDriver;
import static com.test.hudl.utils.ConfigUtils.getPropertyByKey;
import static com.test.hudl.utils.WebElementUtils.waitForNotVisible;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement loginEmail;
    @FindBy(id = "password")
    private WebElement loginPassword;
    @FindBy(id = "logIn")
    private WebElement loginButton;
    @FindBy(css = "[data-qa-id='error-display']")
    private WebElement loginErrorMessage;
    @FindBy(css = "[data-qa-id ='login']")
    private WebElement loginMenuBtn;
    @FindBy(className = "uni-form__check-indicator")
    private WebElement rememberMeCheckBox;
    @FindBy(css = "[data-qa-id ='need-help-link']")
    private WebElement needHelpLink;
    @FindBy(css = "[data-qa-id='log-in-with-organization-btn']")
    private WebElement loginWithOrgButton;
    
    /*********************************************************************************************************
     Implemented method overloading for login functionality, different arguments passed according to scenario
     ********************************************************************************************************/
    
     public void login() {
        sendKeysTo(loginEmail, getPropertyByKey("validEmail"));
        sendKeysTo(loginPassword, getPropertyByKey("validPassword"));
        clickOnElement(loginButton);
        waitForNotVisible(loginButton);
    }

    public void login(String userName, String password) {
        sendKeysTo(loginEmail, getPropertyByKey(userName));
        sendKeysTo(loginPassword, getPropertyByKey(password));
        clickOnElement(loginButton);
    }

    public void invalidLoginMsg(String errorMsg) {
        if (errorMsg.equals("SSO"))
        {
            assertEquals(loginErrorMessage, getPropertyByKey("orgPage.errorMsg"));
        }
        else {
            assertEquals(loginErrorMessage, getPropertyByKey("loginPage.errorMsg"));
        }
    }
    public void clickOnLoginButton() {
         clickOnElement(loginButton);
    }
    public void clickOnRememberMe() {
         clickOnElement(rememberMeCheckBox);
    }
    public void backToLoginPage() {
         assertPresent(loginMenuBtn);
    }
    public void clickOnNeedHelp() {
         clickOnElement(needHelpLink);
    }
    public void clickOnLogInWithOrg() {
         clickOnElement(loginWithOrgButton);
    }
}
