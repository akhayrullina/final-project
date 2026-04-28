package com.finalproject.steps;

import com.finalproject.pages.HomePage;
import com.finalproject.pages.LoginPage;
import com.finalproject.pages.RegistrationPage;
import com.finalproject.utils.ApiHelper;
import com.finalproject.utils.TestDataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class RegistrationSteps {
    private RegistrationPage registrationPage;
    private HomePage homePage;
    private String testEmail;
    private String testPassword;

    @Given("user navigates to registration page")
    public void navigateToRegistration() {
        homePage = new HomePage();
//        homePage.navigateToRegistrationPage();
        homePage.openHomePage();
        homePage.clickLoginAndRegisterButton();
        LoginPage loginPage = new LoginPage();
        loginPage.clickRegisterButton();
    }

    @When("user fills registration form with unique email")
    public void fillFormWithUniqueEmail() {
        testEmail = TestDataGenerator.generateUniqueEmail();
        testPassword = TestDataGenerator.generatePassword();

        registrationPage = new RegistrationPage();
        registrationPage.fillRegistrationForm(testEmail, testPassword);
    }

    @When("user submits registration form")
    public void submitRegistration() {
        registrationPage.submitRegistration();
    }

    @Then("user should see success registration message")
    public void verifySuccessMessage() {
        homePage.listOfAdsShouldBeVisible();
    }

    @Given("user is already registered via API")
    public void registerUserViaApi() {
        testEmail = TestDataGenerator.generateUniqueEmail();
        testPassword = TestDataGenerator.generatePassword();

        ApiHelper.registerUser(testEmail, testPassword);
    }

    @When("user fills registration form with the same email")
    public void fillFormWithExistingEmail() {
        registrationPage = new RegistrationPage();
        registrationPage.fillRegistrationForm(testEmail, testPassword);
    }

    @Then("user should see error message about existing email")
    public void verifyEmailError() {
        registrationPage.getErrorMessage();
    }
}