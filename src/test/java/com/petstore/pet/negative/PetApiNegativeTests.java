package com.petstore.pet.negative;

import com.petstore.TestUtils;
import com.petstore.api.PetApiClient;
import com.petstore.model.Pet;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PetApiNegativeTests {

    private static PetApiClient client;

    @BeforeAll
    static void setUp() {
        client = new PetApiClient();
    }

    @Test
    void getByInvalidIdTest() {
        Response response = client.getPetByID(-999);
        Assertions.assertEquals(400, response.getStatusCode());
    }
    @Test
    void updateByInvalidIdTest(){
        Pet pet = TestUtils.generateRandomPet();
        pet.setId(-1000L);
        Response response = client.updatePet(pet);
        Assertions.assertEquals(400, response.getStatusCode());
    }

    @Test
    void updateDeletedPetTest(){
        Pet pet = TestUtils.generateRandomPet();
        long id = pet.getId();
        client.deletePet(id);
        Response response = client.updatePet(pet);
        Assertions.assertEquals(404, response.getStatusCode());
    }
}






