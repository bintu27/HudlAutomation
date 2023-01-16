package com.test.hudl.steps;

import com.test.hudl.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
    LoginPage loginpage = new LoginPage();

    @When("User logs in with {string} and {string}")
    public void userLoginWithNameAndPassword(String userName, String password) {
        loginpage.login(userName, password);
    }
    @When("User logs in using valid login credentials")
    public void userLogsIn() {
        loginpage.login();
    }

    @When("User click logs in button with no credentials entered")
    public void userLogsInWithNoCredentials() {
        loginpage.clickOnLoginButton();
    }

    @When("User click on Need Help Link")
    public void clickOnNeedHelp() {
        loginpage.clickOnNeedHelp();
    }

    @When("User click on Log In with an Organization button")
    public void userClickOnLogInWithOrg() {
        loginpage.clickOnLogInWithOrg();
    }

    @When("User click on Remember me checkbox")
    public void clickOnRememberMe() {
        loginpage.clickOnRememberMe();
    }

    @Then("User should get {string} login error message on login page")
    public void invalidLoginErrorMessage(String errorMsg) {
        loginpage.invalidLoginMsg(errorMsg);
    }

    @Then("User should be navigated back to base page")
    public void backToLoginPage() {
        loginpage.backToLoginPage();
    }
}
