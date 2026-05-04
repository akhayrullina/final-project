package com.finalproject.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Starting scenario: " + scenario.getName());
        Configuration.browserCapabilities.setCapability("pageLoadStrategy", "normal");
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Finishing scenario: " + scenario.getName() +
                " - Status: " + scenario.getStatus());
        Selenide.closeWebDriver();

        try {
            Selenide.clearBrowserCookies();
            Selenide.clearBrowserLocalStorage();
        } catch (Exception e) {
            // Игнорируем, если браузер уже закрыт
        }
    }
}