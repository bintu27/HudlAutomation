package com.test.hudl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.test.hudl.utils.CommonUtils.*;
import static com.test.hudl.pages.CommonPage.*;
import static com.test.hudl.utils.AssertionUtils.assertPageTitle;
import static com.test.hudl.utils.ConfigUtils.getPropertyByKey;
import static com.test.hudl.utils.DriverUtils.getDriver;


public class HomePage {
    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(className = "no-localization-available")
    private WebElement yourAccountMenuIcon;
    @FindBy(linkText = "Log Out")
    private WebElement logoutMenuOption;
    public void userOnLoginPage() {
        assertPageTitle(getPropertyByKey("loginPage.title"));
    }
    public void clickOnMenuIcon() {
        clickOnElement(yourAccountMenuIcon);
    }
    public void clickOnLogoutMenuOption() {
        clickOnElement(logoutMenuOption);
    }
    public void isUserOnHomepage() {
        verifyPageUrl("homePage.URL");
    }
}