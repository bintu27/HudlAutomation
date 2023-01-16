package com.test.hudl.steps;

import com.test.hudl.pages.HelpPage;
import io.cucumber.java.en.*;

public class HelpPageSteps {
    HelpPage helpPage = new HelpPage();

    @Then("User should be navigated to login help page")
    public void loginHelpPage() {
        helpPage.loginHelpPage();
    }

    @When("User enter {string} to reset the password")
    public void enterEmailToRestPwd(String emailInput) {
        helpPage.enterEmailToResetPwd(emailInput);
    }
    @When("User click on \"Send Password Reset\" button")
    public void clickOnSendPasswordResetBtn() {
        helpPage.clickOnSendPasswordResetBtn();
    }

    @Then("User should get error message on help page")
    public void errorMessageOnHelpPage() {
        helpPage.errorMessageOnHelpPage();
    }
}
