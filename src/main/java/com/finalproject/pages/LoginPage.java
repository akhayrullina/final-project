package com.finalproject.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement emailInput = $("input[name='email']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement submitButton = $x("//div[@class='popUp_buttonRow__+W8JD']/button[@type='submit' and text()='Войти']");
    private final SelenideElement registerButton = $x("//div[@class='popUp_buttonRow__+W8JD']/button[@type='button' and text()='Нет аккаунта']");

    public void login(String email, String password) {
        emailInput.shouldBe(visible).setValue(email);
        passwordInput.shouldBe(visible).setValue(password);
        submitButton.shouldBe(visible).click();
    }

    public void clickRegisterButton() {
        registerButton.shouldBe(visible).click();
    }
}
