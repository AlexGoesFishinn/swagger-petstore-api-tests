package com.petstore.api;
import io.restassured.RestAssured;

public class ApiClient {
    public final static String BASE_URL = "https://petstore.swagger.io/v2";
    public ApiClient(){
        RestAssured.baseURI = BASE_URL;
    }

}
