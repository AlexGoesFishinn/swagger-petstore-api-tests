package com.petstore.api;

import com.petstore.model.Pet;
import com.petstore.model.Status;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetApiClient extends ApiClient {
    private static final String PET_ENDPOINT = "/pet";
    private static final String PET_ENDPOINT_ID = "/pet/{id}";
    private static final String PET_ENDPOINT_STATUS = "/pet/findByStatus";


    public Response getPetByID(long id) {
        return given()
                .when()
                .get(PET_ENDPOINT_ID, id)
                .then()
                .extract()
                .response();
    }

    public Response getPetListByStatus(Status status){
        return given()
                .when()
                .queryParam("status", status)
                .get(PET_ENDPOINT_STATUS)
                .then()
                .extract()
                .response();
    }

    public Response addPet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(PET_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    public Response updatePet(Pet pet) {
        return given()
                .contentType(ContentType.JSON)
                .body(pet).when()
                .put(PET_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    public Response deletePet(long id) {
        return given()
                .when()
                .delete(PET_ENDPOINT_ID, id)
                .then()
                .extract()
                .response();
    }
}
