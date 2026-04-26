package com.finalproject.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final SelenideElement emailInput = $("input[name='email']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement submitPasswordInput = $("input[name='submitPassword']");
    private final SelenideElement submitRegistrationButton = $("button[type='submit']").shouldHave(text("Создать аккаунт"));
    private final SelenideElement loginButton = $("button[type='button']").shouldHave(text("Уже есть аккаунт"));
//    private final SelenideElement errorMessage = $("[data-testid='error-message']");
//    private final SelenideElement successMessage = $("[data-testid='success-message']");

    public void fillRegistrationForm(String email, String password, String name) {
        emailInput.shouldBe(visible).setValue(email);
        passwordInput.shouldBe(visible).setValue(password);
        submitPasswordInput.shouldBe(visible).setValue(password);
    }

    public void submitRegistration() {
        submitRegistrationButton.shouldBe(visible).click();
    }

    public void clickLoginButton() {
        loginButton.shouldBe(visible).click();
    }

//    public String getErrorMessage() {
//        return errorMessage.getText();
//    }
//
//    public String getSuccessMessage() {
//        return successMessage.getText();
//    }


}
