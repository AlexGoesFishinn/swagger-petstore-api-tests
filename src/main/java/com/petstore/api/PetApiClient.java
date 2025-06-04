package com.petstore.api;

import com.petstore.model.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetApiClient extends ApiClient {


    public Response getPetByID(long id) {
        return given()
                .when()
                .get("/pet/{id}", id)
                .then()
                .extract()
                .response();
    }

    public Response addPet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post("/pet")
                .then()
                .extract()
                .response();
    }

    public Response updatePet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .body(pet).when()
                .put("/pet")
                .then()
                .extract()
                .response();
    }

    public Response deletePet(long id) {
        return given()
                .when()
                .delete("/pet/{id}", id)
                .then()
                .extract()
                .response();
    }
}
