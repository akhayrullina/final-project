package com.finalproject;

import com.finalproject.pages.HomePage;
import com.finalproject.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @Test
    public void test() {
        open("");
        HomePage homePage = new HomePage();
        homePage.clickLoginAndRegisterButton();

        LoginPage loginPage = new LoginPage();


//        //вход в приложение
        loginPage.login("testtest@mail.ru",
                "1234");


    }
}
