package com.finalproject.steps;

import com.finalproject.pages.AdPage;
import com.finalproject.pages.HomePage;
import com.finalproject.pages.LoginPage;
import com.finalproject.utils.ApiHelper;
import com.finalproject.utils.TestDataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.codeborne.selenide.Selenide.sleep;

public class AdSteps {
    private HomePage homePage;
    private AdPage adPage;
    private String title;
    private String description;
    private String price;
    private String category;
    private String city;
    private String testEmail;
    private String testPassword;

    @Given("authorized user navigates to create ad page")
    public void navigateToCreateAd() {
        homePage = new HomePage();
        adPage = new AdPage();
        LoginPage loginPage = new LoginPage();

        testEmail = TestDataGenerator.generateUniqueEmail();
        testPassword = TestDataGenerator.generatePassword();

        ApiHelper.registerUser(testEmail, testPassword);
        homePage.openHomePage();
        homePage.clickLoginAndRegisterButton();
        loginPage.login(testEmail, testPassword);

        homePage.clickPlaceAnAdButton();
        adPage.getTitleNewAd().shouldBe(visible);
    }

    @When("user fills ad creation form with valid data")
    public void fillAdForm() {
        title = TestDataGenerator.generateAdTitle();
        description = TestDataGenerator.generateAdDescription();
        price = TestDataGenerator.generateAdPrice();
        category = TestDataGenerator.generateAdCategory();
        city = TestDataGenerator.generateAdCity();

        // Вывод в консоль для отладки
        System.out.println("Generated ad data:");
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        System.out.println("Category: " + category);
        System.out.println("City: " + city);

        adPage.createAd(title, description, price, category, city);
    }

    @Then("ad should be created successfully")
    public void verifyAdCreated() {
        homePage = new HomePage();
        assertEquals(title, homePage.searchingAd());
    }

    @When("user edits the created ad")
    public void editAd() {
        homePage.toPersonalAccount();
        String newTitle = "Updated Title";
        String newDescription = TestDataGenerator.generateAdDescription();
        String newPrice = TestDataGenerator.generateAdPrice();
        adPage.editAd(newTitle, newDescription, newPrice);
        adPage.getAdCard().shouldBe(visible);
        title = newTitle;
    }

    @Then("ad should be updated successfully")
    public void verifyAdUpdated() {
        System.out.println("NEW" + homePage.searchingAd());
        assertTrue(homePage.searchingAd().contains("Updated"));
    }

    @When("user deletes the ad")
    public void deleteAd() {
        adPage.deleteAd();
    }

    @Then("ad should be removed")
    public void verifyAdRemoved() {
        adPage.getAdCard().shouldNotBe(visible);
    }
}
