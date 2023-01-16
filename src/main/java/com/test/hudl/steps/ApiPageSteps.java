package com.test.hudl.steps;

import com.test.hudl.pages.ApiPage;
import io.cucumber.java.en.*;

public class ApiPageSteps {
    ApiPage apiPage = new ApiPage();

    @When("User submit login API request with {string} and {string}")
    public void loginAPI(String userName, String password) {
        apiPage.apiLogin(userName, password);
    }

    @When("User submit reset password API request with {string}")
    public void resetPwdAPI(String userName) {
        apiPage.resetPwdAPI(userName);
    }
}