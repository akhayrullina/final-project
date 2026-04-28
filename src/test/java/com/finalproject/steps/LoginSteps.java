package com.finalproject.steps;

import com.finalproject.pages.HomePage;
import com.finalproject.pages.LoginPage;
import com.finalproject.utils.ApiHelper;
import com.finalproject.utils.TestDataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    private HomePage homePage;
    private String testEmail;
    private String testPassword;

    @Given("registered user navigates to login page")
    public void navigateToLogin() {
        testEmail = TestDataGenerator.generateUniqueEmail();
        testPassword = TestDataGenerator.generatePassword();

        ApiHelper.registerUser(testEmail, testPassword);

        homePage = new HomePage();
        homePage.openHomePage();
        homePage.clickLoginAndRegisterButton();
    }

    @When("user enters valid credentials")
    public void enterValidCredentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(testEmail, testPassword);
    }

    @Then("user should be logged in successfully")
    public void verifySuccessfulLogin() {
        homePage.listOfAdsShouldBeVisible();
    }

}
