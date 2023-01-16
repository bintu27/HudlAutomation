package com.test.hudl.steps;

import com.test.hudl.pages.HomePage;
import io.cucumber.java.en.*;

public class HomePageSteps {
    HomePage homepage = new HomePage();

    @Given("User is on the login page of the application")
    public void userOnLoginPage() {
        homepage.userOnLoginPage();
    }
    @When("User click on the top right menu icon")
    public void clickOnMenuIcon() {
        homepage.clickOnMenuIcon();
    }
    @When("User click on Logout menu option")
    public void clickOnLogoutMenuOption() {
        homepage.clickOnLogoutMenuOption();
    }
    @Then("User should be navigated to home page")
    public void isUserOnHomepage() {
        homepage.isUserOnHomepage();
    }

}
