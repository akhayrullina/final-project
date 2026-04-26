package com.finalproject.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement emailInput = $("input[name='email']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement submitButton = $x("//form[@class='popUp_shell__LuyqR']//button[@type='submit' and text()='Войти']");
    private final SelenideElement registerButton = $(byText("Нет аккаунта"));
//    private final SelenideElement errorMessage = $("[data-testid='error-message']");

    public void login(String email, String password) {
        emailInput.shouldBe(visible).setValue(email);
        passwordInput.shouldBe(visible).setValue(password);
        submitButton.shouldBe(visible).click();
    }

    public void clickRegisterButton() {
        registerButton.shouldBe(visible).click();
    }

//    public String getErrorMessage() {
//        return errorMessage.getText();
//    }


}
