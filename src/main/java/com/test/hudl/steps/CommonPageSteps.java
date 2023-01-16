package com.test.hudl.steps;

import com.test.hudl.pages.CommonPage;
import io.cucumber.java.en.Then;

public class CommonPageSteps {

    CommonPage commonPage = new CommonPage();

    /**************************************************************************************************
    Generic function to verify application's page URL
    **************************************************************************************************/

    @Then("User should be on the {string} Page")
    public void verifyPageUrl(String pageName) {
        commonPage.verifyPageUrl(pageName);
    }

}
