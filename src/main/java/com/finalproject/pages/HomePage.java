package com.finalproject.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    private final SelenideElement loginAndRegisterButton = $(byText("Вход и регистрация"));
    private final SelenideElement placeAnAdButton = $(byText("Разместить объявление"));

    public void clickLoginAndRegisterButton() {
        loginAndRegisterButton.shouldBe(visible).click();
    }

    public void clickPlaceAnAdButton() {
        placeAnAdButton.shouldBe(visible).click();
    }

    public void navigateToLoginPage() {
        open("/login");
    }

    public void navigateToRegistrationPage() {
        open("/registration");
    }
}
