package com.petstore.api;

import io.restassured.RestAssured;

abstract class ApiClient {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    static {
        RestAssured.baseURI = BASE_URL;
    }
    ApiClient(){}

}
