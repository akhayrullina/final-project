package com.finalproject.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;

public class ApiHelper {
    private static final String API_BASE_URL = ConfigReader.getProperty("api.base.url");

    static {
        RestAssured.baseURI = API_BASE_URL;
    }

    public static Response registerUser(String email, String password) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(Map.of(
                        "email", email,
                        "password", password,
                        "submitPassword", password
                ))
                .post("/api/signup");
    }

    public static Response loginUser(String email, String password) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(Map.of(
                        "email", email,
                        "password", password
                ))
                .post("/api/signin");
    }

    public static String getAuthToken(String email, String password) {
        Response response = loginUser(email, password);
        return response.jsonPath().getString("token");
    }

    public static Response deleteUser(String email, String token) {
        return RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .delete("/api/user/" + email);
    }
}


