package com.finalproject.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;

public class AdPage {
    private final SelenideElement titleNewAd = $x("//h1[text()='Новое объявление']");
    private final SelenideElement uploadPhoto = $x("//button[@type='button' and @class='upload_upload__skfWd']");
    private final SelenideElement nameInput = $x("//input[@name='name' and @placeholder='Название']");
    private final SelenideElement categoryArrow = $x("//input[@name='category']/following-sibling::button[contains(@class, 'dropDownMenu_arrowDown__pfGL1')]");
    //Выбор Состояния товара
    private final SelenideElement newConditionRadio = $("input[name='condition'][value='Новый']");
    private final SelenideElement usedConditionRadio = $("input[name='condition'][value='Б/У']");

    private final SelenideElement cityArrow = $x("//input[@name='city']/following-sibling::button[contains(@class, 'dropDownMenu_arrowDown__pfGL1')]");
    private final SelenideElement descriptionInput = $x("//textarea[@name='description' and @placeholder='Описание товара']");
    private final SelenideElement priceInput = $x("//input[@name='price' and @placeholder='Стоимость']");
    private final SelenideElement adCardButton = $x("//button[@type='submit' and text()='Опубликовать']");
    private final SelenideElement adCard = $x("//div[@class='card']//h2");

    private final SelenideElement editAdButton = $x("//button[@class='editButton' and @type='button']");
    private final SelenideElement saveEditButton = $x("//button[@type='submit' and text()='Сохранить изменения']");
    private final SelenideElement deleteAdButton = $("[data-testid='delete-ad-button']");
    private final SelenideElement confirmDeleteButton = $("[data-testid='confirm-delete-button']");

    public void createAd(String title, String description, String price, String category, String city) {
        nameInput.setValue(title);
        descriptionInput.setValue(description);
        priceInput.setValue(price);
        categorySelect(category);
        citySelect(city);
        adCardButton.click();
    }

    public void editAd(String newTitle, String newDescription, String newPrice) {
        editAdButton.click();
        nameInput.setValue(newTitle);
        descriptionInput.setValue(newDescription);
        priceInput.setValue(newPrice);
        saveEditButton.click();
    }

    public void deleteAd() {
        deleteAdButton.click();
        confirmDeleteButton.click();
    }


    public String getAdTitle() {
        return adCard.getText();
    }

    public SelenideElement getAdCard() {
        return adCard;
    }

    public void categorySelect(String category) {
        categoryArrow.shouldBe(visible).click();
        $x("//div[@class='dropDownMenu_options__CmHmm']/button[contains(@class, 'dropDownMenu_btn__o8ARs')]//span[text()='" + category + "']")
                .shouldBe(visible)
                .click();
    }

    public void citySelect(String city) {
        cityArrow.shouldBe(visible).click();
        $x("//div[@class='dropDownMenu_options__CmHmm']/button[contains(@class, 'dropDownMenu_btn__o8ARs')]//span[text()='" + city + "']")
                .shouldBe(visible)
                .click();
    }
}
