package com.finalproject.pages;

import com.codeborne.selenide.SelenideElement;
import com.finalproject.utils.ConfigReader;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    private final String baseUrl = ConfigReader.getProperty("app.base.url");
    private final SelenideElement loginAndRegisterButton = $(byText("Вход и регистрация"));
    private final SelenideElement placeAnAdButton = $(byText("Разместить объявление"));
    private final SelenideElement listOfAds = $(".grid_threeColumns__ldn5D");

    public void clickLoginAndRegisterButton() {
        loginAndRegisterButton.shouldBe(visible).click();
    }

    public void clickPlaceAnAdButton() {
        placeAnAdButton.shouldBe(visible).click();
    }

    public void listOfAdsShouldBeVisible() {
        listOfAds.shouldBe(visible);
    }

    public void openHomePage() {
        open(baseUrl);
    }

    public void navigateToLoginPage() {
        open(baseUrl + "/login");
    }

    public void navigateToRegistrationPage() {
        open(baseUrl + "/registration");
    }
}
