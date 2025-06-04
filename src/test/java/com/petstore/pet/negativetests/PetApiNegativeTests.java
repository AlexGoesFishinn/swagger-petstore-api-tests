package com.petstore.pet.negativetests;

import com.petstore.TestUtils;
import com.petstore.api.PetApiClient;
import com.petstore.model.Pet;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.petstore.TestUtils.*;

class PetApiNegativeTests {

    private static PetApiClient client;

    @BeforeAll
    static void setUp() {
        client = new PetApiClient();
    }

    @Test
    void getByInvalidIdTest() {
        Response response = client.getPetByID(-999);
        assertEquals(400, response.getStatusCode());
    }


    @Test
    void updateByInvalidIdTest() {
        Pet pet = generateRandomPet();
        pet.setId(-1000L);
        Response response = client.updatePet(pet);
        assertEquals(400, response.getStatusCode());
    }

    @Test
    void updateDeletedPetTest() {
        Pet pet = generateRandomPet();
        client.addPet(pet);
        client.deletePet(pet.getId());
        Response response = client.updatePet(pet);
        assertEquals(404, response.getStatusCode());
    }

    @Test
    void deleteInvalidId(){
        Response response = client.deletePet(-1000L);
        assertEquals(400, response.getStatusCode());
    }
    @Test
    void deletePetNotFound(){
        Pet pet = generateRandomPet();
        client.addPet(pet);
        client.deletePet(pet.getId());
        Response response = client.deletePet(pet.getId());
        assertEquals(404, response.getStatusCode());
    }
}






