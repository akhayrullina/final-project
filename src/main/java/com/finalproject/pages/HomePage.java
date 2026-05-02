package com.finalproject.pages;

import com.codeborne.selenide.SelenideElement;
import com.finalproject.utils.ConfigReader;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private final String baseUrl = ConfigReader.getProperty("app.base.url");
    private final SelenideElement loginAndRegisterButton = $(byText("Вход и регистрация"));
    private final SelenideElement placeAnAdButton = $(byText("Разместить объявление"));
    private final SelenideElement listOfAds = $(".grid_threeColumns__ldn5D");
    private final SelenideElement searchAdInput = $x("//input[@name='name' and @placeholder='Я хочу купить...']");
    private final SelenideElement applySearchResultsButton = $x("//div[@class='filter_flexRow__X19Fu']/button[text()='Применить']");

    private final SelenideElement toPersonalAccountButton = $(".circleSmall");


    public void clickLoginAndRegisterButton() {
        loginAndRegisterButton.shouldBe(visible).click();
    }

    public void clickPlaceAnAdButton() {
        placeAnAdButton.shouldBe(visible).click();
    }

    public void listOfAdsShouldBeVisible() {
        listOfAds.shouldBe(visible);
    }

    public void toPersonalAccount() {
        toPersonalAccountButton.shouldBe(visible).click();
    }

    public String searchingAd (){
        toPersonalAccount();
        sleep(300);
        return $x("//div[@class='card']/div[@class='description']/div[@class='about']/h2").getText();
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

    public void navigateToCreateAdPage() {
        open(baseUrl + "/create-lisiting");
    }

}
