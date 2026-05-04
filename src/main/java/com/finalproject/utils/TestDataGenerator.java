package com.finalproject.utils;

import net.datafaker.Faker;
import java.util.UUID;

public class TestDataGenerator {
    private static final Faker faker = new Faker();

    public static String generateUniqueEmail() {
        return "test_" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
    }

    public static String generatePassword() {
        return faker.internet().password(8, 12, true, true);
    }

    public static String generateAdTitle() {
        return faker.commerce().productName();
    }

    public static String generateAdDescription() {
        return faker.lorem().sentence(10);
    }

    public static String generateAdPrice() {
        return String.valueOf(faker.number().numberBetween(100, 10000));
    }

    public static String generateAdCategory() {
        String[] categories = {"Авто", "Книги", "Садоводство", "Хобби", "Технологии"};
        return categories[faker.number().numberBetween(0, categories.length - 1)];
    }

    public static String generateAdCity() {
        String[] cities = {"Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Нижний Новгород", "Казань"};
        return cities[faker.number().numberBetween(0, cities.length - 1)];
    }
}