package com.automation.StepDefinition;

import com.automation.main.BasePage;
import com.automation.pageObject.HomePage;
import com.automation.pageObject.RegistrationOrLoginPage;
import com.automation.testCases.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyStepdefs_LoginTest extends BaseTest {


    @Given("Open application")
    public void open_application() {
      initialization();
    }

    @And("click on My Account button")
    public void clickOnMyAccountButton() {

        page.getInstance(HomePage.class).clickMyAccount();

    }

    @Then("Enter {string} and {string}")
    public void enterAnd(String email, String password) {
        page.getInstance(RegistrationOrLoginPage.class).doLogin_PositiveTest(email,password);

    }


    @Then("Close the broswer")
    public void close_the_broswer() {
       tearDown();
    }

}
