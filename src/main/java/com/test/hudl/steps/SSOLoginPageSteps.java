package com.test.hudl.steps;

import com.test.hudl.pages.SSOLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SSOLoginPageSteps {
    SSOLoginPage ssoLoginPage = new SSOLoginPage();

    @When("User click on login with invalid Organization email")
    public void userLogsInWithInvalidOrgEmail() {
        ssoLoginPage.ssoLogin();
    }

    @Then("User should be navigated to Organization login page")
    public void orgLoginPage() {
        ssoLoginPage.orgLoginPage();
    }
}
