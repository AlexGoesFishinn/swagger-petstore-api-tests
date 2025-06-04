package com.petstore.api;

import io.restassured.RestAssured;

public class ApiClient {
    public static final String BASE_URL = "https://petstore.swagger.io/v2";

    static {
        RestAssured.baseURI = BASE_URL;
    }

}
