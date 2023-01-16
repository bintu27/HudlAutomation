package com.test.hudl.steps;

import com.test.hudl.pages.CheckEmailPage;
import io.cucumber.java.en.Then;

public class CheckEmailPageSteps {
    CheckEmailPage checkemailpage = new CheckEmailPage();

    @Then("User should be navigated to check email page")
    public void checkEmailPage() {

        checkemailpage.onCheckEmailPage();
    }
}
